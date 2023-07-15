package co.gov.policia.pwa.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import co.gov.policia.pwa.entity.VwPwaAdminUsuariosNacional;

public interface ReportesOrdenesTrabajoService {
	
	public ResponseEntity<?> regionalRepOrdenesTrabajoEstado(String regional, String usuarioNacional);
	
	public ResponseEntity<?> unidadRepOrdenesTrabajoEstado(@RequestParam String regional);
	
	public ResponseEntity<?> aniosRepOrdenesTrabajoEstado(String regional, String unidad);
	
	public ResponseEntity<?> mesesRepOrdenesTrabajoEstado(String regional, String unidad, Long anio);
	
	public ResponseEntity<?> filtrosBusquedaRepOrdenesTrabajoEstado(String regional, String unidad, Long anio, Long mes);
	
	public ResponseEntity<?> filtrosBusquedaDosRepOrdenesTrabajoEstado(String regional, String unidad, Long anio, Long mes);
	
	public ResponseEntity<?> filtrosBusquedaTresRepOrdenesTrabajoEstado(String regional, String unidad, Long anio, Long mes);

	public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByUsuario(String usuarioEmpresarial);
	
	public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByRegional(String regional);
	
	public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByUndeCodigoSipac(Long undeCodigoSipac);
	
}
