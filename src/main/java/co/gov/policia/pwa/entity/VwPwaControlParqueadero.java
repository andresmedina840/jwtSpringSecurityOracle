package co.gov.policia.pwa.entity;

import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(schema = "USR_SIGIC", name = "VW_PWA_CONTROL_PARQUEADERO")
public class VwPwaControlParqueadero {

	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;
	
	@Column(name = "CLASE_AUTOMOTOR", nullable = true, length = 100)
	private String ClaseAutomotor;
	
	@Column(name = "UNDE_CODIGO", nullable = false)
	private Long UndeCodigo;
	
	@Column(name = "UNIDAD_FUNCIONARIO", nullable = true, length = 500)
	private String UnidadFuncionario;
	
	@Column(name = "FUNCIONARIO_RESPONSABLE", nullable = true, length = 500)
	private String FuncionarioResponsable;
	
	@Column(name = "PROPIETARIO", nullable = true, length = 10)
	private String Propietario;
	
	@Column(name = "NUMERO_CELULAR", nullable = true)
	private Long NumeroCelular;
	
	@Column(name = "PLACA_VEHICULO", nullable = false , length = 10)
	private String PlacaVehiculo;
	
	@Column(name = "CILIDRAJE", nullable = true , length = 100)
	private String Cilidraje;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MATRICULA", nullable = false)
	private Date FechaMatricula;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_VEN_SOAT", nullable = false)
	private Date FechaVenSoat;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_VEN_TEC_MEC", nullable = false)
	private Date FechaVenTecMec;
	
	@Column(name = "CUPO_SIGIC", nullable = true)
	private Long CupoSigic;
	
	@Column(name = "ESTADO_PERMISO", nullable = true , length = 100)
	private String EstadoPermiso;
	

}



