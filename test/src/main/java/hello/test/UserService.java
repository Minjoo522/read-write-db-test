package hello.test;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public void saveRead(String name) {
        User user = new User(name);
        userRepository.save(user);
    }

    @Transactional
    public void saveWrite(String name) {
        User user = new User(name);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getListRead() {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> getListWrite() {
        return userRepository.findAll();
    }
}
