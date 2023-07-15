package co.gov.policia.pwa.service;

import java.util.List;
import co.gov.policia.pwa.entity.EmpleadosSipac;
import co.gov.policia.pwa.entity.AdmPwaPerfil;
import co.gov.policia.pwa.entity.VwAdmUsuarioPerfil;
import co.gov.policia.pwa.payload.response.EmpleadosSipacResponse;

public interface AdminUsuariosService {

	public List<VwAdmUsuarioPerfil> selectUsuarioPerfil(String usuario);

	public List<AdmPwaPerfil> selectAllPerfiles();

	public String asignarPerfilesUsuario(String indica, String usuarioEmpresarial, Long nUsuarioID, Long indPerfil);

	public EmpleadosSipacResponse infoUsuarios(EmpleadosSipac usuarioSipac);

	public List<VwAdmUsuarioPerfil> listaAllPerfiles(String username);

	public List<VwAdmUsuarioPerfil> listaPerfilesNoAsignados(String username);
	
	public List<VwAdmUsuarioPerfil> listaPerfilesAsignados(String username);

}
