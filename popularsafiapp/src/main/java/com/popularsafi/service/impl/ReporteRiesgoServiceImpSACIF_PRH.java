package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteRiesgo;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IRiesgoRepoSACIF_PRH;
import com.popularsafi.service.IRiesgoServiceSACIF_PRH;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReporteRiesgoServiceImpSACIF_PRH extends CRUDImpl<ReporteRiesgo, Long> implements IRiesgoServiceSACIF_PRH {
    private final IRiesgoRepoSACIF_PRH repo;
    @Override
    protected IGenericRepo<ReporteRiesgo, Long> getRepo() {
        return null;
    }

    @Override
    public List<ReporteRiesgo> findAllByFecha(String fecha) {
        return repo.findAllByFecha(fecha);
    }


}
