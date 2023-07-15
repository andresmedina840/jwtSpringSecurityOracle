package co.gov.policia.pwa.modal.entity;

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
@Table(schema = "USR_SIGIC", name = "DIA_FRANQUICIAS_FUNCIONALIDADES")
public class DiaFranquiciasFuncionalidades {
    
    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "CODIGO_FRANQUICIA", nullable = true, length = 10)
    private String codigoFranquicia;
    
    @Column(name = "DESCRIPCION", nullable = true, length = 300)
    private String descripcion;
    
    @Column(name = "ESTADO", nullable = true, length = 2)
    private String estado;
    
    @Column(name = "TIPO_VARIABLE", nullable = false, length = 20)
    private String tipoVariable;
    
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
