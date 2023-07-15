package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.gov.policia.pwa.entity.VwPwaAdminUsuariosNacional;
import co.gov.policia.pwa.service.GraCapacidadTecnicaService;
import co.gov.policia.pwa.service.ReportesOrdenesTrabajoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/reportesseguimientograco")
public class ReporteSeguimientoGracoController {

	@Autowired
	GraCapacidadTecnicaService graCapacidadTecnicaService;
	
	@Autowired
	ReportesOrdenesTrabajoService reportesOrdenesTrabajoService;
	
	@GetMapping(value = "/salasReporteSeguimientoGraco", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> salasReporteSeguimientoGraco(@RequestParam(required = true) Long undeCodigoSipac) {
		
		String usuarioNacional = "";
		
		VwPwaAdminUsuariosNacional vwPwaAdminUsuariosNacional= new VwPwaAdminUsuariosNacional();

		vwPwaAdminUsuariosNacional = reportesOrdenesTrabajoService.buscarUsuarioNacionalByUndeCodigoSipac(undeCodigoSipac);
		
		if (vwPwaAdminUsuariosNacional == null) {
			usuarioNacional = "NO";
        } else {
        	usuarioNacional = "SI";
        }
		
		return graCapacidadTecnicaService.salasReporteSeguimientoGraco(undeCodigoSipac, usuarioNacional);
	}

	@GetMapping(value = "/datosRepSeguimientoGraco", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> datosRepSeguimientoGraco(@RequestParam Long undeCodigoSipac) {
		return graCapacidadTecnicaService.datosRepSeguimientoGraco(undeCodigoSipac);
	}

}
