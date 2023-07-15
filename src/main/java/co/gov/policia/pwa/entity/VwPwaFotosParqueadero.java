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
@Table(schema = "USR_SIGIC", name = "VW_PWA_FOTOS_PARQUEADERO")
public class VwPwaFotosParqueadero {
	
	@Column(name = "NOMBRE", nullable = true, length = 105)
    private String nombre;
	
	@Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
	
	@Id
	@Column(name = "DOC_DOCUMENTOS_ID", nullable = false)
    private Long docDocumentosId;
	
	@Column(name = "RUTA", nullable = false, length = 60)
    private String ruta;

}
