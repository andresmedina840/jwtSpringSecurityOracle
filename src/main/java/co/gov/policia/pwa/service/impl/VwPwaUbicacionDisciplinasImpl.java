package co.gov.policia.pwa.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaUbicacionDisciplinas;
import co.gov.policia.pwa.modal.entity.UbicacionJecriLista;
import co.gov.policia.pwa.service.VwPwaUbicacionDisciplinasService;

@Service
public class VwPwaUbicacionDisciplinasImpl extends AbstractService implements VwPwaUbicacionDisciplinasService{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unused", "unchecked" })
    @Override
    @Transactional
    public List<UbicacionJecriLista> selectUbicacionJecriLista(Long idDisciplina) {
        List<UbicacionJecriLista> listadoUbicacionJecriLista = new ArrayList<>();
                      
        try {
            
            Long code = null;
            String mensaje = "";
            
            String consultaSql = "SELECT DISTINCT D.CODIGO_REGIONAL, D.REGIONAL FROM VW_PWA_UBICACION_DISCIPLINAS D WHERE ID_DISCIPLINA = " + idDisciplina + " ORDER BY D.REGIONAL";
            
            Query q = em.createNativeQuery(consultaSql);
            
            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                UbicacionJecriLista ubicacionJecriLista = new UbicacionJecriLista();
                if (i < lstItems.size()) {
                    ubicacionJecriLista.setCodigoRegional(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    ubicacionJecriLista.setRegional(obj[1] == null ? null : obj[1].toString());
                }
                listadoUbicacionJecriLista.add(ubicacionJecriLista);
                i = i + 1;
            }
        } catch (Exception ex) {

        }
        return listadoUbicacionJecriLista;
    }
    
    @SuppressWarnings({ "unused", "unchecked" })
    @Override
    @Transactional
    public List<VwPwaUbicacionDisciplinas> selectVwPwaUbicacionDisciplinasByCodigoRegional(Long idDisciplina, Long codigoRegional) {
        List<VwPwaUbicacionDisciplinas> listadoVwPwaUbicacionDisciplinas = new ArrayList<>();
                      
        try {
            
            Long code = null;
            String mensaje = "";
            
            String consultaSql = "select * from VW_PWA_UBICACION_DISCIPLINAS WHERE id_disciplina = " + idDisciplina + " AND codigo_regional = " + codigoRegional + " order by municipio";
            
            Query q = em.createNativeQuery(consultaSql);
            
            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwPwaUbicacionDisciplinas vwPwaUbicacionDisciplinas = new VwPwaUbicacionDisciplinas();
                if (i < lstItems.size()) {
                    vwPwaUbicacionDisciplinas.setUnidad(obj[0] == null ? null : obj[0].toString());
                    vwPwaUbicacionDisciplinas.setCodigoUnidad(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
                    vwPwaUbicacionDisciplinas.setRegional(obj[2] == null ? null : obj[2].toString());
                    vwPwaUbicacionDisciplinas.setCodigoRegional(Long.parseLong(obj[3] == null ? null : obj[3].toString()));                
                    vwPwaUbicacionDisciplinas.setMunicipio(obj[4] == null ? null : obj[4].toString());
                    vwPwaUbicacionDisciplinas.setCodigoMunicipio(Long.parseLong(obj[5] == null ? null : obj[5].toString()));                 
                    vwPwaUbicacionDisciplinas.setDireccionLaboratorio(obj[6] == null ? null : obj[6].toString());
                    vwPwaUbicacionDisciplinas.setTelefono(obj[7] == null ? null : obj[7].toString());         
                    vwPwaUbicacionDisciplinas.setIdDisciplina(Long.parseLong(obj[8] == null ? null : obj[8].toString()));
                }
                listadoVwPwaUbicacionDisciplinas.add(vwPwaUbicacionDisciplinas);
                i = i + 1;
            }
        } catch (Exception ex) {

        }
        return listadoVwPwaUbicacionDisciplinas;
    }

}
