package co.gov.policia.pwa.entity;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(schema = "USR_SIGIC", name = "VW_ADM_CARGO")
@NamedQueries({
	@NamedQuery(name = "VwAdmCargo.findAll", query = "select a from VwAdmCargo a")
	})
public class VwAdmCargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ADM_CARGOS_EMPL_ID", nullable = false, length = 4)
	private Long admCargosEmplId;

	@Column(name = "DESCRIPCION", nullable = false, length = 80)
	private String descripcion;

	
}
