package co.gov.policia.pwa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaFuncionariosCasos;
import co.gov.policia.pwa.service.UserService;
import co.gov.policia.pwa.service.VwPwaFuncionariosCasosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwafuncionarioscasos")
public class VwPwaFuncionariosCasosController {      
    
    @Autowired
    VwPwaFuncionariosCasosService vwPwaFuncionariosCasosService;
    
    @Autowired
	UserService userService;
    
    @PostMapping(value = "/insert", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> insertVwPwaFuncionark(@RequestBody VwPwaFuncionariosCasos vwPwaFuncionariosCasos) {
        
        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

        return vwPwaFuncionariosCasosService.insertVwPwaFuncionar(vwPwaFuncionariosCasos, usuarioConexion);	
    } 
   
    @GetMapping(value = "/validarNoticiaCriminal", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarNoticiaCriminalFinal(@RequestParam String nroUnico, Long consecutivo)  {
        return vwPwaFuncionariosCasosService.buscarNoticiaCriminalFinal(nroUnico, consecutivo);
    }
    
    @GetMapping(value = "/validarExiteNoticiaCriminal", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> validarExiteNoticiaCriminal(@RequestParam String nroUnico)  {
    	
    	String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
    	
    	VwPwaAdminUsuarios porUsuarioPwa = new VwPwaAdminUsuarios();
    	
    	porUsuarioPwa = userService.buscarPwa(usuarioConexion);
    	
    	Long consecutivoUsuarioConexion = porUsuarioPwa.getConsecutivo();    	
    	
        return vwPwaFuncionariosCasosService.validarExiteNoticiaCriminal(nroUnico, consecutivoUsuarioConexion);
    }
    
    @GetMapping(value = "/buscarFuncionarioByIdentificacion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarFuncionarioByIdentificacion(@RequestParam Long identificacion)  {
        return vwPwaFuncionariosCasosService.buscarFuncionarioByIdentificacion(identificacion);
    }

}