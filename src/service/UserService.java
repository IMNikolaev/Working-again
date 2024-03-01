package service;

import model.Reader;
import model.User;
import repository.UserRepository;

import java.io.FilterOutputStream;

public class UserService {
    private final UserRepository userRepository;
    private final LiberyService liberyService;


    public UserService(UserRepository userRepository, LiberyService liberyService) {
        this.userRepository = userRepository;
        this.liberyService = liberyService;
    }

    public void createUser(String email, String password, String name){
        if (email == null || password == null) {
            System.out.println("Неверный ввод!");
            return;
        }
        boolean isExist = userRepository.isUserEmailExist(email);
        if (isExist) {
            return;
        }
        System.out.println(email + password + name);
        User user = userRepository.createUser(email, password,name);
        if (user!=null) {
            liberyService.addNewReader(name, user.getId());
            return;
        }
        System.out.println("Неудалось зарегистрировать");
    }

    public User userAuthorize (String email, String password) {
        return userRepository.isRegistred(email,password);
    }

    public User activeUser (){
        return userRepository.getActiveUser();
    }


    public void activeUserFalse() {
        userRepository.setActiveUser(null);
    }

    public void blockUser(Integer blockedUserId) {
        userRepository.blockUserById(blockedUserId);
    }
}
