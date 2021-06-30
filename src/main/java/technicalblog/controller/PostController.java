package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    // this will return all the posts of the logged in user
    @RequestMapping("/posts")
    public String getUserPosts(Model model) {
        ArrayList<Post> posts = postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";
    }
}
