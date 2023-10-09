package com.popularsafi.config;

import com.popularsafi.dto.ProvisionDTO;
import com.popularsafi.dto.FondoDTO;
import com.popularsafi.dto.ReporteRiesgoDTO;
import com.popularsafi.model.ReporteProvision;
import com.popularsafi.model.Fondo;
import com.popularsafi.model.ReporteRiesgo;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
    public class MapperConfig {
    private static final Logger logger= LoggerFactory.getLogger(MapperConfig.class.getName());
        @Bean("defaultMapper")
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }

        @Bean("fondoMapper")
        public ModelMapper medicMapper() {
            ModelMapper mapper = new ModelMapper();
            TypeMap<FondoDTO, Fondo> typeMap = mapper.createTypeMap(FondoDTO.class, Fondo.class);
            typeMap.addMapping(FondoDTO::getC_FONDO_ID, (dest, v) -> dest.setC_FONDO_ID((String) v));
            typeMap.addMapping(FondoDTO::getD_FONDO, (dest, v) -> dest.setD_FONDO((String) v));
            return mapper;
        }

        @Bean("provisionMapper")
        public ModelMapper provisionICMapper() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("TimeUnitMillis "+dateFormat.format(System.currentTimeMillis()));
            ModelMapper mapper = new ModelMapper();
            TypeMap<ProvisionDTO, ReporteProvision> typeMap = mapper.createTypeMap(ProvisionDTO.class, ReporteProvision.class);
            typeMap.addMapping(ProvisionDTO::getDVALOR_BV, (dest, v) -> dest.setDVALOR_BV((String) v));
            typeMap.addMapping(ProvisionDTO::getCMONEDA, (dest, v) -> dest.setCMONEDA((String) v));
            typeMap.addMapping(ProvisionDTO::getNCUOTA, (dest, v) -> dest.setNCUOTA((Integer) v));
            typeMap.addMapping(ProvisionDTO::getFDESEMBOLSO, (dest, v) -> dest.setFDESEMBOLSO((String) v));
            typeMap.addMapping(ProvisionDTO::getMONTO, (dest, v) -> dest.setMONTO((String) v));
            typeMap.addMapping(ProvisionDTO::getFPAGO, (src, v) -> src.setFPAGO((String) v));
            typeMap.addMapping(ProvisionDTO::getTEA, (dest, v) -> dest.setTEA((String) v));
            typeMap.addMapping(ProvisionDTO::getDIASTRANS, (dest, v) -> dest.setDIASTRANS((String) v));
            typeMap.addMapping(ProvisionDTO::getINTERES, (dest, v) -> dest.setINTERES((String) v));
            typeMap.addMapping(ProvisionDTO::getINTERESPROV, (dest, v) -> dest.setINTERESPROV((String) v));
            typeMap.addMapping(ProvisionDTO::getIGV, (dest, v) -> dest.setIGV((String) v));
            typeMap.addMapping(ProvisionDTO::getTOTAL, (dest, v) -> dest.setTOTAL((String) v));
            return mapper;
    }

    @Bean("riesgoMapper")
    public ModelMapper riesgosMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<ReporteRiesgoDTO, ReporteRiesgo> typeMap = mapper.createTypeMap(ReporteRiesgoDTO.class, ReporteRiesgo.class);
        typeMap.addMapping(ReporteRiesgoDTO::getCODIGOTCHN, (dest, v) -> dest.setCODIGOTCHN((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCMONEDA, (dest, v) -> dest.setCMONEDA((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getNdocumento, (dest, v) -> dest.setNdocumento((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getTapaterno, (dest, v) -> dest.setTapaterno((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getTamaterno, (dest, v) -> dest.setTamaterno((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getTnombres, (dest, v) -> dest.setTnombres((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getDnacimiento, (dest, v) -> dest.setDnacimiento((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getTdireccion, (dest, v) -> dest.setTdireccion((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCubigeo, (dest, v) -> dest.setCubigeo((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getDepartamento, (dest, v) -> dest.setDepartamento((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getProvincia, (dest, v) -> dest.setProvincia((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getDistrito, (dest, v) -> dest.setDistrito((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCinmueble, (dest, v) -> dest.setCinmueble((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getActividad, (dest, v) -> dest.setActividad((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getSaldo_actual, (dest, v) -> dest.setSaldo_actual((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCuotasatrasdas, (dest, v) -> dest.setCuotasatrasdas((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getEstado, (dest, v) -> dest.setEstado((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCuota, (dest, v) -> dest.setCuota((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getSueldo, (dest, v) -> dest.setSueldo((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getFdesembolso, (dest, v) -> dest.setFdesembolso((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getTipooperacion, (dest, v) -> dest.setTipooperacion((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getS_INFOCORP, (dest, v) -> dest.setS_INFOCORP((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getNVALORIZACION, (dest, v) -> dest.setNVALORIZACION((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getV_EDIFICACION, (dest, v) -> dest.setV_EDIFICACION((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getV_PROPIEDAD, (dest, v) -> dest.setV_PROPIEDAD((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getV_COMERCIAL, (dest, v) -> dest.setV_COMERCIAL((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getV_REALIZACIONSOL, (dest, v) -> dest.setV_REALIZACIONSOL((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getV_REALIZACIONDOL, (dest, v) -> dest.setV_REALIZACIONDOL((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getF_VALORIZACION, (dest, v) -> dest.setF_VALORIZACION((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getUbigeo, (dest, v) -> dest.setUbigeo((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getNcuotas_generadas, (dest, v) -> dest.setNcuotas_generadas((String) v));
        typeMap.addMapping(ReporteRiesgoDTO::getCuotasatrasadas, (dest, v) -> dest.setCuotasatrasadas((String) v));
        return mapper;
    }
}
