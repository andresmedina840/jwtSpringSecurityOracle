package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;

public interface GraCapacidadTecnicaService {
	
	public ResponseEntity<?> salasReporteSeguimientoGraco(Long undeCodigoSipac, String usuarioNacional);
	
	public ResponseEntity<?> datosRepSeguimientoGraco(Long undeCodigoSipac);

}
