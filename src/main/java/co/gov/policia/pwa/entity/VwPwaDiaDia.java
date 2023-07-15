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
@Table(name = "VW_PWA_DIA_DIA")
public class VwPwaDiaDia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA", nullable = true)
	private Date fecha;

	@Column(name = "HORA", nullable = true, length = 2)
	private String hora;

	@Column(name = "MINUTOS", nullable = true, length = 2)
	private String minutos;

	@Column(name = "ACTIVIDAD", nullable = true, length = 4000)
	private String actividad;

	@Column(name = "RESULTADO", nullable = true, length = 1000)
	private String resultado;

	@Column(name = "CONS_EMPL", nullable = true)
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

	@Column(name = "AMBITO", nullable = true, length = 2)
	private String ambito;

	@Column(name = "D_AMBITO", nullable = true, length = 27)
	private String dAmbito;

	@Column(name = "RUTA", nullable = true, length = 500)
	private String ruta;

	@Column(name = "CONS_EMP_SIPAC", nullable = true)
	private Long consEmpSipac;

	@Column(name = "TIPO_EVIDENCIA", nullable = true, length = 2)
	private String tipoEvidencia;

	@Column(name = "D_TIPO_EVIDENCIA", nullable = true, length = 40)
	private String dTipoEvidencia;

	@Column(name = "CLASIFICACION_ACTIVIDAD", nullable = true)
	private Long clasificacionActividad;
}
