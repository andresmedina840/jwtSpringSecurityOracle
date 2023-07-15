package co.gov.policia.pwa.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import co.gov.policia.pwa.entity.EmpleadosSipac;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;

public class UserDetalle implements UserDetails {

	private static final long serialVersionUID = 8536963196785633346L;
	@SuppressWarnings("unused")
	private Long id;
	private String usuario;
	private String password;
	@SuppressWarnings("unused")
	private Long cedula;

	private Collection<? extends GrantedAuthority> autoridades;

	public UserDetalle(Long id, String usuario, String password, Long cedula,
			Collection<? extends GrantedAuthority> autoridades) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.cedula = cedula;
		this.autoridades = autoridades;
	}

	public UserDetalle(EmpleadosSipac user) {

	}

	public static UserDetalle construirUsuario(VwPwaAdminUsuarios usuario) {
		return new UserDetalle(45L, usuario.getUsuarioSipac(), usuario.getClave(), usuario.getIdentificacion(), null);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autoridades;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
