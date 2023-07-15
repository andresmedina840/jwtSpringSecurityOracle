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
@Table(name = "VW_PWA_BITACORA_CASOS")
public class VwPwaBitacoraCasos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "UNDE_CODIGO", nullable = true)
    private Long undeCodigo;

    @Column(name = "ACTIVIDAD", nullable = true, length = 4000)
    private String actividad;

    @Column(name = "CONS_CASO", nullable = false)
    private Long consCaso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "USUARIO_CREADOR", nullable = true, length = 30)
    private String usuarioCreador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
    private String usuarioModificador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;
}
