package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteRiesgo;

import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IRiesgoRepoSACIF_POP;
import com.popularsafi.service.IRiesgoServiceSACIF_POP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReporteRiesgoServiceImpSACIF_POP extends CRUDImpl<ReporteRiesgo, Long> implements IRiesgoServiceSACIF_POP {
    private final IRiesgoRepoSACIF_POP repo;
    @Override
    protected IGenericRepo<ReporteRiesgo, Long> getRepo() {
        return null;
    }

    @Override
    public List<ReporteRiesgo> findAllByFecha(String fecha) {
        return repo.findAllByFecha(fecha);
    }


}
