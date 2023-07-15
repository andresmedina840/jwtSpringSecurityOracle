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
@Table(schema = "USR_SIGIC", name = "VW_ADM_SIG_USUARIO_PERFIL")
@NamedQueries({ @NamedQuery(name = "VwAdmUsuarioPerfil.findAll", query = "select v from VwAdmUsuarioPerfil v "),
		@NamedQuery(name = "VwAdmUsuarioPerfil.findPorPerfilesAsignados", query = "select v from VwAdmUsuarioPerfil v WHERE v.usuario = :usuario AND v.tipoConsulta = 'I' AND v.estado = 'A' ORDER BY v.nomPerfil"),
		@NamedQuery(name = "VwAdmUsuarioPerfil.findAllUsuario", query = "select v from VwAdmUsuarioPerfil v WHERE v.usuario = :usuario ORDER BY v.nomPerfil"),
		@NamedQuery(name = "VwAdmUsuarioPerfil.findPorPerfilesNoAsignados", query = "select v from VwAdmUsuarioPerfil v WHERE v.usuario = :usuario AND v.tipoConsulta = 'N' AND v.estado = 'A' ORDER BY v.nomPerfil"), })

public class VwAdmUsuarioPerfil implements Serializable {

	private static final long serialVersionUID = 123214324L;

	@Id
	@Column(name = "USUARIO")
	private String usuario;
	
	@Id
	@Column(name = "ID_PERFIL")
	private Long idPerfil;
	
	@Column(name = "NUSUARIO_ID")
	private Long nUsuarioId;
	
	@Column(name = "NOM_USUARIO")
	private String nomUsuario;
	
	@Column(name = "NOM_PERFIL")
	private String nomPerfil;
	
	@Column(name = "TIPO_CONSULTA")
	private String tipoConsulta;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "TIPO_APP")
	private String tipoApp;
	
	@Column(name = "D_TIPO_APP")
	private String dTipoApp;

}
