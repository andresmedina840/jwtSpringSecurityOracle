package co.gov.policia.pwa.service;

import java.io.Serializable;
import co.gov.policia.pwa.entity.AdmDisciplinasJecri;
import co.gov.policia.pwa.entity.PwaProcedimientosJecri;
import co.gov.policia.pwa.entity.PwaRutaRepositorio;

public interface FotosLaboratorioService extends Serializable {

    public PwaRutaRepositorio getRutaDocumentosActiva();
    
    public AdmDisciplinasJecri getNombreDeArchivo(Long codigoLaboratorio);
    
    public PwaProcedimientosJecri getNombreProdeci(Long consecutivo, Long idDisciplina);
    
}
