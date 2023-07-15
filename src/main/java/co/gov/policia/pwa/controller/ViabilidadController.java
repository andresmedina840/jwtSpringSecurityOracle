package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.entity.GraSolicitudHistoricoEstado;
import co.gov.policia.pwa.service.ViabilidadService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/viabilidad")
public class ViabilidadController {
	
	@Lazy
	@Autowired
	ViabilidadService viabilidadService;
	
	@PostMapping(value = "/insertViabildiad", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> insertAdmMaicModuloMenu(@RequestBody GraSolicitudHistoricoEstado graSolicitudHistoricoEstado) {

		String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

		return viabilidadService.insertAdmMaicModuloMenu(graSolicitudHistoricoEstado, usuarioConexion);
	}

}
