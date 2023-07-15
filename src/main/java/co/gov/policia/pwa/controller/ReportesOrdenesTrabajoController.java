package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.entity.VwPwaAdminUsuariosNacional;
import co.gov.policia.pwa.service.ReportesOrdenesTrabajoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/repordenestrabajoestado")
public class ReportesOrdenesTrabajoController {
	
	@Autowired
	ReportesOrdenesTrabajoService reportesOrdenesTrabajoService;
	
	@GetMapping(value = "/regionalRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> regionalRepOrdenesTrabajoEstado(@RequestParam(required = true) String regional) {
		
		String usuarioNacional = "";
		
		VwPwaAdminUsuariosNacional vwPwaAdminUsuariosNacional= new VwPwaAdminUsuariosNacional();

		vwPwaAdminUsuariosNacional = reportesOrdenesTrabajoService.buscarUsuarioNacionalByRegional(regional);
		
		if (vwPwaAdminUsuariosNacional == null) {
			usuarioNacional = "NO";
        } else {
        	usuarioNacional = "SI";
        }
		
		return reportesOrdenesTrabajoService.regionalRepOrdenesTrabajoEstado(regional, usuarioNacional);
	}
	
	@GetMapping(value = "/unidadRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> unidadRepOrdenesTrabajoEstado(@RequestParam String regional) {
		return reportesOrdenesTrabajoService.unidadRepOrdenesTrabajoEstado(regional);
	}
	
	@GetMapping(value = "/aniosRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> aniosRepOrdenesTrabajoEstado(@RequestParam String regional, String unidad) {
		return reportesOrdenesTrabajoService.aniosRepOrdenesTrabajoEstado(regional, unidad);
	}
	
	@GetMapping(value = "/mesesRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> mesesRepOrdenesTrabajoEstado(@RequestParam String regional, String unidad, Long anio) {
		return reportesOrdenesTrabajoService.mesesRepOrdenesTrabajoEstado(regional, unidad, anio);
	}
	
	@GetMapping(value = "/filtrosBusquedaRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> filtrosBusquedaRepOrdenesTrabajoEstado(@RequestParam(required = false) String regional, @RequestParam(required = false) String unidad, @RequestParam(required = false) Long anio, Long mes) {
		return reportesOrdenesTrabajoService.filtrosBusquedaRepOrdenesTrabajoEstado(regional, unidad, anio, mes);
	}
	
	@GetMapping(value = "/filtrosBusquedaDosRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> filtrosBusquedaDosRepOrdenesTrabajoEstado(@RequestParam String regional, String unidad, Long anio, Long mes) {
		return reportesOrdenesTrabajoService.filtrosBusquedaDosRepOrdenesTrabajoEstado(regional, unidad, anio, mes);
	}
	
	@GetMapping(value = "/filtrosBusquedaTresRepOrdenesTrabajoEstado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> filtrosBusquedaTresRepOrdenesTrabajoEstado(@RequestParam String regional, String unidad, Long anio, Long mes) {
		return reportesOrdenesTrabajoService.filtrosBusquedaTresRepOrdenesTrabajoEstado(regional, unidad, anio, mes);
	}

}
