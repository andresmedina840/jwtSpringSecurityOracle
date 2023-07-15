package co.gov.policia.pwa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(name = "VW_PWA_FRANQUICIA")
public class VwPwaFranquicia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;

	@Column(name = "TIPO_PERMISO", nullable = true, length = 2)
	private String tipoPermiso;

	@Column(name = "D_TIPO_PERMISO", nullable = true, length = 11)
	private String dTipoPermiso;

	@Column(name = "PERMISO", nullable = true)
	private Long permiso;

	@Column(name = "D_PERMISO", nullable = true, length = 37)
	private String dPermiso;

	@Column(name = "TOTAL_DIAS", nullable = true)
	private Long totalDias;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_INICIO", nullable = true)
	private Date fechaInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_FIN", nullable = true)
	private Date fechaFin;

	@Column(name = "CONS_EMPL", nullable = false)
	private Long consEmpl;

	@Column(name = "IDENTIFICACION", nullable = true)
	private Long identificacion;

	@Column(name = "FUNCIONARIO", nullable = true, length = 4000)
	private String funcionario;

	@Column(name = "DEPENDENIA", nullable = true, length = 4000)
	private String dependenia;

	@Column(name = "USUARIO_CREADOR", nullable = true, length = 30)
	private String usuarioCreador;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fechaCreacion;

	@Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
	private String usuarioModificador;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MODIFICACION", nullable = true)
	private Date fechaModificacion;

	@Column(name = "OBSERVACIONES", nullable = true, length = 4000)
	private String observaciones;

	@Column(name = "UNDE_CODIGO", nullable = true)
	private Long undeCodigo;
}
