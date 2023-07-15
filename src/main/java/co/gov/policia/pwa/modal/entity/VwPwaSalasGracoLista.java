package co.gov.policia.pwa.modal.entity;

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
@Table(schema = "USR_SIGIC",name = "VW_PWA_SALAS_GRACO")
public class VwPwaSalasGracoLista {
	
	@Column(name = "DESCRIPCION_DEPENDENCIA", nullable = false, length = 100)
    private String descripcionDependencia;
    
    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

}
