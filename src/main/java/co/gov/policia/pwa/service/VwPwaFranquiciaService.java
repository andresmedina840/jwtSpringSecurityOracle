package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaFranquicia;

public interface VwPwaFranquiciaService extends Serializable {

	public ResponseEntity<?> insertVwPwaFranquicia(VwPwaFranquicia vwPwaFranquicia, String usuarioConexion, Long undeCodigoSipac);
	
	public ResponseEntity<?> tipoPermisoFranquiciaOtorgada();
	
	public ResponseEntity<?> tipoPermisoOFranquicia(String codigoFranquicia);
	
	public ResponseEntity<?> totalDiasPermisosFranquicias();

}