package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    // this will return all the posts of the logged in user
    @RequestMapping("/posts")
    public String getUserPosts() {
        return "posts";
    }
}
