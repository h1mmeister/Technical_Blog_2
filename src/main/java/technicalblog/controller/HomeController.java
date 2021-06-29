package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model) {

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

        // preparing the model object
        model.addAttribute("posts", posts);

        return "index";

    }
}
