package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteRiesgo;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IRiesgoRepo;
import com.popularsafi.service.IRiesgoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReporteRiesgoServiceImp extends CRUDImpl<ReporteRiesgo, Long> implements IRiesgoService {
    private final IRiesgoRepo repo;
    @Override
    protected IGenericRepo<ReporteRiesgo, Long> getRepo() {
        return null;
    }
    @Override
    public List<ReporteRiesgo> findAllByFecha(String fecha) {
        return repo.findAllByFecha(fecha);
    }


}
