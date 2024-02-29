package service;

import model.Reader;
import model.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final LiberyService liberyService;


    public UserService(UserRepository userRepository, LiberyService liberyService) {
        this.userRepository = userRepository;
        this.liberyService = liberyService;
    }

    public void createUser(String email, String password, String name){
        boolean isExist = userRepository.isUserEmailExist(email);
        if (isExist) {
            return;
        }
        User user = userRepository.createUser(email, password,name);
        liberyService.addNewReader(name,user.getId());

    }

    public User userAuthorize (String email, String password) {
        return userRepository.isRegistred(email,password);
    }

    public User activeUser (){
        return userRepository.getActiveUser();
    }

}
