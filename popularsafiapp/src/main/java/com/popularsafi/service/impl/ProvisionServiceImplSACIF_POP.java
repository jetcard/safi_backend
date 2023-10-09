package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteProvision;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IProvisionRepoSACIF_POP;
import com.popularsafi.service.IProvisionServiceSACIF_POP;
import com.popularsafi.util.Constantes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvisionServiceImplSACIF_POP extends CRUDImpl<ReporteProvision, Long> implements IProvisionServiceSACIF_POP {

    String str="SACIF";//SACIF_POP
    @PersistenceContext
    private EntityManager entityManagerSACIF_POP;
    private final IProvisionRepoSACIF_POP repo;
    @Override
    protected IGenericRepo<ReporteProvision, Long> getRepo() {
        return null;
    }

    public List<ReporteProvision> findAll() {
        return repo.findAll();
    }
    private static final Logger logger= LoggerFactory.getLogger(ProvisionServiceImplSACIF_POP.class.getName());

    @Override
    public String ejecutarFechaSACIF_POP(String fechaParamSACIF_POP) {
        try {
            StoredProcedureQuery storedProcedure = entityManagerSACIF_POP.createStoredProcedureQuery(Constantes.SACIF_POP+".PKG_PROVISIONES.sp_Reporte_Provisiones");
            storedProcedure.registerStoredProcedureParameter("cFProceso", Date.class, ParameterMode.IN);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaProcesoSACIF_POP = dateFormat.parse(fechaParamSACIF_POP);
            logger.info("fechaProceso: " + fechaProcesoSACIF_POP);
            storedProcedure.setParameter("cFProceso", fechaProcesoSACIF_POP);
            storedProcedure.execute();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}