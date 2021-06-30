package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.User;

@Controller
public class UserController {

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
        return "redirect:/posts";
    }
}
