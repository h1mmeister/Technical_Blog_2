package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    // when the user will click on the login link
    @RequestMapping("/users/login")
    public String login() {
        return "users/login";
    }

    // when the user will click on the registration link
    @RequestMapping("/users/registration")
    public String registration() {
        return "users/registration";
    }

    // when the user click on the login button submitting the form details
    @RequestMapping(value ="/users/login", method = RequestMethod.POST)
    public String loginUser(User user) {
        if (userService.login(user)) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }
    }

    // when the user will click on the registration button
    @RequestMapping(value = "/users/registration", method = RequestMethod.POST)
    public String registrationUser(User user) {
        return "redirect:/users/login";
    }

    // when the user will click on the logout button
    @RequestMapping(value = "/users/logout", method = RequestMethod.POST)
    public String logoutUser(Model model) {
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

}
