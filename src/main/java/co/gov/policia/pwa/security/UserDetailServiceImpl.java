package co.gov.policia.pwa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.service.impl.UserServiceImpl;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserServiceImpl usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	System.out.println("Se carga el usuario en UserDetailServiceImpl");
	VwPwaAdminUsuarios usuario = usuarioRepository.selectUserByUsername(username);
		System.out.println("Usuario en public UserDetails loadUserByUsername: "+ usuario.getUsuarioSipac());
		if (usuario.getConsecutivo() != null) {
			return UserDetalle.construirUsuario(usuario);
		} else {
			throw new UsernameNotFoundException("El usuario no existe");
		}
	}

}
