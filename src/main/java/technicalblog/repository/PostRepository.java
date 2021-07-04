package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    // this will return all the posts
    public List<Post> getAllPosts() {
        EntityManager em =  emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p", Post.class);
        List<Post> resultList = query.getResultList();

        return resultList;
    }

    // this will return the latest post
    public Post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 1);

    }
}
