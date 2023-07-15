package co.gov.policia.pwa.payload.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	private String jwt;
	private Long consecutivo;
	private Long undeCodigoSipac;
	private String unidad;
    private String nombres;
    private Long identificacion;	
    private String usuarioSipac;    
    private String correoElectronico;
    private String activo;
    private Long autorizado;
	private Map<String, String> roles;
	private String tiempoTimeOut;
	private String regional;
	private String descripcionGrupo;
	private String ip;
	private String so;
	
	/*public JwtResponse(String jwt, Long consecutivo, Long undeCodigoSipac, String unidad, String nombres, Long identificacion, String usuarioSipac, String correoElectronico, String activo, Long autorizado, Map<String, String> roles, String tiempoTimeOut, String regional, String descripcionGrupo) {
		this.jwt = jwt;
		this.consecutivo = consecutivo;
		this.undeCodigoSipac = undeCodigoSipac;
		this.unidad = unidad;
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.usuarioSipac = usuarioSipac;
        this.correoElectronico = correoElectronico;
        this.activo = activo;        
        this.autorizado = autorizado;        
		this.roles = roles;
		this.tiempoTimeOut = tiempoTimeOut;
		this.regional = regional;
		this.descripcionGrupo = descripcionGrupo;
	}*/

}
