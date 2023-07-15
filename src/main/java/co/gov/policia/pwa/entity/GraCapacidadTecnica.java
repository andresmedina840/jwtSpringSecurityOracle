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
@Table(schema = "USR_SIGIC", name = "GRA_CAPACIDAD_TECNICA")
public class GraCapacidadTecnica {	

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "UNDE_CODIGO", nullable = false)
    private Long undeCodigo;
    
    @Column(name = "TOTAL_CLARO", nullable = false)
    private Long totalClaro;
    
    @Column(name = "OCUPADO_CLARO", nullable = false)
    private Long ocupadoClaro;
    
    @Column(name = "TOTAL_MOVISTAR", nullable = false)
    private Long totalMovistar;
    
    @Column(name = "OCUPADO_MOVISTAR", nullable = false)
    private Long ocupadoMovistar;
    
    @Column(name = "TOTAL_TIGO", nullable = false)
    private Long totalTigo;
    
    @Column(name = "OCUPADO_TIGO", nullable = false)
    private Long ocupadoTigo;
    
    @Column(name = "TOTAL_WOM", nullable = false)
    private Long totalWom;
    
    @Column(name = "OCUPADO_WOM", nullable = false)
    private Long ocupadoWom;
    
    @Column(name = "TOTAL_CAPACIDAD", nullable = false)
    private Long totalCapacidad;
    
    @Column(name = "TOTAL_OCUPADO", nullable = false)
    private Long totalOcupado;
    
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

}
