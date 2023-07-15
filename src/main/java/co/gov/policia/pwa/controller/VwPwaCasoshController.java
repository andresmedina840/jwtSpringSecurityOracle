package co.gov.policia.pwa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import co.gov.policia.pwa.entity.VwPwaCasos;
import co.gov.policia.pwa.service.VwPwaCasosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwacasos")
public class VwPwaCasoshController {

	@Autowired
	VwPwaCasosService vwPwaCasosService;

	@PostMapping(value = "/insertNoticiaCriminal", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> insertVwPwaCasosh(@RequestBody VwPwaCasos vwPwaCasos) {

		String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("usuarioConexion: " + usuarioConexion);

		return vwPwaCasosService.insertVwPwaCasos(vwPwaCasos, usuarioConexion);
	}

}