package co.gov.policia.pwa.entity;

import java.io.Serializable;
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
@Table(schema = "USR_SIGIC", name = "EMPLEADOS_SIPAC")
public class EmpleadosSipac implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;

	@Column(name = "UNDE_CODIGO", nullable = false)
	private Long undeCodigo;

	@Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
	private String usuarioCreador;

	@Column(name = "UNDE_CODIGO_SIPAC", nullable = false)
	private Long undeCodigoSipac;

	@Column(name = "IDENTIFICACION", nullable = false)
	private Long identificacion;

	@Column(name = "ACTIVO", nullable = true, length = 2)
	private String activo;

	@Column(name = "CONS_EMP", nullable = false)
	private Long consEmp;

	@Column(name = "UNDE_FUERZA_EMP", nullable = false)
	private Long undeFuerzaEmp;

	@Column(name = "UNDE_CONS_EMP", nullable = false)
	private Long undeConsEmp;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fechaCreacion;

	@Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
	private String usuarioModificador;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MODIFICACION", nullable = true)
	private Date fechaModificacion;

	@Column(name = "NOMBRES", nullable = true, length = 120)
	private String nombres;

	@Column(name = "GRAD_ALFABETICO", nullable = true)
	private Long gradAlfabetico;

	@Column(name = "COD_CARGO", nullable = true)
	private Long codCargo;

	@Column(name = "DIRECCION", nullable = true, length = 90)
	private String direccion;

	@Column(name = "CORREO_ELECTRONICO", nullable = true, length = 50)
	private String correoElectronico;

	@Column(name = "TELEFONO", nullable = true, length = 30)
	private String telefono;

	@Column(name = "USUARIO_SIPAC", nullable = true, length = 30)
	private String usuarioSipac;

	@Column(name = "TIPO_NOVEDAD", nullable = true, length = 2)
	private String tipoNovedad;

	@Column(name = "SIGLA_JEFAT_SIJIN", nullable = true, length = 5)
	private String siglaJefatSijin;

	@Column(name = "JEFE_SIJIN", nullable = true, length = 2)
	private String jefeSijin;

	@Column(name = "ADM_GRUPO_SALA_PUMA_ID", nullable = true)
	private Long admGrupoSalaPumaId;

	@Column(name = "NIVEL_ORDEN_JEFAT", nullable = true)
	private Long nivelOrdenJefat;

	@Column(name = "ADM_CARGOS_EMPL", nullable = true)
	private Long admCargosEmpl;

	@Column(name = "UNIDAD_REPORTES", nullable = true, length = 30)
	private String unidadReportes;

	@Column(name = "OBSERVACIONES", nullable = true, length = 4000)
	private String observaciones;

	@Column(name = "UNIDAD_SIATH", nullable = true)
	private Long unidadSiath;

	@Column(name = "LINEA_INVESTIGATIVA", nullable = true)
	private Long lineaInvestigativa;

	@Column(name = "CASO_SIGMA", nullable = true, length = 30)
	private String casoSigma;

}
