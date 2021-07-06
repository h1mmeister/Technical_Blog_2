package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import java.util.List;

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
    public String registration(Model model) {
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);

        model.addAttribute("User", user);
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
        userService.registerUser(user);
        return "redirect:/users/login";
    }

    // when the user will click on the logout button
    @RequestMapping(value = "/users/logout", method = RequestMethod.POST)
    public String logoutUser(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

}
