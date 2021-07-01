package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.User;

@Service
public class UserService {

    // checking whether the username is "himanshu" or not for successful login
    public boolean login(User user) {
        if (user.getUsername().equals("himanshu")) {
            return true;
        } else {
            return false;
        }
    }
}
