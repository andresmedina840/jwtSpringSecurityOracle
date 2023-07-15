package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaBitacoraCasos;

public interface VwPwaBitacoraCasosService extends Serializable {

    public ResponseEntity<?> insertVwPwaBitacoraCasos(VwPwaBitacoraCasos vwPwaBitacoraCasos, String usuarioConexion);
    
}