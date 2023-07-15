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
import co.gov.policia.pwa.entity.VwPwaDiaDia;
import co.gov.policia.pwa.service.VwPwaDiaDiaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwadiadia")
public class VwPwaDiaDiaController {

	@Autowired
	VwPwaDiaDiaService vwPwaDiaDiaService;

	@PostMapping(value = "/insertDiaDia", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> insertVwPwaDiaDial(@RequestBody VwPwaDiaDia vwPwaDiaDia) {

		String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

		return vwPwaDiaDiaService.insertVwPwaDiaDia(vwPwaDiaDia, usuarioConexion);
	}

}