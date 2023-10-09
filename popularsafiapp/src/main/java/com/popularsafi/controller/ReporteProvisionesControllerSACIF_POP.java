package com.popularsafi.controller;

import com.popularsafi.dto.ProvisionDTO;
import com.popularsafi.excel.ExcelProvision;
import com.popularsafi.model.ReporteProvision;
import com.popularsafi.service.IProvisionServiceSACIF_POP;
import com.popularsafi.service.ProvisionResponseRest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/reporte_provisiones/2")
@RequiredArgsConstructor
public class ReporteProvisionesControllerSACIF_POP {
    private static final Logger logger= LoggerFactory.getLogger(ReporteProvisionesControllerSACIF_POP.class.getName());
    @Autowired
    private final IProvisionServiceSACIF_POP servSACIF_POP;

    @Qualifier("provisionMapper")
    private final ModelMapper modelMapper;

    @GetMapping(path = "/json", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvisionDTO>> obtenerProvisionICSACIF_POP(@RequestParam("fechaProceso") String fechaProceso) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        logger.info(LocalDate.parse(fechaProceso, formatter).format(formatter2));
        servSACIF_POP.ejecutarFechaSACIF_POP(LocalDate.parse(fechaProceso, formatter).format(formatter2));
        List<ProvisionDTO> listaSACIF_POP  = servSACIF_POP.findAll().parallelStream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaSACIF_POP, HttpStatus.OK);
    }

    @GetMapping("/xls")
    public void exportToExcel(HttpServletResponse response, @RequestParam("fechaProceso") String fechaProceso) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_category.xlsx";
        response.setHeader(headerKey, headerValue);
        ResponseEntity<ProvisionResponseRest> responseEntity = imprimirReporteFecha();
        ExcelProvision excelExporter = new ExcelProvision(
                responseEntity.getBody().getProvisionResponse().getProvision());
        excelExporter.export(response, LocalDate.parse(fechaProceso, formatter).format(formatter2));
    }

    //@Override
    public ResponseEntity<ProvisionResponseRest> imprimirReporteFecha() {
        ProvisionResponseRest response = new ProvisionResponseRest();
        try {
            List<ReporteProvision> lista  = servSACIF_POP.findAll();
            response.getProvisionResponse().setProvision(lista);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<ProvisionResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ProvisionResponseRest>(response, HttpStatus.OK);
    }

    private ProvisionDTO convertToDto(ReporteProvision obj){
        return modelMapper.map(obj, ProvisionDTO.class);
    }

    private ReporteProvision convertToEntity(ProvisionDTO dto){
        return modelMapper.map(dto, ReporteProvision.class);
    }

}
