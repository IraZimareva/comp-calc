package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.UserNotFoundException;
import zimareva.model.User;
import zimareva.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Transactional
    public User editUser(Long id,User user){
        User userToEdit = getUser(id);
        userToEdit.setLastname(user.getLastname());
        userToEdit.setFirstname(user.getFirstname());
        userToEdit.setSecondname(user.getSecondname());
        userToEdit.setGender(user.getGender());
        userToEdit.setDateOfBirth(user.getDateOfBirth());
        userToEdit.setCity(user.getCity());
        userToEdit.setRang(user.getRang());
        userToEdit.setMobilePhone(user.getMobilePhone());
        userToEdit.setEmail(user.getEmail());
        return userToEdit;
    }
}
