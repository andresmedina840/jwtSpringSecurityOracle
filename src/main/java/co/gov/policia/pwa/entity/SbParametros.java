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
@Table(name = "SB_PARAMETROS")
public class SbParametros {
    
    @Id
    @Column(name = "PARAMETRO_ID", nullable = false)
    private Long parametroId;

    @Column(name = "APLICACION", nullable = false, length = 10)
    private String aplicacion;

    @Column(name = "PARAMETRO", nullable = false, length = 30)
    private String parametro;
    
    @Column(name = "VALOR_PARAMETRO", nullable = false, length = 4000)
    private String valorParametro;
    
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
