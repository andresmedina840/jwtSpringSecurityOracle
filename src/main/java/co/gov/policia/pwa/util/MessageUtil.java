package co.gov.policia.pwa.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageUtil {
	
	OK("Proceso exitoso.", 200),
	CREATED("Creación exitosa.", 201),
	UPDATED("Actualizacion exitosa.", 200),
	DELETED("Eliminación exitosa.", 200),
	BADREQUEST("Hubo un error en su petición.", 400),
	NOTFOUND("No existen registros.", 404),
	INTERNALERROR("Error en el servidor.", 500),
	CONFLICT("Hubo un conflcito en su petición.", 409);
	
	private String key;
	private int code;

}
