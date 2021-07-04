package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.*;
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

    // here we are persisting the newPost to the database
    public Post createPost(Post newPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return newPost;
    }
}
