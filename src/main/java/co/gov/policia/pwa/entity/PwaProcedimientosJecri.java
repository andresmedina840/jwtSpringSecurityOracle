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
@Table(schema = "USR_SIGIC", name = "PWA_PROCEDIMIENTOS_JECRI")
public class PwaProcedimientosJecri {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "ID_DISCIPLINAS", nullable = false)
    private Long idDisciplinas;

    @Column(name = "ESTADO", nullable = true, length = 2)
    private String estado;
    
    @Column(name = "NOMBRE_PROCEDIMIENTO", nullable = true, length = 4000)
    private String nombreProcedimiento;
    
    @Column(name = "NOMBRE_ARCHIVO", nullable = true, length = 200)
    private String nombreArchivo;
    
    @Column(name = "RUTA_ARCHIVO", nullable = true, length = 200)
    private String rutaArchivo;
    
    @Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
    private String usuarioCreador;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;
    
    @Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
    private String usuarioModificador;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;

}
