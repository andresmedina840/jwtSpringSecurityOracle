package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.modal.entity.AmbitoDiaDiaLista;

public interface AmbitoDiaDiaListaService extends Serializable{  

    public List<AmbitoDiaDiaLista> selectAllAmbitoDiaDiaLista();
    
    public List<AmbitoDiaDiaLista> actividadRealizadaByConsucutivo(String consecutivo);
    
    public ResponseEntity<?> descripcionActividadRealizadaByConsucutivo(String consecutivo);

}
