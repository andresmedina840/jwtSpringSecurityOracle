package co.gov.policia.pwa.entity;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(schema = "USR_SIGIC", name = "VW_PWA_DIRECC_DICIPLI_X_REGION")
public class VwPwaDireccDiciplixDegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_UNIDAD", nullable = false)
    private Long codigoUnidad;
    
    @Column(name = "UNIDAD", nullable = true, length = 108)
    private String unidad;
    
    @Column(name = "MUNICIPIO", nullable = true, length = 203)
    private String municipio;
    
    @Column(name = "TELEFONO", nullable = true, length = 20)
    private String telefono;
    
    @Column(name = "DIRECCION_LABORATORIO", nullable = true, length = 100)
    private String direccionLaboratorio;

}
