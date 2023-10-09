package com.popularsafi.service.impl;

import com.popularsafi.model.ReporteProvision;
import com.popularsafi.repository.IGenericRepo;
import com.popularsafi.repository.IProvisionRepoSACIF_PRH;
import com.popularsafi.service.IProvisionServiceSACIF_PRH;
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
public class ProvisionServiceImplSACIF_PRH extends CRUDImpl<ReporteProvision, Long> implements IProvisionServiceSACIF_PRH {
    @PersistenceContext
    private EntityManager entityManagerSACIF_PRH;
    private final IProvisionRepoSACIF_PRH repoSACIF_PRH;
    @Override
    protected IGenericRepo<ReporteProvision, Long> getRepo() {
        return null;
    }

    public List<ReporteProvision> findAll() {
        return repoSACIF_PRH.findAll();
    }
    private static final Logger logger= LoggerFactory.getLogger(ProvisionServiceImplSACIF_PRH.class.getName());
    @Override
    public String ejecutarFechaSACIF_PRH(String fechaParamSACIF_PRH) {
        try {
            StoredProcedureQuery storedProcedure = entityManagerSACIF_PRH.createStoredProcedureQuery(Constantes.SACIF_PRH+".PKG_PROVISIONES.sp_Reporte_Provisiones");
            storedProcedure.registerStoredProcedureParameter("cFProceso", Date.class, ParameterMode.IN);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaProcesoSACIF_PRH = dateFormat.parse(fechaParamSACIF_PRH);
            logger.info("fechaProceso: " + fechaProcesoSACIF_PRH);
            storedProcedure.setParameter("cFProceso", fechaProcesoSACIF_PRH);
            storedProcedure.execute();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}