package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.ClasificacionLista;
import co.gov.policia.pwa.modal.entity.TipoDiligenciaLista;
import co.gov.policia.pwa.modal.service.TipoDiligenciaListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class TipoDiligenciaListaImpl extends AbstractService implements TipoDiligenciaListaService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    TipoDiligenciaListaService tipoDiligenciaListaService;

    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<TipoDiligenciaLista> selectAllTipoDiligenciaLista() {
        List<TipoDiligenciaLista> listadoTipoDiligenciaLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery(
                    "SELECT rv_low_value,rv_meaning from usr_sigic.cg_ref_codes where rv_domain = 'TIPO DILIGENCIA' ORDER BY rv_meaning");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                TipoDiligenciaLista tipoDiligenciaLista = new TipoDiligenciaLista();
                if (i < lstItems.size()) {
                    tipoDiligenciaLista.setRvLowValue(obj[0] == null ? null : obj[0].toString());
                    tipoDiligenciaLista.setRvMeaning(obj[1] == null ? null : obj[1].toString());
                }
                listadoTipoDiligenciaLista.add(tipoDiligenciaLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Tipos de Diligencia. " + ex.getMessage());
        }
        return listadoTipoDiligenciaLista;
    }

    @Override
    @Transactional
    public Map<String, String> selectAllTipoDiligenciaLista1() {
        Map<String, String> listadoTipoDiligenciaLista = new HashMap<>();

        listadoTipoDiligenciaLista.put("MO", "MORED");
        listadoTipoDiligenciaLista.put("PR", "PRIORIZADO");
        listadoTipoDiligenciaLista.put("DE", "DESCONGESTION");
        listadoTipoDiligenciaLista.put("AC", "ACTOS URGENTES");
        listadoTipoDiligenciaLista.put("PI", "PROCESO INVESTIGATIVO");
        listadoTipoDiligenciaLista.put("BO", "BLANCO DE OPORTUNIDAD");

        Object[] objectArray = listadoTipoDiligenciaLista.entrySet().toArray();
        System.out.println("Verificar: " + Arrays.toString(objectArray));

        return listadoTipoDiligenciaLista;
    }

    @Override
    @Transactional
    public List<ClasificacionLista> selectAllTipoDiligenciaLista2() {
        List<ClasificacionLista> listadoTipoDiligenciaLista = new ArrayList<>();

        try {
            Map<String, String> listadoTipoDiligenciaLista2 = new HashMap<>();

            listadoTipoDiligenciaLista2.put("MO", "MORED");
            listadoTipoDiligenciaLista2.put("PR", "PRIORIZADO");
            listadoTipoDiligenciaLista2.put("DE", "DESCONGESTION");
            listadoTipoDiligenciaLista2.put("AC", "ACTOS URGENTES");
            listadoTipoDiligenciaLista2.put("PI", "PROCESO INVESTIGATIVO");
            listadoTipoDiligenciaLista2.put("BO", "BLANCO DE OPORTUNIDAD");

            int i = 0;
            for (Map.Entry<String, String> mapa : listadoTipoDiligenciaLista2.entrySet()) {
                ClasificacionLista clasificacionLista = new ClasificacionLista();
                if (i < listadoTipoDiligenciaLista2.size()) {
                    clasificacionLista.setId(mapa.getKey().toString());
                    clasificacionLista.setNombre(mapa.getValue().toString());
                }
                listadoTipoDiligenciaLista.add(clasificacionLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Clasificacion. " + ex.getMessage());
        }
        return listadoTipoDiligenciaLista;
    }

}
