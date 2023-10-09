package com.popularsafi.service;

import com.popularsafi.model.ReporteProvision;
import java.util.List;

public interface IProvisionServiceSACIF_PRH extends ICRUD<ReporteProvision, Long>{
    String ejecutarFechaSACIF_PRH(String fechaParamSACIF_PRH);
    List<ReporteProvision> findAll();
}
