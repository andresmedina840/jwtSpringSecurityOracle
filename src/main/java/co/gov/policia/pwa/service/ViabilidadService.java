package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.GraSolicitudHistoricoEstado;

public interface ViabilidadService {
	
	public ResponseEntity<?> insertAdmMaicModuloMenu(GraSolicitudHistoricoEstado graSolicitudHistoricoEstado, String usuarioConexion);

}
