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
@Table(schema = "USR_SIGIC", name = "ADM_SIG_PERFIL")
public class AdmPwaPerfil {

	@Id
	@Column(name = "IND_PERFIL", nullable = false)
	private Long indPerfil;
	
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "DESCRIPCION", nullable = true, length = 200)
	private String descripcion;
	
	@Column(name = "ESTADO", nullable = true, length = 1)
	private String estado;
	
	@Column(name = "USUARIO_GRABACION", nullable = true, length = 1)
	private String usuarioGrabacion;
	
	@Column(name = "UNIDAD_GRABACION", nullable = true)
	private Integer unidadGrabacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_GRABACION", nullable = true)
	private Date fechaGrabacion;
	
	@Column(name = "USUARIO_MODIFICACION", nullable = true, length = 50)
	private String usuarioModificacion;
	
	@Column(name = "UNIDAD_MODIFICACION", nullable = true)
	private Integer unidadModificacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MODIFICACION", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "BRICK", nullable = true, length = 128)
	private String brick;

}
