package co.gov.policia.pwa.entity;

import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Cacheable(false)
@Table(schema = "USR_SIGIC", name = "ADM_DISCIPLINAS_JECRI")
public class AdmDisciplinasJecri {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "DESCRIPCION", nullable = true, length = 100)
    private String descripcion;
    
    @Column(name = "ESTADO", nullable = true, length = 2)
    private String estado;
    
    @Column(name = "USUARIO_CREADOR", nullable = true, length = 30)
    private String usuarioCreador;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;
    
    @Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
    private String usuarioModificador;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;
    
    @Column(name = "DESCRIPCION_DISCIPLINA", nullable = true, length = 4000)
    private String descripcionDisciplina;
    
    @Column(name = "NOMBRE_IMAGEN", nullable = true, length = 200)
    private String nombreImagen;
    
    @Column(name = "RUTA_ARCHIVO_IMAGEN", nullable = true, length = 200)
    private String rutaArchivoImagen;
    
    @Column(name = "NOMBRE_ICONO", nullable = true, length = 200)
    private String nombreIcono;
    
    @Column(name = "RUTA_NOMBRE_ICONO", nullable = true, length = 200)
    private String rutaNombreIcono;

}
