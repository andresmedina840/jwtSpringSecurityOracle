package co.gov.policia.pwa.entity;

import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Cacheable(false)
@Table(schema = "USR_SIGIC",name = "PWA_SESIONES_ACTIVAS")
public class PwaSesionesActivas {
	
	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;
	
	@Column(name = "SESION_ACTIVA", nullable = true, length = 2)
	private String sesionActiva;
	
	@Column(name = "NAVEGADOR", nullable = true, length = 20)
	private String navegador;
	
	@Column(name = "USUARIO_SIPAC", nullable = true, length = 30)
	private String usuarioSipac;
	
	@Column(name = "APLICACION", nullable = true, length = 40)
	private String aplicacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_CONEXION", nullable = true)
	private Date fechaConexion;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_DESCONEXION", nullable = true)
	private Date fechaDesconexion;
	
	@Column(name = "IP_CONEXION", nullable = true, length = 50)
	private String ipConexion;

}
