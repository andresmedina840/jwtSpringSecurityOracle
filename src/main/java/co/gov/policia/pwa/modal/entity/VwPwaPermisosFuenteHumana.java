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
@Table(schema = "USR_SIGIC", name = "VW_PWA_PERMISOS_FUENTE_HUMANA")
public class VwPwaPermisosFuenteHumana {
	
	@Id
	@Column(name = "ID", nullable = false)
    private Long id;
	
	@Column(name = "USUARIO_SIPAC", nullable = true, length = 30)
    private String usuarioSipac;
    
	@Column(name = "FUENTE_ID", nullable = false)
    private Long fuenteId;
	
    @Column(name = "CODIGO_FUENTE", nullable = true, length = 20)
    private String codigoFuente;
    
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "INVESTIGADOR", nullable = false)
    private Long invetigador;
    
    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;
    
    @Column(name = "USUARIO_CREADOR", nullable = false, length = 30)
    private String usuarioCreador;

}
