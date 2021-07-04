package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // we are building the posts here
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    // we will return a single post
    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("My Post");
        post1.setBody("Software Engineering is cool :)");
        post1.setDate(new Date());

        posts.add(post1);

        return posts;
    }

    public void createPost(Post newPost) {

    }
}
