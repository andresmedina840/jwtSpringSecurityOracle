package co.gov.policia.pwa.entity;

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
@Table(schema = "USR_SIGIC",name = "VW_PWA_CRITERIOS_TRAMITE_GRACO")
public class VwPwaCriteriosTramiteGraco {
	
    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;

    @Column(name = "ID_SOLICITUD", nullable = false)
    private Long idSolicitud;
	
	@Column(name = "OPERADOR", nullable = true, length = 8)
    private String operador;
	
	@Column(name = "IC", nullable = false)
    private Long iC;
	
	@Column(name = "TERMINO", nullable = true)
    private Long termino;
	
	@Column(name = "ACCION", nullable = true, length = 11)
    private String accion;	

}
