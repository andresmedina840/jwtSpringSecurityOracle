package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;

public interface VwPwaSolicitudesTramiteGracoService {
	
	public ResponseEntity<?> countVwPwaSolicitudesTramiteGraco(Long salaCodigo, Long consEmpSala);
	
	public ResponseEntity<?> datosTablaSolicitudesTramiteGraco(Long salaCodigo, Long consEmpSala);
	
	public ResponseEntity<?> verDatosTablaSolicitudesTramiteGraco(Long consecutivo);

}
