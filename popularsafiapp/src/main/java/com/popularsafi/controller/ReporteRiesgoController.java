package com.popularsafi.controller;

import com.popularsafi.dto.ReporteRiesgoDTO;
import com.popularsafi.excel.ExcelRiesgos;
import com.popularsafi.model.ReporteRiesgo;

import com.popularsafi.service.IRiesgoService;
import com.popularsafi.service.RiesgoResponseRest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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

import org.modelmapper.ModelMapper;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/reporte_riesgos/1")
@RequiredArgsConstructor
public class ReporteRiesgoController {
    private static final Logger logger= LoggerFactory.getLogger(ReporteRiesgoController.class.getName());
    @Autowired
    private final IRiesgoService servSACIF;
    @Qualifier("riesgoMapper")
    private final ModelMapper modelMapper;
    @GetMapping (path = "/json", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReporteRiesgoDTO>> obtenerReporteRiesgo(@RequestParam("fechaProceso") String fechaProceso) {
        List<ReporteRiesgoDTO> ListReporteRiesgo = servSACIF.findAllByFecha(fechaProceso).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(ListReporteRiesgo,HttpStatus.OK);
    }
    @GetMapping(path = "/xls")
    public void exportToExcel(HttpServletResponse response, @RequestParam("fechaProceso") String fechaProceso) throws IOException {
        DateTimeFormatter fechaEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter fechaSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_category.xlsx";
        response.setHeader(headerKey, headerValue);
        ResponseEntity<RiesgoResponseRest> responseEntity = imprimirReporteFecha(fechaProceso);
        ExcelRiesgos excelExporter = new ExcelRiesgos(
                responseEntity.getBody().getRiesgoResponse().getRiesgo());
        excelExporter.export(response, LocalDate.parse(fechaProceso, fechaEntrada).format(fechaSalida));
    }

    public ResponseEntity<RiesgoResponseRest> imprimirReporteFecha(String fechaProceso) {
        RiesgoResponseRest response = new RiesgoResponseRest();
        try {
            List<ReporteRiesgo> lista  = servSACIF.findAllByFecha(fechaProceso);
            response.getRiesgoResponse().setRiesgo(lista);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<RiesgoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RiesgoResponseRest>(response, HttpStatus.OK);
    }

    private ReporteRiesgoDTO convertToDto(ReporteRiesgo obj){
        return modelMapper.map(obj, ReporteRiesgoDTO.class);
    }

    private ReporteRiesgo convertToEntity(ReporteRiesgoDTO dto){
        return modelMapper.map(dto, ReporteRiesgo.class);
    }
}