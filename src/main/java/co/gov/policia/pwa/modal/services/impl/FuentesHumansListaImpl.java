package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.CiudadLista;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.InvestigadoresLista;
import co.gov.policia.pwa.modal.entity.PaisLista;
import co.gov.policia.pwa.modal.entity.ProcesoInvestigativoLista;
import co.gov.policia.pwa.modal.entity.VwPwaPermisosFuenteHumana;
import co.gov.policia.pwa.modal.payload.response.FuentesHumanasListaResponse;
import co.gov.policia.pwa.modal.payload.response.FuentesHumanasResponse;
import co.gov.policia.pwa.modal.service.FuentesHumanasListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class FuentesHumansListaImpl extends AbstractService implements FuentesHumanasListaService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    FuentesHumanasListaService fuentesHumanasListaService;
   
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ResponseEntity<?> fuentesHumanasByUsuario(Long consecutivo) {
        List<VwPwaPermisosFuenteHumana> listaVwPwaPermisosFuenteHumana = new ArrayList<>();

        Long code = null;
        String mensaje = "";

        try {
            Query q = em.createNativeQuery("SELECT * FROM VW_PWA_PERMISOS_FUENTE_HUMANA where investigador = ?", VwPwaPermisosFuenteHumana.class);

            q.setParameter(1, consecutivo);

            listaVwPwaPermisosFuenteHumana = q.getResultList();
            
            if (listaVwPwaPermisosFuenteHumana.size() > 0) {
                code = 0L;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                listaVwPwaPermisosFuenteHumana = new ArrayList<>(); 
            }
            Long totalDeRegistros = (long) listaVwPwaPermisosFuenteHumana.size();
            return ResponseEntity.ok(new FuentesHumanasResponse(listaVwPwaPermisosFuenteHumana, code, mensaje, totalDeRegistros));          
        } catch (Exception ex) {
        	System.out.println("Error al consultar: " + ex.getMessage());
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<ProcesoInvestigativoLista> procesoInvetigativoByNroUnico(String nroUnico) {
        List<ProcesoInvestigativoLista> procesoInvestigativoLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT c.consecutivo, c.nro_unico FROM vw_pwa_valida_nro_unico c\r\n"
                    + "WHERE nro_unico = ?");

            q.setParameter(1, nroUnico);

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                ProcesoInvestigativoLista procesoInvestigativoLista1 = new ProcesoInvestigativoLista();
                if (i < lstItems.size()) {
                    procesoInvestigativoLista1
                            .setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    procesoInvestigativoLista1.setNroUnico(obj[1] == null ? null : obj[1].toString());
                }
                procesoInvestigativoLista.add(procesoInvestigativoLista1);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de ProcesoInvestigativoLista. " + ex.getMessage());
        }
        return procesoInvestigativoLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ResponseEntity<?> invetigadoresByIdentificacion(Long identificacion) {
        List<InvestigadoresLista> listaInvestigadoresLista = new ArrayList<>();
        //InvestigadoresLista investigadoresLista = null;
        Long code = null;
        String mensaje = "";

        try {
            Query q = em.createNativeQuery(
                    "SELECT E.CONSECUTIVO, E.IDENTIFICACION, G.ALFABETICO || '. ' || E.NOMBRES FUNCIONARIO      \r\n"
                            + "FROM EMPLEADOS_SIPAC E, ADM_GRADOS G\r\n"
                            + "WHERE G.CODIGO = E.GRAD_ALFABETICO \r\n"
                            + "AND E.IDENTIFICACION = ?");

            q.setParameter(1, identificacion);

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                InvestigadoresLista InvestigadoresLista1 = new InvestigadoresLista();
                if (i < lstItems.size()) {
                    InvestigadoresLista1.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    InvestigadoresLista1.setIdentificacion(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
                    InvestigadoresLista1.setFuncionario(obj[2] == null ? null : obj[2].toString());
                }
                listaInvestigadoresLista.add(InvestigadoresLista1);
                i = i + 1;
            }
            
            if (listaInvestigadoresLista.size() > 0) {
                code = 0L;
                //investigadoresLista = listaInvestigadoresLista.get(0);
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
            }
            return ResponseEntity.ok(new FuentesHumanasListaResponse(listaInvestigadoresLista, code, mensaje));          
        } catch (Exception ex) {
        	System.out.println("Error al consultar: " + ex.getMessage());
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @SuppressWarnings({"unchecked" })
    @Override
    @Transactional
    public ResponseEntity<?> invetigadores2ByIdentificacion2(Long identificacion, Long identificacion2) {
        List<InvestigadoresLista> listaInvestigadoresLista = new ArrayList<>();
        
        //InvestigadoresLista investigadoresLista = null;
        Long code = null;
        String mensaje = "";

        System.out.println("identificacion: " + identificacion);
        System.out.println("identificacion2: " + identificacion2);

        try {

            if (identificacion.equals(identificacion2)) {
            	code = -1L;
                String mensajeError = "Por favor seleccione otra identificacion distinta a la del investigador(a) Uno.";
                
                listaInvestigadoresLista = new ArrayList<>();
                
                return ResponseEntity.ok(new FuentesHumanasListaResponse(listaInvestigadoresLista, code, mensajeError));
            
            } else {

                Query q = em.createNativeQuery(
                        "SELECT E.CONSECUTIVO, E.IDENTIFICACION, G.ALFABETICO || '. ' || E.NOMBRES FUNCIONARIO      \r\n"
                                + "FROM EMPLEADOS_SIPAC E, ADM_GRADOS G\r\n"
                                + "WHERE G.CODIGO = E.GRAD_ALFABETICO \r\n"
                                + "AND E.IDENTIFICACION = ?");

                q.setParameter(1, identificacion2);

                List<Object[]> lstItems = (List<Object[]>) q.getResultList();

                int i = 0;
                for (Object[] obj : lstItems) {
                    InvestigadoresLista InvestigadoresLista1 = new InvestigadoresLista();
                    if (i < lstItems.size()) {
                        InvestigadoresLista1.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                        InvestigadoresLista1
                                .setIdentificacion(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
                        InvestigadoresLista1.setFuncionario(obj[2] == null ? null : obj[2].toString());
                    }
                    listaInvestigadoresLista.add(InvestigadoresLista1);
                    i = i + 1;
                }
                
                if (listaInvestigadoresLista.size() > 0) {
                    code = 0L;
                    //investigadoresLista = listaInvestigadoresLista.get(0);
                    mensaje = "Se ha encontrado informacion";
                } else {
                    code = 2L;
                    mensaje = "No se ha encontrado información.";
                    listaInvestigadoresLista = new ArrayList<>();
                }
                return ResponseEntity.ok(new FuentesHumanasListaResponse(listaInvestigadoresLista, code, mensaje));
            }
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<PaisLista> selectAllPais() {
        List<PaisLista> listadoPaisLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT LG.CODIGO,LG.DESCRIPCION\r\n"
                    + "FROM ADM_LUGARES_GEOGRAFICOS LG\r\n"
                    + "WHERE LG.TIPO='PA'\r\n"
                    + "ORDER BY DESCRIPCION");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                PaisLista paisLista = new PaisLista();
                if (i < lstItems.size()) {
                    paisLista.setCodigo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    paisLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
                }
                listadoPaisLista.add(paisLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de listadoPaisLista. " + ex.getMessage());
        }
        return listadoPaisLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<DepartamentosLista> departamentoByCodigoPais(Long codigoPais) {
        List<DepartamentosLista> listadoDepartamentosLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT LG.CODIGO DEPARTAMENTO_ID,LG.DESCRIPCION DEPARTAMENTO\r\n"
                    + "FROM ADM_LUGARES_GEOGRAFICOS LG\r\n"
                    + "WHERE LG.TIPO='DE'\r\n"
                    + "AND LG.LUGE_CODIGO=?\r\n"
                    + "ORDER BY DESCRIPCION");

            q.setParameter(1, codigoPais);

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                DepartamentosLista departamentosLista = new DepartamentosLista();
                if (i < lstItems.size()) {
                    departamentosLista.setDepartamentoId(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    departamentosLista.setDepartamento(obj[1] == null ? null : obj[1].toString());
                }
                listadoDepartamentosLista.add(departamentosLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de listadoDepartamentosLista. " + ex.getMessage());
        }
        return listadoDepartamentosLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<CiudadLista> ciudadByCodigoDepartamento(Long codigoDepartamento) {
        List<CiudadLista> listadoCiudadLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT LG.CODIGO CIUDAD_ID,UPPER(LG.DESCRIPCION) CIUDAD\r\n"
                    + "FROM ADM_LUGARES_GEOGRAFICOS LG\r\n"
                    + "WHERE LG.TIPO='CM'\r\n"
                    + "AND LG.LUGE_CODIGO=?");

            q.setParameter(1, codigoDepartamento);

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                CiudadLista ciudadLista = new CiudadLista();
                if (i < lstItems.size()) {
                    ciudadLista.setCiudadId(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    ciudadLista.setCiudad(obj[1] == null ? null : obj[1].toString());
                }
                listadoCiudadLista.add(ciudadLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de listadoDepartamentosLista. " + ex.getMessage());
        }
        return listadoCiudadLista;
    }

}
