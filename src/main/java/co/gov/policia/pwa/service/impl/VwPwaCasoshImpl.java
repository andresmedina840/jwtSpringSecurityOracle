package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.VwPwaCasoshResponse;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaCasos;
import co.gov.policia.pwa.service.VwPwaCasosService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.Date;
import javax.persistence.ParameterMode;

@Service
public class VwPwaCasoshImpl extends AbstractService implements VwPwaCasosService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwPwaCasosService vwPwaCasosService;

    @Override
    @Transactional
    public ResponseEntity<?> insertVwPwaCasos(VwPwaCasos vwPwaCasos, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_CASOS.PR_VWPWACASOSH_INS");

        storedProcedureQuery.registerStoredProcedureParameter("I_NRO_UNICO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NRO_CONSECUTIVO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ANO", String.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_COD_ENTI_RECEP", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COD_ENTI_RECEP", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COD_ENTI_REMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COD_DESPACHO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_PUCA_CODIGO_COMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_BARRIO_COMI", Long.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_LUGE_CODIGO_COMI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LUGE_CODIGO_COMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_NOTICIA", String.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_TIPO_NOTICIA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_DELITO", Long.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_TIPO_DELITO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_DILIGENCIA", String.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_TIPO_DILIGENCIA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_REMITIDO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_REMISION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_DOC_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_RECEP_DEN", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NRO_DOC_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NOMBRES_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CARGO_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_INI_COMI", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_FINAL_COMI", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_INDICIADO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_UBICA1_COMI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_CONNOTACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_VLR_UBICA1_COMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COMP_VLR_UBICA1_COMI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_UBICA2_COMI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_VLR_UBICA2_COMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COMP_VLR_UBICA2_COMI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NRO_UBICACION_COMI", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ZONA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_SITIO_ESPECIFICO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_RELATO_HECHOS", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMPLEADO_AURG", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LUGE_CODIGO_NOTICIA", Long.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_DEPARTAMENTO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CORREO_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_TELEFONO_REMITE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO_JURIS", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO_CONOCE", Long.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_MUNICIPIO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NRO_CASO_ARCHIVO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LEY", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONDICION_CLIMATICA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_COD_UNI_RECEP", Long.class, ParameterMode.IN);
        //storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_CREACION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_MINUTO_FIN_COMISION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_HORA_FIN_COMISION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_MINUTO_INICIO_COMISION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_HORA_INICIO_COMISION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_MINUTO_RECEPCION_DEN", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_HORA_RECEPCION_DEN", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NOMBRE_CASO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ESTADO_CASO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_MOTIVO_ESTADO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_ESTADO", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_CASO_PAPA", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_OBS_DIRECCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LATITUD", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LONGITUD", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_PRIMER_RESPONDIENTE_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CAPTURA_FLAGRANCIA_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_PROGRAMA_EST_HUR", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_EJECUT_EST_HUR", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CLASIFICACION", String.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_CLASIFICACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_OBSERVACIONES_CLASIFICACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CODIGO_MOIP", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_PRIORIZADO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_ASIGNACION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CODIGO_LINEA", Long.class, ParameterMode.IN);
        // storedProcedureQuery.registerStoredProcedureParameter("I_D_CODIGO_LINEA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESCRIPCION_INVES", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_PROYECTADO", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_EJECUTADO", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_OBS_LINEAS", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_BLANCO_ESTRATEGICO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ESTADO_MORED", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_RESPONSABLE_MORED", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ESTRATEGIA_MORED", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_AVANCE_MORED", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_INCIDENTE", Long.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OPERACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OBSERVACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("I_NRO_UNICO", vwPwaCasos.getNroUnico().trim());
        System.out.println("I_NRO_UNICO: " + vwPwaCasos.getNroUnico().trim());

        storedProcedureQuery.setParameter("I_NRO_CONSECUTIVO", vwPwaCasos.getNroConsecutivo());
        System.out.println("I_NRO_CONSECUTIVO: " + vwPwaCasos.getNroConsecutivo());

        storedProcedureQuery.setParameter("I_ANO", vwPwaCasos.getAno());
        System.out.println("I_ANO: " + vwPwaCasos.getAno());

        storedProcedureQuery.setParameter("I_COD_ENTI_RECEP", vwPwaCasos.getCodEntiRecep());
        System.out.println("I_COD_ENTI_RECEP: " + vwPwaCasos.getCodEntiRecep());

        storedProcedureQuery.setParameter("I_COD_ENTI_REMI", vwPwaCasos.getCodEntiRemi());
        System.out.println("I_COD_ENTI_REMI: " + vwPwaCasos.getCodEntiRemi());

        storedProcedureQuery.setParameter("I_COD_DESPACHO", vwPwaCasos.getCodDespacho());
        System.out.println("I_COD_DESPACHO: " + vwPwaCasos.getCodDespacho());

        storedProcedureQuery.setParameter("I_PUCA_CODIGO_COMI", vwPwaCasos.getPucaCodigoComi());
        System.out.println("I_PUCA_CODIGO_COMI: " + vwPwaCasos.getPucaCodigoComi());

        storedProcedureQuery.setParameter("I_CONS_BARRIO_COMI", vwPwaCasos.getConsBarrioComi());
        System.out.println("I_CONS_BARRIO_COMI: " + vwPwaCasos.getConsBarrioComi());

        storedProcedureQuery.setParameter("I_LUGE_CODIGO_COMI", vwPwaCasos.getLugeCodigoComi());
        System.out.println("I_LUGE_CODIGO_COMI: " + vwPwaCasos.getLugeCodigoComi());

        storedProcedureQuery.setParameter("I_USUARIO_CREADOR", vwPwaCasos.getUsuarioCreador());
        System.out.println("I_USUARIO_CREADOR: " + vwPwaCasos.getUsuarioCreador());

        storedProcedureQuery.setParameter("I_UNDE_CODIGO", vwPwaCasos.getUndeCodigo());
        System.out.println("I_UNDE_CODIGO: " + vwPwaCasos.getUndeCodigo());

        storedProcedureQuery.setParameter("I_TIPO_NOTICIA", vwPwaCasos.getTipoNoticia());
        System.out.println("I_TIPO_NOTICIA: " + vwPwaCasos.getTipoNoticia());

        storedProcedureQuery.setParameter("I_TIPO_DELITO", vwPwaCasos.getTipoDelito());
        System.out.println("I_TIPO_DELITO: " + vwPwaCasos.getTipoDelito());

        storedProcedureQuery.setParameter("I_TIPO_DILIGENCIA", vwPwaCasos.getTipoDiligencia());
        System.out.println("I_TIPO_DILIGENCIA: " + vwPwaCasos.getTipoDiligencia());

        storedProcedureQuery.setParameter("I_USUARIO_REMITIDO", vwPwaCasos.getUsuarioRemitido());
        System.out.println("I_USUARIO_REMITIDO: " + vwPwaCasos.getUsuarioRemitido());

        storedProcedureQuery.setParameter("I_FECHA_REMISION", vwPwaCasos.getFechaRemision());
        System.out.println("I_FECHA_REMISION: " + vwPwaCasos.getFechaRemision());

        storedProcedureQuery.setParameter("I_TIPO_DOC_REMITE", vwPwaCasos.getTipoDocRemite());
        System.out.println("I_TIPO_DOC_REMITE: " + vwPwaCasos.getTipoDocRemite());

        storedProcedureQuery.setParameter("I_FECHA_RECEP_DEN", vwPwaCasos.getFechaRecepDen());
        System.out.println("I_FECHA_RECEP_DEN: " + vwPwaCasos.getFechaRecepDen());

        storedProcedureQuery.setParameter("I_NRO_DOC_REMITE", vwPwaCasos.getNroDocRemite());
        System.out.println("I_NRO_DOC_REMITE: " + vwPwaCasos.getNroDocRemite());

        storedProcedureQuery.setParameter("I_NOMBRES_REMITE", vwPwaCasos.getNombresRemite());
        System.out.println("I_NOMBRES_REMITE: " + vwPwaCasos.getNombresRemite());

        storedProcedureQuery.setParameter("I_CARGO_REMITE", vwPwaCasos.getCargoRemite());
        System.out.println("I_CARGO_REMITE: " + vwPwaCasos.getCargoRemite());

        storedProcedureQuery.setParameter("I_FECHA_INI_COMI", vwPwaCasos.getFechaIniComi());
        System.out.println("I_FECHA_INI_COMI: " + vwPwaCasos.getFechaIniComi());

        storedProcedureQuery.setParameter("I_FECHA_FINAL_COMI", vwPwaCasos.getFechaFinalComi());
        System.out.println("I_FECHA_FINAL_COMI: " + vwPwaCasos.getFechaFinalComi());

        storedProcedureQuery.setParameter("I_TIPO_INDICIADO", vwPwaCasos.getTipoIndiciado());
        System.out.println("I_TIPO_INDICIADO: " + vwPwaCasos.getTipoIndiciado());

        storedProcedureQuery.setParameter("I_TIPO_UBICA1_COMI", vwPwaCasos.getTipoUbica1Comi());

        storedProcedureQuery.setParameter("I_TIPO_CONNOTACION", vwPwaCasos.getTipoConnotacion());

        storedProcedureQuery.setParameter("I_VLR_UBICA1_COMI", vwPwaCasos.getVlrUbica1Comi());

        storedProcedureQuery.setParameter("I_COMP_VLR_UBICA1_COMI", vwPwaCasos.getCompVlrUbica1Comi());

        storedProcedureQuery.setParameter("I_TIPO_UBICA2_COMI", vwPwaCasos.getTipoUbica2Comi());

        storedProcedureQuery.setParameter("I_VLR_UBICA2_COMI", vwPwaCasos.getVlrUbica2Comi());

        storedProcedureQuery.setParameter("I_COMP_VLR_UBICA2_COMI", vwPwaCasos.getCompVlrUbica2Comi());

        storedProcedureQuery.setParameter("I_NRO_UBICACION_COMI", vwPwaCasos.getNroUbicacionComi());

        storedProcedureQuery.setParameter("I_ZONA", vwPwaCasos.getZona());

        storedProcedureQuery.setParameter("I_SITIO_ESPECIFICO", vwPwaCasos.getSitioEspecifico());

        storedProcedureQuery.setParameter("I_RELATO_HECHOS", vwPwaCasos.getRelatoHechos());

        storedProcedureQuery.setParameter("I_CONS_EMPLEADO_AURG", vwPwaCasos.getConsEmpleadoAurg());

        storedProcedureQuery.setParameter("I_LUGE_CODIGO_NOTICIA", vwPwaCasos.getLugeCodigoNoticia());

        storedProcedureQuery.setParameter("I_CORREO_REMITE", vwPwaCasos.getCorreoRemite());

        storedProcedureQuery.setParameter("I_TELEFONO_REMITE", vwPwaCasos.getTelefonoRemite());

        storedProcedureQuery.setParameter("I_UNDE_CODIGO_JURIS", vwPwaCasos.getUndeCodigoJuris());

        storedProcedureQuery.setParameter("I_UNDE_CODIGO_CONOCE", vwPwaCasos.getUndeCodigoConoce());

        storedProcedureQuery.setParameter("I_NRO_CASO_ARCHIVO", vwPwaCasos.getNroCasoArchivo());

        storedProcedureQuery.setParameter("I_LEY", vwPwaCasos.getLey());

        storedProcedureQuery.setParameter("I_CONDICION_CLIMATICA", vwPwaCasos.getCondicionClimatica());

        storedProcedureQuery.setParameter("I_COD_UNI_RECEP", vwPwaCasos.getCodUniRecep());

        storedProcedureQuery.setParameter("I_MINUTO_FIN_COMISION", vwPwaCasos.getMinutoFinComision());

        storedProcedureQuery.setParameter("I_HORA_FIN_COMISION", vwPwaCasos.getHoraFinComision());

        storedProcedureQuery.setParameter("I_MINUTO_INICIO_COMISION", vwPwaCasos.getMinutoInicioComision());

        storedProcedureQuery.setParameter("I_HORA_INICIO_COMISION", vwPwaCasos.getHoraInicioComision());

        storedProcedureQuery.setParameter("I_MINUTO_RECEPCION_DEN", vwPwaCasos.getMinutoRecepcionDen());

        storedProcedureQuery.setParameter("I_HORA_RECEPCION_DEN", vwPwaCasos.getHoraRecepcionDen());

        storedProcedureQuery.setParameter("I_NOMBRE_CASO", vwPwaCasos.getNombreCaso());

        storedProcedureQuery.setParameter("I_ESTADO_CASO", vwPwaCasos.getEstadoCaso());

        storedProcedureQuery.setParameter("I_MOTIVO_ESTADO", vwPwaCasos.getMotivoEstado());

        storedProcedureQuery.setParameter("I_FECHA_ESTADO", vwPwaCasos.getFechaEstado());

        storedProcedureQuery.setParameter("I_CONS_CASO_PAPA", vwPwaCasos.getConsCasoPapa());

        storedProcedureQuery.setParameter("I_OBS_DIRECCION", vwPwaCasos.getObsDireccion());

        storedProcedureQuery.setParameter("I_LATITUD", vwPwaCasos.getLatitud());

        storedProcedureQuery.setParameter("I_LONGITUD", vwPwaCasos.getLongitud());

        storedProcedureQuery.setParameter("I_PRIMER_RESPONDIENTE_ID", vwPwaCasos.getPrimerRespondienteId());

        storedProcedureQuery.setParameter("I_CAPTURA_FLAGRANCIA_ID", vwPwaCasos.getCapturaFlagranciaId());

        storedProcedureQuery.setParameter("I_FECHA_PROGRAMA_EST_HUR", vwPwaCasos.getFechaProgramaEstHur());

        storedProcedureQuery.setParameter("I_FECHA_EJECUT_EST_HUR", vwPwaCasos.getFechaEjecutEstHur());

        storedProcedureQuery.setParameter("I_CLASIFICACION", vwPwaCasos.getClasificacion());

        storedProcedureQuery.setParameter("I_OBSERVACIONES_CLASIFICACION", vwPwaCasos.getObservacionesClasificacion());

        storedProcedureQuery.setParameter("I_CODIGO_MOIP", vwPwaCasos.getCodigoMoip());

        storedProcedureQuery.setParameter("I_PRIORIZADO", vwPwaCasos.getPriorizado());

        storedProcedureQuery.setParameter("I_FECHA_ASIGNACION", vwPwaCasos.getFechaAsignacion());

        storedProcedureQuery.setParameter("I_CODIGO_LINEA", vwPwaCasos.getCodigoLinea());

        storedProcedureQuery.setParameter("I_DESCRIPCION_INVES", vwPwaCasos.getDescripcionInves());

        storedProcedureQuery.setParameter("I_FECHA_PROYECTADO", vwPwaCasos.getFechaProyectado());

        storedProcedureQuery.setParameter("I_FECHA_EJECUTADO", vwPwaCasos.getFechaEjecutado());

        storedProcedureQuery.setParameter("I_OBS_LINEAS", vwPwaCasos.getObsLineas());

        storedProcedureQuery.setParameter("I_BLANCO_ESTRATEGICO", vwPwaCasos.getBlancoEstrategico());

        storedProcedureQuery.setParameter("I_ESTADO_MORED", vwPwaCasos.getEstadoMored());

        storedProcedureQuery.setParameter("I_RESPONSABLE_MORED", vwPwaCasos.getResponsableMored());

        storedProcedureQuery.setParameter("I_ESTRATEGIA_MORED", vwPwaCasos.getEstrategiaMored());

        storedProcedureQuery.setParameter("I_AVANCE_MORED", vwPwaCasos.getAvanceMored());

        storedProcedureQuery.setParameter("I_CONS_INCIDENTE", vwPwaCasos.getConsIncidente());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");
        System.out.println("responseDescription: " + responseDescription);

        long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");
        System.out.println("responseConsecutivo: " + responseConsecutivo);

        return ResponseEntity.ok(new VwPwaCasoshResponse(null, response, responseDescription, responseConsecutivo));
    }

}