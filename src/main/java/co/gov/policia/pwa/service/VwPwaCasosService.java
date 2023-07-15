package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaCasos;

public interface VwPwaCasosService extends Serializable {

	public ResponseEntity<?> insertVwPwaCasos(VwPwaCasos vwPwaCasos, String usuarioConexion);

}