package co.gov.policia.pwa.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "VW_PWA_VALIDA_NRO_UNICO")
public class VwPwaValidaVroUnico {
	
	@Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "NRO_UNICO", nullable = false, length = 21)
    private String NRO_UNICO;

}
