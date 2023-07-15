package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import co.gov.policia.pwa.modal.entity.AdmSeguimientoCasosLista;

public interface AdmSeguimientoCasosListaService extends Serializable{  

    public List<AdmSeguimientoCasosLista> selectAllAdmSeguimientoCasosLista();
    
    public ResponseEntity<?> selectAllAdmSeguimientoCasosListaByConsCaso(Long consCaso);

}
