package co.gov.policia.pwa.modal.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionLista implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String nombre;

}
