package co.gov.policia.pwa.modal.service;

import org.springframework.http.ResponseEntity;

public interface NoticiaCriminalListaService {
	
	public ResponseEntity<?> leyesFuncionarios();
	
	public ResponseEntity<?> lineaNoticiaCriminal();

}
