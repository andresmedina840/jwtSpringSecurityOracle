package co.gov.policia.pwa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.gov.policia.pwa.entity.Usuario;
import co.gov.policia.pwa.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		System.out.println("Se carga el usuario en UserDetailServiceImpl");
		Usuario usuario = usuarioRepository.findOneByEmail(email)
		.orElseThrow(() -> new UsernameNotFoundException("El usuario con email: " + email + " no existe."));
		
		return new UserDetailsImpl(usuario);
	}

}
