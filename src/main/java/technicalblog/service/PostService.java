package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    // we are building the posts here
    public ArrayList<Post> getAllPosts() {

        ArrayList<Post> posts = new ArrayList<>();

        // creating an object of class Post
        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setBody("Post 1 Body");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post 2 Body");
        post2.setDate(new Date());

        // adding the posts in the arraylist
        posts.add(post1);
        posts.add(post2);

        return posts;
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
}
