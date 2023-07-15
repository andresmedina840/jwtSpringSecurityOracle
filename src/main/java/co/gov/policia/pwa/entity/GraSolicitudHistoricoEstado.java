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
@Table(schema = "USR_SIGIC", name = "GRA_SOLICITUD_HISTORICO_ESTADO")
public class GraSolicitudHistoricoEstado {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "ID_SOLICITUD", nullable = false)
    private Long idSolicitud;
    
    @Column(name = "TIPO_USUARIO", nullable = true, length = 2)
    private String tipoUsuario;
    
    @Column(name = "DESCRIPCION_ESTADO", nullable = true, length = 4000)
    private String descripcionEstado;
    
    @Column(name = "TRAMITE_ESTADO", nullable = true, length = 2)
    private String tramiteEstado;
    
    @Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
    private String usuarioCreador;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;
    
    @Column(name = "USUARIO_MODIFICACION", nullable = true, length = 30)
    private String usuarioModificacion;
    
    @Column(name = "CONS_EMP", nullable = true)
    private Long consEmp;

}
