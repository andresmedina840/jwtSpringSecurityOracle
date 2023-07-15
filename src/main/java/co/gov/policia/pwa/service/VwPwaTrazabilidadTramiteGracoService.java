package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;

public interface VwPwaTrazabilidadTramiteGracoService {
	
	public ResponseEntity<?> consultaTrazabilidadTramiteGraco(Long consecutivo);

}
