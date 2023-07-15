package co.gov.policia.pwa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.gov.policia.pwa.entity.Anios;

public interface NoticiaCriminalService {
	
	public ResponseEntity<?> buscarNoticiaCriminalFinal(String nroUnico);
	
	public ResponseEntity<?> listaClasificacion();
	
	public ResponseEntity<?> listaEstadoMored();
	
	public ResponseEntity<?> listaPriorizado();
	
	public ResponseEntity<?> listaBlancoEstrategico();
	
	public ResponseEntity<?> listaEstrategiaMored();
	
	public ResponseEntity<?> listaAvanceMored();
	
	public ResponseEntity<?> listaEstado();
	
	public ResponseEntity<?> listaZonas();
	
	public List<Anios> selectAnios();

}
