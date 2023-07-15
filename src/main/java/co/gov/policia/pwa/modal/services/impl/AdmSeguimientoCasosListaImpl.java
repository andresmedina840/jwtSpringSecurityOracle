package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.AdmSeguimientoCasosLista;
import co.gov.policia.pwa.modal.payload.response.AdmSeguimientoCasosListaResponse;
import co.gov.policia.pwa.modal.service.AdmSeguimientoCasosListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class AdmSeguimientoCasosListaImpl extends AbstractService implements AdmSeguimientoCasosListaService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    AdmSeguimientoCasosListaService admSeguimientoCasosListaService;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<AdmSeguimientoCasosLista> selectAllAdmSeguimientoCasosLista() {
        List<AdmSeguimientoCasosLista> listadoAdmSeguimientoCasosLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery(
                    "SELECT av.consecutivo, av.porcentaje_avance, av.descripcion_avance, av.estado\r\n"
                            + "from adm_seguimiento_casos av where estado = 'AC' order by 1");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                AdmSeguimientoCasosLista admSeguimientoCasosLista = new AdmSeguimientoCasosLista();
                if (i < lstItems.size()) {
                    admSeguimientoCasosLista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    admSeguimientoCasosLista.setPorcentajeAvance(obj[1] == null ? null : obj[1].toString());
                    admSeguimientoCasosLista.setDescripcionAvance(obj[2] == null ? null : obj[2].toString());
                }
                listadoAdmSeguimientoCasosLista.add(admSeguimientoCasosLista);
                i = i + 1;
            }
        } catch (Exception ex) {

        }
        return listadoAdmSeguimientoCasosLista;
    }

    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public ResponseEntity<?> selectAllAdmSeguimientoCasosListaByConsCaso(Long consCaso) {
        List<AdmSeguimientoCasosLista> listadoAdmSeguimientoCasosLista = new ArrayList<>();
        List<AdmSeguimientoCasosLista> admSeguimientoCasosLista = null;
		Long code = null;
		String mensaje = "";
		Long totalResultados = null;

        try {
        	String consecutivoMaximo = null;
        	//String consecutivoMaximoDePorcentaje = null;
        	
        	Query consecutivoMaximoDePorcentaje = em
                    .createNativeQuery("select * from VW_PWA_SEGUIMIENTO_CASOS where cons_caso = ? and porcentaje = '120%'");

        	consecutivoMaximoDePorcentaje.setParameter(1, consCaso);
        	
        	admSeguimientoCasosLista = consecutivoMaximoDePorcentaje.getResultList();
        	
        	 if (admSeguimientoCasosLista.size() > 0) {            	
             	code = -1L;
				mensaje = "La noticia crimianl ya tiene todos los porcentajes de avances";
				admSeguimientoCasosLista = listadoAdmSeguimientoCasosLista;
				totalResultados = (long) listadoAdmSeguimientoCasosLista.size();
				return ResponseEntity.ok(new AdmSeguimientoCasosListaResponse(admSeguimientoCasosLista, code, mensaje, null));
             } 
        	
            Query consultaMaximo = em
                    .createNativeQuery("select max(consecutivo) from VW_PWA_SEGUIMIENTO_CASOS where cons_caso = ?");

            consultaMaximo.setParameter(1, consCaso);
            
            if (consultaMaximo.getResultList().get(0) == null) {
            	consecutivoMaximo = null;
            } else {
            	consecutivoMaximo = consultaMaximo.getResultList().get(0).toString();
            }

            if (consultaMaximo.getResultList().get(0) == null) {
                Query q1 = em.createNativeQuery(
                        "select porcentaje porcentaje_avance from VW_PWA_SEGUIMIENTO_CASOS where cons_caso = ? order by porcentaje_avance");

                q1.setParameter(1, consCaso);

                List<Object[]> listaVistaSeguimientoCasos = (List<Object[]>) q1.getResultList();

                Query q = em.createNativeQuery(
                        "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' order by 1");

                List<Object[]> listaTablaSeguimientoCasos = (List<Object[]>) q.getResultList();

                listaTablaSeguimientoCasos.removeAll(listaVistaSeguimientoCasos);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < listaTablaSeguimientoCasos.size(); i++) {
                    sb.append("'").append(listaTablaSeguimientoCasos.get(i)).append("'").append(",");
                    // sb.deleteCharAt( sb.length() -1 ).toString();
                }

                sb.deleteCharAt(sb.length() - 1).toString();

                String sqlConsulta = "select av.consecutivo, av.porcentaje_avance, av.descripcion_avance, av.estado " +
                        "from adm_seguimiento_casos av " +
                        "where estado = 'AC' " +
                        "and av.porcentaje_avance in (" + sb + ")" + " order by 1";

                System.out.println("sqlConsulta: " + sqlConsulta);

                Query q3 = em.createNativeQuery(sqlConsulta);

                List<Object[]> lstItems = (List<Object[]>) q3.getResultList();

                int i = 0;
                for (Object[] obj : lstItems) {
                    AdmSeguimientoCasosLista admSeguimientoCasosLista11 = new AdmSeguimientoCasosLista();
                    if (i < lstItems.size()) {
                    	admSeguimientoCasosLista11
                                .setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    	admSeguimientoCasosLista11.setPorcentajeAvance(obj[1] == null ? null : obj[1].toString());
                    	admSeguimientoCasosLista11.setDescripcionAvance(obj[2] == null ? null : obj[2].toString());
                    	admSeguimientoCasosLista11.setEstado(obj[3] == null ? null : obj[3].toString());
                    }
                    listadoAdmSeguimientoCasosLista.add(admSeguimientoCasosLista11);
                    i = i + 1;
                }
            } else {
                Query q1 = em.createNativeQuery(
                        "select porcentaje porcentaje_avance from VW_PWA_SEGUIMIENTO_CASOS where cons_caso = ? and consecutivo = ? order by porcentaje_avance");

                q1.setParameter(1, consCaso);
                q1.setParameter(2, consultaMaximo.getResultList().get(0));

                List<Object[]> listaVistaSeguimientoCasos = (List<Object[]>) q1.getResultList();
                
                String porcentajeEncontrado = q1.getResultList().get(0).toString();
                
                List<Object[]> listaVistaSeguimientoCasos2 = null;
                
                if (porcentajeEncontrado.equals("10%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("20%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("45%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("50%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("55%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("60%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%','60%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("70%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%','60%','70%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("80%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%','60%','70%','80%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                    
                    System.out.println("listaVistaSeguimientoCasos2: " + listaVistaSeguimientoCasos2);
                }
                
                if (porcentajeEncontrado.equals("100%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%','60%','70%','80%','100%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                }
                
                if (porcentajeEncontrado.equals("120%")) {
                    Query q2 = em.createNativeQuery(
                            "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' and av.porcentaje_avance IN ('10%','20%','45%','50%','55%','60%','70%','80%','100%','120%') order by 1");

                    listaVistaSeguimientoCasos2 = (List<Object[]>) q2.getResultList();
                    
                }

                Query q = em.createNativeQuery(
                        "SELECT av.porcentaje_avance from adm_seguimiento_casos av where estado = 'AC' order by 1");

                List<Object[]> listaTablaSeguimientoCasos = (List<Object[]>) q.getResultList();
                
                listaTablaSeguimientoCasos.removeAll(listaVistaSeguimientoCasos2);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < listaTablaSeguimientoCasos.size(); i++) {
                    sb.append("'").append(listaTablaSeguimientoCasos.get(i)).append("'").append(",");
                    // sb.deleteCharAt( sb.length() -1 ).toString();
                }

                sb.deleteCharAt(sb.length() - 1).toString();

                String sqlConsulta = "select av.consecutivo, av.porcentaje_avance, av.descripcion_avance, av.estado " +
                        "from adm_seguimiento_casos av " +
                        "where estado = 'AC' " +
                        "and av.porcentaje_avance in (" + sb + ")" + " order by 1";

                Query q3 = em.createNativeQuery(sqlConsulta);

                List<Object[]> lstItems = (List<Object[]>) q3.getResultList();

                int i = 0;
                for (Object[] obj : lstItems) {
                    AdmSeguimientoCasosLista admSeguimientoCasosLista11 = new AdmSeguimientoCasosLista();
                    if (i < lstItems.size()) {
                    	admSeguimientoCasosLista11.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    	admSeguimientoCasosLista11.setPorcentajeAvance(obj[1] == null ? null : obj[1].toString());
                    	admSeguimientoCasosLista11.setDescripcionAvance(obj[2] == null ? null : obj[2].toString());
                    	admSeguimientoCasosLista11.setEstado(obj[3] == null ? null : obj[3].toString());
                    }
                    listadoAdmSeguimientoCasosLista.add(admSeguimientoCasosLista11);
                    i = i + 1;
                }
            }
            
            if (listadoAdmSeguimientoCasosLista.size() > 0) {
				code = 0L;
				admSeguimientoCasosLista = listadoAdmSeguimientoCasosLista;
				mensaje = "Se ha encontrado informacion";

			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				admSeguimientoCasosLista = listadoAdmSeguimientoCasosLista;
			}
            
            totalResultados = (long) listadoAdmSeguimientoCasosLista.size();
            return ResponseEntity.ok(new AdmSeguimientoCasosListaResponse(admSeguimientoCasosLista, code, mensaje, totalResultados));
        } catch (Exception ex) {
            System.out.println("Error al consultar lista: " + ex.getMessage());
            return ResponseEntity.ok(ex.getMessage());
        }
    }

}
