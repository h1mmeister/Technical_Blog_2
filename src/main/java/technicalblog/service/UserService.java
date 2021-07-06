package technicalblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.User;
import technicalblog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // checking whether the username is "himanshu" or not for successful login
    public boolean login(User user) {
        if (user.getUsername().equals("himanshu")) {
            return true;
        } else {
            return false;
        }
    }

    // add the fields in the database when the user registers
    public void registerUser(User newUser) {
        repository.registerUser(newUser);
    }
}
