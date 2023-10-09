package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteProvision;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IProvisionRepoSACIF_MYP;
import com.popularsafi.service.IProvisionServiceSACIF_MYP;
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
public class ProvisionServiceImplSACIF_MYP extends CRUDImpl<ReporteProvision, Long> implements IProvisionServiceSACIF_MYP {
    @PersistenceContext
    private EntityManager entityManagerSACIF_MYP;
    private final IProvisionRepoSACIF_MYP repo;

    @Override
    protected IGenericRepo<ReporteProvision, Long> getRepo() {
        return null;
    }

    public List<ReporteProvision> findAll() {
        return repo.findAll();
    }

    private static final Logger logger= LoggerFactory.getLogger(ProvisionServiceImplSACIF_MYP.class.getName());
    @Override
    public String ejecutarFechaSACIF_MYP(String fechaParamSACIF_MYP) {
        try {
            StoredProcedureQuery storedProcedure = entityManagerSACIF_MYP.createStoredProcedureQuery(Constantes.SACIF_MYP+".PKG_PROVISIONES.sp_Reporte_Provisiones");
            storedProcedure.registerStoredProcedureParameter("cFProceso", Date.class, ParameterMode.IN);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaProcesoSACIF_MYP = dateFormat.parse(fechaParamSACIF_MYP);
            logger.info("fechaProceso: " + fechaProcesoSACIF_MYP);
            storedProcedure.setParameter("cFProceso", fechaProcesoSACIF_MYP);
            storedProcedure.execute();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}