package co.gov.policia.pwa.entity;

import java.io.Serializable;
import java.sql.Clob;
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
@Table(schema = "USR_SIGIC", name = "VW_PWA_CASOS")
public class VwPwaCasos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;

	@Column(name = "UNDE_CODIGO", nullable = false)
	private Long undeCodigo;

	@Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
	private String usuarioCreador;

	@Column(name = "LUGE_CODIGO_COMI", nullable = false)
	private Long lugeCodigoComi;

	@Column(name = "D_LUGE_CODIGO_COMI", nullable = true, length = 4000)
	private String dLugeCodigoComi;

	@Column(name = "CONS_BARRIO_COMI", nullable = true)
	private Long consBarrioComi;

	@Column(name = "PUCA_CODIGO_COMI", nullable = true)
	private Long pucaCodigoComi;

	@Column(name = "COD_DESPACHO", nullable = true)
	private Long codDespacho;

	@Column(name = "COD_ENTI_REMI", nullable = true)
	private Long codEntiRemi;

	@Column(name = "COD_ENTI_RECEP", nullable = false)
	private Long codEntiRecep;

	@Column(name = "D_COD_ENTI_RECEP", nullable = true, length = 16)
	private String dCodEntiRecep;

	@Column(name = "ANO", nullable = false, length = 4)
	private String ano;

	@Column(name = "NRO_CONSECUTIVO", nullable = true, length = 5)
	private String nroConsecutivo;

	@Column(name = "NRO_UNICO", nullable = false, length = 21)
	private String nroUnico;

	@Column(name = "TIPO_NOTICIA", nullable = true, length = 2)
	private String tipoNoticia;

	@Column(name = "D_TIPO_NOTICIA", nullable = true, length = 4000)
	private String dTipoNoticia;

	@Column(name = "TIPO_DELITO", nullable = true)
	private Long tipoDelito;

	@Column(name = "D_TIPO_DELITO", nullable = true, length = 4000)
	private String dTipoDelito;

	@Column(name = "TIPO_DILIGENCIA", nullable = true, length = 2)
	private String tipoDiligencia;

	@Column(name = "D_TIPO_DILIGENCIA", nullable = true, length = 4000)
	private String dTipoDiligencia;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_RECEP_DEN", nullable = true)
	private Date fechaRecepDen;

	@Column(name = "USUARIO_REMITIDO", nullable = true, length = 2)
	private String usuarioRemitido;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_REMISION", nullable = true)
	private Date fechaRemision;

	@Column(name = "TIPO_DOC_REMITE", nullable = true, length = 2)
	private String tipoDocRemite;

	@Column(name = "NRO_DOC_REMITE", nullable = true, length = 20)
	private String nroDocRemite;

	@Column(name = "NOMBRES_REMITE", nullable = true, length = 30)
	private String nombresRemite;

	@Column(name = "CARGO_REMITE", nullable = true, length = 60)
	private String cargoRemite;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_INI_COMI", nullable = true)
	private Date fechaIniComi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_FINAL_COMI", nullable = true)
	private Date fechaFinalComi;

	@Column(name = "TIPO_INDICIADO", nullable = true, length = 2)
	private String tipoIndiciado;

	@Column(name = "TIPO_CONNOTACION", nullable = true, length = 2)
	private String tipoConnotacion;

	@Column(name = "TIPO_UBICA1_COMI", nullable = true, length = 2)
	private String tipoUbica1Comi;

	@Column(name = "VLR_UBICA1_COMI", nullable = true)
	private Long vlrUbica1Comi;

	@Column(name = "COMP_VLR_UBICA1_COMI", nullable = true, length = 4)
	private String compVlrUbica1Comi;

	@Column(name = "TIPO_UBICA2_COMI", nullable = true, length = 2)
	private String tipoUbica2Comi;

	@Column(name = "VLR_UBICA2_COMI", nullable = true)
	private Long vlrUbica2Comi;

	@Column(name = "COMP_VLR_UBICA2_COMI", nullable = true, length = 4)
	private String compVlrUbica2Comi;

	@Column(name = "NRO_UBICACION_COMI", nullable = true)
	private Long nroUbicacionComi;

	@Column(name = "ZONA", nullable = true, length = 2)
	private String zona;

	@Column(name = "SITIO_ESPECIFICO", nullable = true)
	private Long sitioEspecifico;

	@Column(name = "RELATO_HECHOS", nullable = true)
	private Clob relatoHechos;

	@Column(name = "CONS_EMPLEADO_AURG", nullable = true)
	private Long consEmpleadoAurg;

	@Column(name = "LUGE_CODIGO_NOTICIA", nullable = true)
	private Long lugeCodigoNoticia;

	@Column(name = "DEPARTAMENTO", nullable = true, length = 4000)
	private String departamento;

	@Column(name = "MUNICIPIO", nullable = true, length = 4000)
	private String municipio;

	@Column(name = "UNDE_CODIGO_CONOCE", nullable = true)
	private Long undeCodigoConoce;

	@Column(name = "UNDE_CODIGO_JURIS", nullable = true)
	private Long undeCodigoJuris;

	@Column(name = "TELEFONO_REMITE", nullable = true, length = 20)
	private String telefonoRemite;

	@Column(name = "CORREO_REMITE", nullable = true, length = 60)
	private String correoRemite;

	@Column(name = "HORA_RECEPCION_DEN", nullable = true, length = 2)
	private String horaRecepcionDen;

	@Column(name = "MINUTO_RECEPCION_DEN", nullable = true, length = 2)
	private String minutoRecepcionDen;

	@Column(name = "HORA_INICIO_COMISION", nullable = true, length = 2)
	private String horaInicioComision;

	@Column(name = "MINUTO_INICIO_COMISION", nullable = true, length = 2)
	private String minutoInicioComision;

	@Column(name = "HORA_FIN_COMISION", nullable = true, length = 2)
	private String horaFinComision;

	@Column(name = "MINUTO_FIN_COMISION", nullable = true, length = 2)
	private String minutoFinComision;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fechaCreacion;

	@Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
	private String usuarioModificador;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MODIFICACION", nullable = true)
	private Date fechaModificacion;

	@Column(name = "COD_UNI_RECEP", nullable = true)
	private Long codUniRecep;

	@Column(name = "CONDICION_CLIMATICA", nullable = true, length = 2)
	private String condicionClimatica;

	@Column(name = "LEY", nullable = false, length = 4)
	private String ley;

	@Column(name = "NRO_CASO_ARCHIVO", nullable = true)
	private Long nroCasoArchivo;

	@Column(name = "NOMBRE_CASO", nullable = false, length = 200)
	private String nombreCaso;

	@Column(name = "ESTADO_CASO", nullable = false, length = 1)
	private String estadoCaso;

	@Column(name = "MOTIVO_ESTADO", nullable = true, length = 200)
	private String motivoEstado;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_ESTADO", nullable = true)
	private Date fechaEstado;

	@Column(name = "CONS_CASO_PAPA", nullable = true)
	private Long consCasoPapa;

	@Column(name = "OBS_DIRECCION", nullable = true, length = 80)
	private String obsDireccion;

	@Column(name = "LATITUD", nullable = true)
	private Long latitud;

	@Column(name = "LONGITUD", nullable = true)
	private Long longitud;

	@Column(name = "PRIMER_RESPONDIENTE_ID", nullable = true)
	private Long primerRespondienteId;

	@Column(name = "CAPTURA_FLAGRANCIA_ID", nullable = true)
	private Long capturaFlagranciaId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_PROGRAMA_EST_HUR", nullable = true)
	private Date fechaProgramaEstHur;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_EJECUT_EST_HUR", nullable = true)
	private Date fechaEjecutEstHur;

	@Column(name = "CLASIFICACION", nullable = true, length = 2)
	private String clasificacion;

	@Column(name = "D_CLASIFICACION", nullable = true, length = 21)
	private String dClasificacion;

	@Column(name = "OBSERVACIONES_CLASIFICACION", nullable = true, length = 4000)
	private String observacionesClasificacion;

	@Column(name = "CODIGO_MOIP", nullable = true, length = 30)
	private String codigoMoip;

	@Column(name = "PRIORIZADO", nullable = true)
	private Long priorizado;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_ASIGNACION", nullable = true)
	private Date fechaAsignacion;

	@Column(name = "CODIGO_LINEA", nullable = true)
	private Long codigoLinea;

	@Column(name = "D_CODIGO_LINEA", nullable = true, length = 4000)
	private String dCodigoLinea;

	@Column(name = "DESCRIPCION_INVES", nullable = true, length = 2000)
	private String descripcionInves;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_PROYECTADO", nullable = true)
	private Date fechaProyectado;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_EJECUTADO", nullable = true)
	private Date fechaEjecutado;

	@Column(name = "OBS_LINEAS", nullable = true, length = 4000)
	private String obsLineas;

	@Column(name = "BLANCO_ESTRATEGICO", nullable = true)
	private Long blancoEstrategico;

	@Column(name = "ESTADO_MORED", nullable = true, length = 2)
	private String estadoMored;

	@Column(name = "RESPONSABLE_MORED", nullable = true, length = 20)
	private String responsableMored;

	@Column(name = "ESTRATEGIA_MORED", nullable = true, length = 2)
	private String estrategiaMored;

	@Column(name = "AVANCE_MORED", nullable = true, length = 3)
	private String avanceMored;

	@Column(name = "CONS_INCIDENTE", nullable = true)
	private Long consIncidente;
}
