package com.popularsafi.service;

import com.popularsafi.model.ReporteRiesgo;
import lombok.Data;

import java.util.List;

@Data
public class RiesgoResponse {

    List<ReporteRiesgo> riesgo;

    public List<ReporteRiesgo> getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(List<ReporteRiesgo> riesgo) {
        this.riesgo = riesgo;
    }
}

