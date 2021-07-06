package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void registerUser(User newUser) {
      EntityManager em = emf.createEntityManager();
      EntityTransaction transaction = em.getTransaction();

      try {
          transaction.begin();
          em.persist(newUser);
          transaction.commit();
      } catch( Exception e) {
          transaction.rollback();
      }
    }
}
