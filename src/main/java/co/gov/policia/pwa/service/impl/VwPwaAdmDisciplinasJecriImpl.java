package co.gov.policia.pwa.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri1Lista;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri2Lista;
import co.gov.policia.pwa.entity.VwPwaUbicaDiciplixRegion;
import co.gov.policia.pwa.modal.entity.VwPwaProcedimientosJecriLista;
import co.gov.policia.pwa.service.VwPwaAdmDisciplinasJecriService;

@Service
public class VwPwaAdmDisciplinasJecriImpl extends AbstractService implements VwPwaAdmDisciplinasJecriService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwPwaAdmDisciplinasJecriService vwPwaAdmDisciplinasJecriService;
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<VwPwaAdmDisciplinasJecri1Lista> selectAllVwPwaAdmDisciplinasJecri1Lista() {
        List<VwPwaAdmDisciplinasJecri1Lista> listadoVwPwaAdmDisciplinasJecri1Lista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("select consecutivo, descripcion from ADM_DISCIPLINAS_JECRI where estado = 'AC' order by CONSECUTIVO");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwPwaAdmDisciplinasJecri1Lista vwPwaAdmDisciplinasJecri1Lista = new VwPwaAdmDisciplinasJecri1Lista();
                if (i < lstItems.size()) {
                    vwPwaAdmDisciplinasJecri1Lista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    vwPwaAdmDisciplinasJecri1Lista.setDescripcion(obj[1] == null ? null : obj[1].toString());
                }
                listadoVwPwaAdmDisciplinasJecri1Lista.add(vwPwaAdmDisciplinasJecri1Lista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista: " + ex.getMessage());
        }
        return listadoVwPwaAdmDisciplinasJecri1Lista;
    }
    
    @Override
    @Transactional
    public List<VwPwaAdmDisciplinasJecri2Lista> selectAllVwPwaAdmDisciplinasJecri2Lista(Long consecutivo) {
        List<VwPwaAdmDisciplinasJecri2Lista> listadoVwPwaAdmDisciplinasJecri2Lista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT CONSECUTIVO, DESCRIPCION_DISCIPLINA FROM ADM_DISCIPLINAS_JECRI WHERE CONSECUTIVO = ? AND ESTADO = 'AC'");
            
            q.setParameter(1, consecutivo);

            @SuppressWarnings("unchecked")
            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwPwaAdmDisciplinasJecri2Lista vwPwaAdmDisciplinasJecri2Lista = new VwPwaAdmDisciplinasJecri2Lista();
                if (i < lstItems.size()) {
                    vwPwaAdmDisciplinasJecri2Lista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    vwPwaAdmDisciplinasJecri2Lista.setDescripcionDisciplina(obj[1] == null ? null : obj[1].toString());
                }
                listadoVwPwaAdmDisciplinasJecri2Lista.add(vwPwaAdmDisciplinasJecri2Lista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista: " + ex.getMessage());
        }
        return listadoVwPwaAdmDisciplinasJecri2Lista;
    }
    
    @Override
    @Transactional
    public List<VwPwaProcedimientosJecriLista> selectVwPwaProcedimientosJecri(Long consecutivo) {
        List<VwPwaProcedimientosJecriLista> listadoVwPwaProcedimientosJecriLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT consecutivo, nombre_procedimiento, nombre_archivo, ruta_archivo FROM PWA_PROCEDIMIENTOS_JECRI where id_disciplinas = ? AND estado = 'AC' ORDER BY nombre_procedimiento");
            
            q.setParameter(1, consecutivo);

            @SuppressWarnings("unchecked")
            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwPwaProcedimientosJecriLista vwPwaProcedimientosJecriLista = new VwPwaProcedimientosJecriLista();
                if (i < lstItems.size()) {
                    vwPwaProcedimientosJecriLista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    vwPwaProcedimientosJecriLista.setNombreProcedimiento(obj[1] == null ? null : obj[1].toString());
                    vwPwaProcedimientosJecriLista.setNombreArchivo(obj[2] == null ? null : obj[2].toString());
                    vwPwaProcedimientosJecriLista.setRutaArchivo(obj[3] == null ? null : obj[3].toString());
                }
                listadoVwPwaProcedimientosJecriLista.add(vwPwaProcedimientosJecriLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista: " + ex.getMessage());
        }
        return listadoVwPwaProcedimientosJecriLista;
    }
    
    @Override
    @Transactional
    public List<VwPwaUbicaDiciplixRegion> selectVwPwaUbicaDiciplixRegion(Long idDisciplina) {
        List<VwPwaUbicaDiciplixRegion> listadoVwPwaUbicaDiciplixRegion = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("select * from VW_PWA_UBICA_DICIPLI_X_REGION WHERE ID_DISCIPLINA = ?");
            
            q.setParameter(1, idDisciplina);

            @SuppressWarnings("unchecked")
            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwPwaUbicaDiciplixRegion vwPwaUbicaDiciplixRegion = new VwPwaUbicaDiciplixRegion();
                if (i < lstItems.size()) {
                    vwPwaUbicaDiciplixRegion.setRegional(obj[0] == null ? null : obj[0].toString());
                    vwPwaUbicaDiciplixRegion.setCodigoRegional(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
                    vwPwaUbicaDiciplixRegion.setIdDisciplina(Long.parseLong(obj[2] == null ? null : obj[2].toString()));
                }
                listadoVwPwaUbicaDiciplixRegion.add(vwPwaUbicaDiciplixRegion);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista: " + ex.getMessage());
        }
        return listadoVwPwaUbicaDiciplixRegion;
    }
    
}
