package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaDiaDia;

public interface VwPwaDiaDiaService extends Serializable {

	public ResponseEntity<?> insertVwPwaDiaDia(VwPwaDiaDia vwPwaDiaDia, String usuarioConexion);

}