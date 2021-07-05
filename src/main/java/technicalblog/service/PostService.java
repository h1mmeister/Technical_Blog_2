package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

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
        return postRepository.getLatestPost();
    }

    public void createPost(Post newPost) {
        newPost.setDate(new Date());
        postRepository.createPost(newPost);
        System.out.println("New Post " + newPost );
    }

    // this will fetch the post as per postId from repository
    public Post getPost(Integer postId) {
        return postRepository.getPost(postId);
    }

    // this will set the date of the edited post and return back to controller
    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        postRepository.deletePost(postId);
    }
}
