package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import co.gov.policia.pwa.entity.VwPwaFuncionariosCasos;

public interface VwPwaFuncionariosCasosService extends Serializable {

    public ResponseEntity<?> insertVwPwaFuncionar(VwPwaFuncionariosCasos vwPwaFuncionariosCasos, String usuarioConexion);
   
    public ResponseEntity<?> buscarByIdentificacionFuncionarios(Long identificacion);
       
    public ResponseEntity<?> buscarNoticiaCriminal(String nroUnico);
    
    public ResponseEntity<?> buscarNoticiaCriminalFinal(String nroUnico, Long consecutivo);
    
    public ResponseEntity<?> validarExiteNoticiaCriminal(String nroUnico, Long consecutivo);
    
    public ResponseEntity<?> buscarFuncionarioByIdentificacion(@RequestParam Long identificacion);
    
}