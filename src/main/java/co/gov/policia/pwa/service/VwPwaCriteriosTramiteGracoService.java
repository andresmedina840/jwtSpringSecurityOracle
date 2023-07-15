package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;

public interface VwPwaCriteriosTramiteGracoService {
	
	public ResponseEntity<?> verTabCriterios(Long consecutivo);

}
