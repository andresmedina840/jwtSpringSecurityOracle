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
@Table(name = "VW_PWA_SEGUIMIENTO_CASOS")
public class VwPwaSeguimientoCasos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "PORCENTAJE_ID", nullable = false, length = 2)
    private String porcentajeId;

    @Column(name = "PORCENTAJE", nullable = true, length = 4000)
    private String porcentaje;

    @Column(name = "AVANCE", nullable = true, length = 4000)
    private String avance;

    @Column(name = "CONS_CASO", nullable = false)
    private Long consCaso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_ASIGNACION", nullable = false)
    private Date fechaAsignacion;

    @Column(name = "ESTADO", nullable = true, length = 2)
    private String estado;

    @Column(name = "D_ESTADO", nullable = true, length = 8)
    private String dEstado;

    @Column(name = "NOTICIA_CRIMINAL", nullable = false, length = 21)
    private String noticiaCriminal;
}
