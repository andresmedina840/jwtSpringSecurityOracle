package co.gov.policia.pwa.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import co.gov.policia.pwa.entity.AdmDisciplinasJecri;
import co.gov.policia.pwa.entity.PwaProcedimientosJecri;
import co.gov.policia.pwa.entity.PwaRutaRepositorio;
import co.gov.policia.pwa.service.FotosLaboratorioService;

@Service
public class FotosLaboratorioImpl extends AbstractService implements FotosLaboratorioService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    FotosLaboratorioService fotosLaboratorioService;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public PwaRutaRepositorio getRutaDocumentosActiva() {
        List<PwaRutaRepositorio> lstparametros = new ArrayList<>();
        PwaRutaRepositorio parametros = null;
        try {

            Query q = em.createNativeQuery("SELECT * FROM PWA_RUTA_REPOSITORIO WHERE ACTIVO = 'SI'",
                    PwaRutaRepositorio.class);

            lstparametros = q.getResultList();
            if (lstparametros.size() > 0) {
                parametros = lstparametros.get(0);
            }

        } catch (Exception ex) {
            System.out.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
            System.err.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
            lstparametros = new ArrayList<>();
        }
        return parametros;
    }

    @Override
    @Transactional
    public AdmDisciplinasJecri getNombreDeArchivo(Long codigoLaboratorio) {
        List<AdmDisciplinasJecri> lstparametros = new ArrayList<>();
        AdmDisciplinasJecri parametros = null;
        try {

            long codigoLaboratorioLong = Long.valueOf(codigoLaboratorio);

            TypedQuery<AdmDisciplinasJecri> q = em.createQuery(
                    "SELECT u FROM AdmDisciplinasJecri u where u.consecutivo=:consecutivo",
                    AdmDisciplinasJecri.class);

            q.setParameter("consecutivo", codigoLaboratorioLong);

            lstparametros = q.getResultList();
            if (lstparametros.size() > 0) {
                parametros = lstparametros.get(0);
            } else {
                parametros = new AdmDisciplinasJecri();
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
            lstparametros = new ArrayList<>();
        }
        return parametros;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public PwaProcedimientosJecri getNombreProdeci(Long consecutivo, Long idDisciplina) {
        List<PwaProcedimientosJecri> lstPwaProcedimientosJecri = new ArrayList<>();
        PwaProcedimientosJecri pwaProcedimientosJecri = null;
        try {

            Query q = em.createNativeQuery(
                    "SELECT * FROM PWA_PROCEDIMIENTOS_JECRI WHERE CONSECUTIVO = ? AND ID_DISCIPLINAS = ?",
                    PwaProcedimientosJecri.class);

            q.setParameter(1, consecutivo);
            q.setParameter(2, idDisciplina);

            lstPwaProcedimientosJecri = q.getResultList();
            if (lstPwaProcedimientosJecri.size() > 0) {
            	pwaProcedimientosJecri = lstPwaProcedimientosJecri.get(0);
            } else {
            	pwaProcedimientosJecri = new PwaProcedimientosJecri();
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
        }
        return pwaProcedimientosJecri;
    }

}
