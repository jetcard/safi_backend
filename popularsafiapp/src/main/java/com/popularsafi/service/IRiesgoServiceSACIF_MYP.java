package com.popularsafi.service;

import com.popularsafi.model.ReporteRiesgo;

import java.util.List;

public interface IRiesgoServiceSACIF_MYP extends ICRUD<ReporteRiesgo, Long>{
    List<ReporteRiesgo> findAllByFecha(String fecha);
}
