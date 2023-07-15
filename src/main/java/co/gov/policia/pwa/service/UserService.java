package co.gov.policia.pwa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.PwaSesionesActivas;
import co.gov.policia.pwa.entity.SbParametros;
import co.gov.policia.pwa.entity.VwAdmUsuarioPerfil;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaPerfilUsuarios;

public interface UserService {
	
	public VwPwaAdminUsuarios buscarPwa(String usuarioEmpresarial);
	
	public VwPwaAdminUsuarios buscarPwa2(String usuarioEmpresarial);
	
	public String grupoUsuario(String usuarioEmpresarial);
	
	public VwAdmUsuarioPerfil buscarUsuarioPorPerfil(String usuarioEmpresarial);

	public List<VwPwaAdminUsuarios> consultarUsuarioDependencia(String idUsuario);

	public String autenticarUsuarioOID(String pUserName, String pPassword);

	public ArrayList<VwPwaPerfilUsuarios> obtenerObjetosUsuario(String usuario);

	public ArrayList<VwAdmUsuarioPerfil> obtenerAppModuloUsuario(String usuario);

	public List<VwPwaAdminUsuarios> selectAllUsuarios();

	public VwPwaAdminUsuarios selectUserByUsername(String username);
	
	public ResponseEntity<?> enviarCorreoLogueo(String usuarioConexion, String mirarIpCaptura);
	
	public ResponseEntity<?> piePaginaInicioPagina();
	
	public SbParametros buscarEnSbParametros(String aplicacion, String parametro);
	
	public ResponseEntity<?> registroDatosSession(PwaSesionesActivas pwaSesionesActivas);
	
	public PwaSesionesActivas buscarSessionActivaByUsuario(String usuarioEmpresarial);
	
	public ResponseEntity<?> cerrarSession(PwaSesionesActivas pwaSesionesActivas);
	
	public Long conteoSessionesActivas();

}
