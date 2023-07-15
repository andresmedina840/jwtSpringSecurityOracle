package co.gov.policia.pwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.gov.policia.pwa.entity.Anios;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.service.NoticiaCriminalService;
import co.gov.policia.pwa.service.UserService;
import co.gov.policia.pwa.service.VwPwaFuncionariosCasosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/noticiacriminal")
public class NoticiaCriminalController {
	
	@Autowired
	NoticiaCriminalService noticiaCriminalService;
	
	@Autowired
	UserService userService;
	
	@Autowired
    VwPwaFuncionariosCasosService vwPwaFuncionariosCasosService;
	
    @GetMapping(value = "/buscarNoticiaCriminal", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarNoticiaCriminalFinal(@RequestParam String nroUnico)  {
    	
    	String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
    	
    	VwPwaAdminUsuarios porUsuarioPwa = new VwPwaAdminUsuarios();
    	
    	porUsuarioPwa = userService.buscarPwa(usuarioConexion);
    	
    	Long consecutivoUsuarioConexion = porUsuarioPwa.getConsecutivo();  	
    	
        return vwPwaFuncionariosCasosService.validarExiteNoticiaCriminal(nroUnico, consecutivoUsuarioConexion);
    }
    
    @GetMapping(value = "/listaClasificacion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaClasificacion()  {
        return noticiaCriminalService.listaClasificacion();
    }
    
    @GetMapping(value = "/listaEstadoMored", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaEstadoMored()  {
        return noticiaCriminalService.listaEstadoMored();
    }
    
    @GetMapping(value = "/listaPriorizado", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaPriorizado()  {
        return noticiaCriminalService.listaPriorizado();
    }
    
    @GetMapping(value = "/listaBlancoEstrategico", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaBlancoEstrategico()  {
        return noticiaCriminalService.listaBlancoEstrategico();
    }
    
    @GetMapping(value = "/listaEstrategiaMored", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaEstrategiaMored()  {
        return noticiaCriminalService.listaEstrategiaMored();
    }
    
    @GetMapping(value = "/listaAvanceMored", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaAvanceMored()  {
        return noticiaCriminalService.listaAvanceMored();
    }
    
    @GetMapping(value = "/listaEstado", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaEstado()  {
        return noticiaCriminalService.listaEstado();
    }
    
    @GetMapping(value = "/listaZonas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> listaZonas()  {
        return noticiaCriminalService.listaZonas();
    }
    
    @GetMapping(value = "/anios", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Anios> selectAnios() {
		return noticiaCriminalService.selectAnios();
	}

}
