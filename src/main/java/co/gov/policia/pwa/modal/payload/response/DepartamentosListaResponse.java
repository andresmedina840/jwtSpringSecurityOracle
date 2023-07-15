package co.gov.policia.pwa.modal.payload.response;

import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartamentosListaResponse {
    
    private DepartamentosLista msg;
    private String code;
    private String message; 
    private Long codigo;


    public DepartamentosListaResponse(DepartamentosLista msg,  String code, String message ) {
        this.msg = msg;
        this.message = message;
        this.code = code;
    }

    public DepartamentosListaResponse(DepartamentosLista msg,  String code, String message , Long codigo ) {
        this.msg = msg;
        this.message = message;
        this.code = code;
        this.codigo = codigo;
 
    }

}
