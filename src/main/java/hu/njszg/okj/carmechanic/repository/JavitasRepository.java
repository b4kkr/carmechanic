package hu.njszg.okj.carmechanic.repository;

import hu.njszg.okj.carmechanic.entities.Autos;
import hu.njszg.okj.carmechanic.entities.Javitas;
import hu.njszg.okj.carmechanic.entities.Szerelo;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class JavitasRepository {

    private final EntityManager entityManager;

    public List<Javitas> getJavitasok(){
        try (Session session = entityManager.unwrap(Session.class)){
            return session.createQuery("from Javitas jav order by jav.szerelo.nev asc, jav.datum asc").getResultList();
        }
    }

    public Javitas getJavitasById(Long id){
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(Javitas.class, id);
        }
    }

    public List<Javitas> getJavitasokBySzereloMinAr(String szerelo, int minar){
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.createQuery("from Javitas jav where jav.szerelo.nev = ?1 and jav.iranyar > ?2 order by iranyar asc")
                .setParameter(1, szerelo)
                .setParameter(2, minar)
                .getResultList();
        }
    }

    public Szerelo getSzereloNevAlapjan(String szereloNev) {
        try (Session session = entityManager.unwrap(Session.class)){
            return (Szerelo) session.createQuery("from Szerelo sz where sz.nev = ?1")
                .setParameter(1, szereloNev)
                .getSingleResult();
        }
    }

    public Autos getAutosNevAlapjan(String autosNev) {
        try (Session session = entityManager.unwrap(Session.class)){
            return (Autos) session.createQuery("from Autos a where a.nev = ?1")
                .setParameter(1, autosNev)
                .getSingleResult();
        }
    }

    public void javitasMentes(Javitas javitas){
        try (Session session = entityManager.unwrap(Session.class)) {
            session.saveOrUpdate(javitas);
        }
    }

}
