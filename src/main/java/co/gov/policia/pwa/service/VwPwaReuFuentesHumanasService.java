package co.gov.policia.pwa.service;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.entity.VwPwaReuFuentesHumanas;

public interface VwPwaReuFuentesHumanasService extends Serializable {

    public ResponseEntity<?> insertVwPwaReuFuentex(VwPwaReuFuentesHumanas vwPwaReuFuentesHumanas, String usuarioConexion);

    public ResponseEntity<?> updateVwPwaReuFuentex(VwPwaReuFuentesHumanas vwPwaReuFuentesHumanas, String usuarioConexion);

}