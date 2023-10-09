package com.popularsafi.service;

import com.popularsafi.model.ReporteProvision;
import java.util.List;

public interface IProvisionServiceSACIF_MYP extends ICRUD<ReporteProvision, Long>{
    String ejecutarFechaSACIF_MYP(String fechaParamSACIF_MIP);
    List<ReporteProvision> findAll();
}
