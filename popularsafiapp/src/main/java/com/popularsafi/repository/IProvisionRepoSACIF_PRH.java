package com.popularsafi.repository;

import com.popularsafi.model.ReporteProvision;
import com.popularsafi.util.Constantes;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IProvisionRepoSACIF_PRH extends IGenericRepo<ReporteProvision, Long> {
    @Query(value =
            "SELECT DVALOR_BV, CMONEDA, " +
                    " NCUOTA, " +
                    " TO_CHAR(FDESEMBOLSO, 'DD/MM/YYYY') AS  FDESEMBOLSO, " +
                    " TO_CHAR(MONTO, 'FM9999999999990.00') AS MONTO, " +
                    " TO_CHAR(FPAGO, 'DD/MM/YYYY') AS FPAGO," +
                    " TO_CHAR(TEA, 'FM9990.00') AS TEA," +
                    " TO_CHAR(DIASTRANS, 'FM9990.00') AS DIASTRANS, " +
                    " TO_CHAR(INTERES, 'FM9990.00') AS INTERES, "+
                    " TO_CHAR(INTERESPROV, 'FM9990.00') AS INTERESPROV, "+
                    " TO_CHAR(ROUND(IGV,2), 'FM9990.00') AS IGV, "+
                    " TO_CHAR(ROUND(TOTAL,2), 'FM9990.00') AS TOTAL "+
                    " FROM "+ Constantes.SACIF_PRH+".TMP_CALCULO_IC2 WHERE INTERESPROV != 0 ", nativeQuery = true)
    List<ReporteProvision> findAll();
}
