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
@Table(schema = "USR_SIGIC", name = "VW_PWA_FUNCIONARIO_CASOS")
public class VwPwaFuncionariosCasos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "UNDE_CODIGO", nullable = false)
    private Long undeCodigo;

    @Column(name = "UNIDADA_LABORA", nullable = true, length = 4000)
    private String unidadaLabora;

    @Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
    private String usuarioCreador;

    @Column(name = "CONS_CASO", nullable = false)
    private Long consCaso;

    @Column(name = "CONS_EMP_SIPAC", nullable = false)
    private Long consEmpSipac;

    @Column(name = "CEDULA", nullable = true)
    private Long cedula;

    @Column(name = "NOMBRES", nullable = true, length = 4000)
    private String nombres;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
    private String usuarioModificador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @Column(name = "D_ESTADO", nullable = true, length = 8)
    private String dEstado;

    @Column(name = "MOTIVO_ESTADO", nullable = true, length = 1000)
    private String motivoEstado;

    @Column(name = "ROL", nullable = true, length = 2)
    private String rol;

    @Column(name = "ROL_INVESTIGADOR", nullable = true, length = 4000)
    private String rolInvestigador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_FIN", nullable = true)
    private Date fechaFin;

    @Column(name = "TIPO_NOVEDAD", nullable = true, length = 2)
    private String tipoNovedad;

    @Column(name = "D_TIPO_NOVEDAD", nullable = true, length = 4000)
    private String dTipoNovedad;

    @Column(name = "CONS_EMP_ASIGNADO_A", nullable = true)
    private Long consEmpAsignadoA;

    @Column(name = "NOTIFICACION", nullable = true, length = 2)
    private String notificacion;
}
