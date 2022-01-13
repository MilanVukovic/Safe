package at.safeplace.service;

import at.safeplace.model.User;
import at.safeplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository repo;

    public void register(User user) {
        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);

        repo.save(user);
    }

}
