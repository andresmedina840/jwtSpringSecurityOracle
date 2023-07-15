package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import co.gov.policia.pwa.modal.entity.ClasificacionLista;
import co.gov.policia.pwa.modal.entity.TipoDiligenciaLista;

public interface TipoDiligenciaListaService extends Serializable{  

    public List<TipoDiligenciaLista> selectAllTipoDiligenciaLista();
    
    public Map<String, String> selectAllTipoDiligenciaLista1();
    
    public List<ClasificacionLista> selectAllTipoDiligenciaLista2();

}
