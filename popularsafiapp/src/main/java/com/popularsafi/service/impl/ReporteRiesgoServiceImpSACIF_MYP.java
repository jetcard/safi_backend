package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteRiesgo;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IRiesgoRepoSACIF_MYP;
import com.popularsafi.service.IRiesgoServiceSACIF_MYP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReporteRiesgoServiceImpSACIF_MYP extends CRUDImpl<ReporteRiesgo, Long> implements IRiesgoServiceSACIF_MYP {
    private final IRiesgoRepoSACIF_MYP repo;
    @Override
    protected IGenericRepo<ReporteRiesgo, Long> getRepo() {
        return null;
    }

    @Override
    public List<ReporteRiesgo> findAllByFecha(String fecha) {
        return repo.findAllByFecha(fecha);
    }


}
