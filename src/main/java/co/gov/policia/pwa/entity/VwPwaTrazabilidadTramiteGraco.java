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
@Table(schema = "USR_SIGIC",name = "VW_PWA_TRAZABILIDAD_TRAMITE_GRACO")
public class VwPwaTrazabilidadTramiteGraco {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
	
	@Column(name = "ID_SOLICITUD", nullable = false)
    private Long idSolicitud;
	
	@Column(name = "ID_TRAMITE", nullable = true)
    private Long idTramite;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_SOLICITUD", nullable = true)
    private Date fechaSolicitud;
    
    @Column(name = "NRO_UNICO", nullable = false, length = 21)
    private String NroUnico;
    
    @Column(name = "TIPO_USUARIO", nullable = true, length = 27)
    private String tipoUsuario;
    
    @Column(name = "TRAMITE_ESTADO_DES", nullable = true, length = 23)
    private String tramiteEstadoMes;
    
    @Column(name = "TRAMITE_ESTADO", nullable = true, length = 2)
    private String tramiteEstado;
    
    @Column(name = "DESCRIPCION_ESTADO", nullable = true, length = 4000)
    private String descripcionEstado;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_ESTADO", nullable = false)
    private Date fechaEstado;
    
    @Column(name = "RESPONSABLE", nullable = true, length = 128)
    private String resposable;

}
