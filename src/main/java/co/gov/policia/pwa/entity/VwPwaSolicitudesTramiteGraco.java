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
@Table(schema = "USR_SIGIC",name = "VW_PWA_SOLICITUDES_TRAMITE_GRACO")
public class VwPwaSolicitudesTramiteGraco {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "PRIORIDAD", nullable = true, length = 12)
    private String prioridad;
    
    @Column(name = "ID_TRAMITE", nullable = true)
    private Long idTramite;

    @Column(name = "TIPO_LEY", nullable = true, length = 4)
    private String tipoLey;
    
    @Column(name = "NRO_UNICO", nullable = false, length = 21)
    private String nroUnico;
    
    @Column(name = "DELITO_PRINCIPAL", nullable = true, length = 240)
    private String delitoPrincipal;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_ORDEN", nullable = true)
    private Date fechaOrden;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_FORMATO", nullable = true)
    private Date fechaFormato;
    
    @Column(name = "ASUNTO", nullable = true, length = 240)
    private String asunto;
    
    @Column(name = "MUNICIPIO", nullable = true, length = 100)
    private String municipio;
    
    @Column(name = "DEPARTAMENTO", nullable = true, length = 100)
    private String departamento;
    
    @Column(name = "ESTADO_SOLICITUD", nullable = true, length = 9)
    private String estadoSolicitud;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_SOLICITUD", nullable = true)
    private Date fechaSolicitud;
    
    @Column(name = "INVESTIGADOR", nullable = true, length = 4000)
    private String investigador;
    
    @Column(name = "CONS_EMP", nullable = false)
    private Long consEmp;
    
    @Column(name = "JEFE_INMEDIATO", nullable = true, length = 4000)
    private String jefeInmediato;
    
    @Column(name = "CONS_EMP_JEFE", nullable = false)
    private Long consEmpJefe;

    @Column(name = "UNIDAD_JEFE", nullable = true, length = 100)
    private String unidadJefe;

    @Column(name = "CARGO_JEFE", nullable = true, length = 80)
    private String cargoJefe;
    
    @Column(name = "JEFE_SALA", nullable = true, length = 4000)
    private String jefeSala;
    
    @Column(name = "CONS_EMP_SALA", nullable = true)
    private Long consEmpSala;
    
    @Column(name = "SALA_CODIGO", nullable = false)
    private Long salaCodigo;
    
    @Column(name = "SALA_DESC", nullable = true, length = 108)
    private String salaDesc;
    
    @Column(name = "USUARIO_SIPAC", nullable = true, length = 30)
    private String usuarioSipac;

}
