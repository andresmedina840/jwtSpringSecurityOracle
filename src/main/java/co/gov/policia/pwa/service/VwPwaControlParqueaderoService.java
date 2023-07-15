package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;

import co.gov.policia.pwa.entity.VwPwaFotosParqueadero;

public interface VwPwaControlParqueaderoService extends Serializable {

    public ResponseEntity<?> selectVwPwaControlParqueaderoByPlaca(String PlacaVehiculo);
    
    public ResponseEntity<?> selectVwPwaControlParqueaderoByPlaca1(String PlacaVehiculo);
    
    public VwPwaFotosParqueadero obtenerNombreImagenParqueadero(Long consecutivo);
    
    public VwPwaFotosParqueadero obtenerNombreFotosParqueadero(Long docDocumentosId);

}