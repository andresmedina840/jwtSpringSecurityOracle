package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaSeguimientoCasos;
import java.util.List;

public interface VwPwaSeguimientoCasosService extends Serializable {

    public ResponseEntity<?> insertVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion);

    public ResponseEntity<?> updateVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion);

    public ResponseEntity<?> deleteVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion);

    public ResponseEntity<?> selectVwPwaSeguimientoCasosByConsCaso(Long conscaso);

    public ResponseEntity<?> selectVwPwaSeguimientoCasosByConsCasoLike(Long conscaso);

    public List<VwPwaSeguimientoCasos> selectAllVwPwaSeguimientoCasos();
}