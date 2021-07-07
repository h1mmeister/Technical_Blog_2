package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    // this will register the user
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

    // this will check the user in the database whether we have the user present in the database or not
    public User checkUser(String username, String password) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        typedQuery.setParameter("username", username);
        typedQuery.setParameter("password", password);

       return typedQuery.getSingleResult();
    }
}
