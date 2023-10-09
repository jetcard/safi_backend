package com.popularsafi.repository;

import com.popularsafi.model.ReporteRiesgo;
import com.popularsafi.util.Constantes;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRiesgoRepo extends IGenericRepo<ReporteRiesgo, Long>  {
    @Query(value =
        "SELECT RTRIM(ALT.DVALOR_BV) as CODIGOTCHN" +
        ", DECODE(ALT.CMONEDA, '0001', 'S/.', '0002', '$.') AS CMONEDA" +
        ", doc.ndocumento" +
        ", per.tapaterno" +
        ", per.tamaterno" +
        ", per.tnombres" +
        ", TO_CHAR(per.dnacimiento) as dnacimiento" +
        ", inm.tdireccion" +
        ", inm.cubigeo" +
        ", TRIM(u.departamento) AS departamento" +
        ", TRIM(u.provincia) AS  provincia " +
        ", TRIM(u.distrito) AS distrito " +
        ", to_char(inm.cinmueble) cinmueble" +
        ", RTRIM(c.dciiu) as actividad" +
        ", to_char(tmp.saldo_actual) saldo_actual" +
        ", to_char("+ Constantes.SACIF +".SF_NUMCUOATR_INVFEC(mi.ninversion,to_date(?1, 'DD/MM/YYYY'))) cuotasatrasdas" +
        ", to_char("+ Constantes.SACIF +".sf_estado_inversion(mi.NINVERSION,to_date(?1, 'DD/MM/YYYY'))) estado" +
        ", to_char("+ Constantes.SACIF +".SF_MONTO_CUOTA_PAGO(mi.NINVERSION)) cuota" +
        ", to_char(Per.PROMINGRESO) SUELDO" +
        ", to_char(alt.fcolocan) fdesembolso" +
        ", TRIM(to_char(TG.DDESCRIPCION)) AS tipooperacion" +
        ", TRIM(PEC.S_INFOCORP) as S_INFOCORP " +
        ", to_char(V.NVALORIZACION) as NVALORIZACION" +
        ", to_char(V.MAPRECIACION_COMERCIAL) AS V_EDIFICACION" +
        ", to_char(V.MVALOR_TERRENO) AS V_PROPIEDAD" +
        ", to_char(V.MVALOR_COMERCIAL) AS V_COMERCIAL" +
        ", to_char(V.MVALOR_REALIZACION) AS V_REALIZACIONSOL" +
        ", to_char(V.MVALORDOL_REALIZA) AS V_REALIZACIONDOL" +
        ", to_char(V.DVALORIZACION) AS F_VALORIZACION" +
        ",  RTRIM(to_char(U.DUBIGEO )) ubigeo " +
        ", to_char(mi.ncuotas_generadas) as ncuotas_generadas" +
        ", to_char("+ Constantes.SACIF +".SF_NUMCUOATR_INVFEC(mi.ninversion,to_date(?1, 'DD/MM/YYYY')) ) cuotasatrasadas " +
        ", '"+ Constantes.SACIF_DESCRIP +"' as FONDO " +
        "FROM "+ Constantes.SACIF +".alternativa_inversion ALT " +
        "LEFT JOIN "+ Constantes.SACIF +".MAESTRO_INVERSION MI " +
        "ON MI.DVALOR_BV = ALT.DVALOR_BV " +
        "LEFT JOIN "+ Constantes.SACIF +".tmp_saldo_deudor sd " +
        "ON sd.DVALOR_BV = ALT.DVALOR_BV AND sd.fecha = to_date(?1, 'DD/MM/YYYY') " +
        "LEFT JOIN "+ Constantes.SACIF +".VALORIZACION V " +
        "ON V.CINMUEBLE = ALT.CINMUEBLE AND dvalorizacion = ( " +
        "SELECT MAX(dvalorizacion) " +
        "FROM "+ Constantes.SACIF +".VALORIZACION " +
        "WHERE cinmueble = v.cinmueble " +
        "AND dvalorizacion < to_date(?1, 'DD/MM/YYYY')) " +
        "LEFT JOIN "+ Constantes.SACIF +".INMUEBLE I " +
        "ON I.CINMUEBLE = ALT.CINMUEBLE " +
        "LEFT JOIN "+ Constantes.SACIF +".UBIGEO U " +
        "ON U.CUBIGEO = I.CUBIGEO " +
        "INNER JOIN "+ Constantes.SACIF +".persona per " +
        "ON per.cpersona = alt.cpersona " +
        "INNER JOIN "+ Constantes.SACIF +".documento doc " +
        "ON doc.cpersona = per.cpersona " +
        "INNER JOIN "+ Constantes.SACIF +".inmueble inm " +
        "ON inm.cinmueble = alt.cinmueble " +
        "LEFT JOIN "+ Constantes.SACIF +".TMP_SALDO_DEUDOR tmp " +
        "ON tmp.dvalor_bv = mi.dvalor_bv AND tmp.fecha = to_date(?1, 'DD/MM/YYYY') " +
        "LEFT JOIN spla.ubigeo_homologacion u " +
        "ON inm.cubigeo = u.ubigeo_saciv " +
        "LEFT JOIN "+ Constantes.SACIF +".PERSONA_ILABORAL pi " +
        "ON pi.cpersona = per.cpersona " +
        "LEFT JOIN "+ Constantes.SACIF +".ciiu c " +
        "ON pi.s_cod_act_econo = c.cciiu " +
        "LEFT JOIN "+ Constantes.SACIF +".PERSONA_ECFINAN PEC " +
        "ON PEC.CPERSONA = Per.CPERSONA " +
        "LEFT JOIN "+ Constantes.SACIF +".documento doc " +
        "ON per.cpersona = doc.cpersona " +
        "LEFT JOIN "+ Constantes.SACIF +".tablas_generales TG " +
        "ON TG.CTABLA = '0608' AND alt.TIP_OPERACION = TG.CARGUM " +
        "WHERE ALt.dvalor_bv like '%TCHN%' " +
        "AND (NVL(FCANCELADO, 'N') = 'N' OR (NVL(FCANCELADO, 'N') = 'S' AND DCANCELADO >= to_date(?1, 'DD/MM/YYYY'))" +
        ")",  nativeQuery = true)
    List<ReporteRiesgo> findAllByFecha(String fecha);
}
