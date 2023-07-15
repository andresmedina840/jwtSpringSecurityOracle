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
@Table(name = "VW_PWA_REU_FUENTES_HUMANAS")
public class VwPwaReuFuentesHumanas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "FUENTE_ID", nullable = false)
    private Long fuenteId;

    @Column(name = "NOMBRE_FUENTE", nullable = true, length = 4000)
    private String nombreFuente;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_REUNION", nullable = false)
    private Date fechaReunion;

    @Column(name = "HORA_REUNION", nullable = true, length = 10)
    private String horaReunion;

    @Column(name = "CONS_EMP", nullable = true)
    private Long consEmp;

    @Column(name = "INVESTIGADOR_UNO", nullable = true, length = 4000)
    private String investigadorUno;

    @Column(name = "PAIS_ID", nullable = true)
    private Long paisId;

    @Column(name = "PAIS", nullable = true, length = 4000)
    private String pais;

    @Column(name = "DEPARTAMENTO_ID", nullable = true)
    private Long departamentoId;

    @Column(name = "DEPARTAMENTO", nullable = true, length = 4000)
    private String departamento;

    @Column(name = "MUNICIPIO_ID", nullable = true)
    private Long municipioId;

    @Column(name = "CIUDAD", nullable = true, length = 4000)
    private String ciudad;

    @Column(name = "LOCALIDAD", nullable = true, length = 100)
    private String localidad;

    @Column(name = "BARRIO", nullable = true, length = 100)
    private String barrio;

    @Column(name = "DIRECCION", nullable = true, length = 100)
    private String direccion;

    @Column(name = "CORREGIMIENTO", nullable = true, length = 100)
    private String corregimiento;

    @Column(name = "VEREDA", nullable = true, length = 100)
    private String vereda;

    @Column(name = "ZONA", nullable = true, length = 2)
    private String zona;

    @Column(name = "TIPO_ZONA", nullable = true, length = 6)
    private String tipoZona;

    @Column(name = "DESCRIPCION", nullable = true, length = 4000)
    private String descripcion;

    @Column(name = "SINTESIS", nullable = true, length = 4000)
    private String sintesis;

    @Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
    private String usuarioCreador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 100)
    private String usuarioModificador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "UNDE_CODIGO", nullable = true)
    private Long undeCodigo;

    @Column(name = "CONS_EMP_APOYO", nullable = true)
    private Long consEmpApoyo;

    @Column(name = "INVESTIGADOR_DOS", nullable = true, length = 4000)
    private String investigadorDos;

    @Column(name = "CONS_CASO", nullable = true)
    private Long consCaso;

    @Column(name = "PROCESO", nullable = true, length = 4000)
    private String proceso;

    @Column(name = "ORDEN_TRABAJO_ID", nullable = true)
    private Long ordenTrabajoId;
    
    @Column(name = "IDENTIFICACION_UNO", nullable = false)
    private Long identificacionUno;
    
    @Column(name = "IDENTIFICACION_DOS", nullable = false)
    private Long identificacionDos;
}
