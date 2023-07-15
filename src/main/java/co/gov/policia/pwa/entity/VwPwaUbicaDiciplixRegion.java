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
@Table(schema = "USR_SIGIC", name = "VW_PWA_UBICA_DICIPLI_X_REGION")
public class VwPwaUbicaDiciplixRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_REGIONAL", nullable = true)
    private Long codigoRegional;
    
    @Column(name = "REGIONAL", nullable = false, length = 108)
    private String regional;

    @Column(name = "ID_DISCIPLINA", nullable = false)
    private Long idDisciplina;

}
