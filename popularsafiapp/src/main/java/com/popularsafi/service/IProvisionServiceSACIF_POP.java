package com.popularsafi.service;

import com.popularsafi.model.ReporteProvision;
import java.util.List;

public interface IProvisionServiceSACIF_POP extends ICRUD<ReporteProvision, Long>{
    String ejecutarFechaSACIF_POP(String fechaParamSACIF_POP);
    List<ReporteProvision> findAll();
}