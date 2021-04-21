package hu.njszg.okj.carmechanic.repository;

import hu.njszg.okj.carmechanic.entities.Javitas;

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

}
