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

    // it will return a single post
    public Post getLatestPost() {
        return  postRepository.getLatestPost();
    }

    public void createPost(Post newPost) {

    }
}
