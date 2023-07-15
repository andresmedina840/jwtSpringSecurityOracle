package co.gov.policia.pwa.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri1Lista;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri2Lista;
import co.gov.policia.pwa.entity.VwPwaUbicaDiciplixRegion;
import co.gov.policia.pwa.modal.entity.VwPwaProcedimientosJecriLista;

public interface VwPwaAdmDisciplinasJecriService extends Serializable {
    
    public List<VwPwaAdmDisciplinasJecri1Lista> selectAllVwPwaAdmDisciplinasJecri1Lista();
    
    public List<VwPwaAdmDisciplinasJecri2Lista> selectAllVwPwaAdmDisciplinasJecri2Lista(Long consecutivo);
    
    public List<VwPwaProcedimientosJecriLista> selectVwPwaProcedimientosJecri(Long consecutivo);
    
    public List<VwPwaUbicaDiciplixRegion> selectVwPwaUbicaDiciplixRegion(Long idDisciplina);

}
