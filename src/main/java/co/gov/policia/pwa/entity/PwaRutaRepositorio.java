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
@Table(name = "PWA_RUTA_REPOSITORIO")
public class PwaRutaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CODIGO", nullable = false)
    private Long CODIGO;
    
    @Column(name = "NOMBRE_RUTA", nullable = false, length = 100)
    private String nombreRuta;
    
    @Column(name = "RUTA", nullable = false, length = 300)
    private String ruta;
    
    @Column(name = "ACTIVO", nullable = false, length = 2)
    private String activo;
    
    @Column(name = "YEAR_CREACION", nullable = true, length = 2)
    private String yearCreacion;
    
    @Column(name = "USUARIO_CREACION", nullable = true, length = 50)
    private String usuarioCreacion;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "USUARIO_MODIFICACION", nullable = true, length = 50)
    private String usuarioModificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;

}
