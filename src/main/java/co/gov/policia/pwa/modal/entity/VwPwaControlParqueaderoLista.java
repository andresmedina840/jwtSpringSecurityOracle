package co.gov.policia.pwa.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwPwaControlParqueaderoLista {
	
	private Long consecutivo;
	
	private String claseAutomotor;
	
	private Long undeCodigo;
	
	private String unidadFuncionario;
	
	private String funcionarioResponsable;
	
	private String propietario;
	
	private Long numeroCelular;
	
	private String placaVehiculo;
	
	private String cilidraje;

	private String fechaMatricula;
	
	private String fechaVenSoat;
	
	private String fechaVenTecMec;
	
	private Long cupoSigic;
	
	private String estadoPermiso;
	
	private Long diasVencimientoSoat;
	
	private String estadoSoat;
	
	private Long diasVencimientoTecnoMecanica;
	
	private String estadoTecnomecanica;

}
