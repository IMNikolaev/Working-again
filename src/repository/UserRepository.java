package repository;

import model.Role;
import model.User;
import util.MyLinkedList;


public class UserRepository {
    private final MyLinkedList<User> users;
    private User activeUser;


    public UserRepository(MyLinkedList<User> users) {
        this.users = users;
        init();
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    private void init() {
        User admin = new User("1", "1", "1");
        admin.setRole(Role.ADMIN);
        users.add(admin);
    }
    public boolean isUserEmailExist(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) return true;
        }
        return false;
    }

    public User createUser(String email, String password, String name) {
        User user = new User(email,password,name);
        users.add(user);
        return user;
    }

    public User isRegistred (String email, String password){
        for (int i = 0; i < users.size(); i++) {
                if (email.equalsIgnoreCase(users.get(i).getEmail())){
                    if (password.equals(users.get(i).getPassword())){
                        activeUser= users.get(i);
                        return activeUser;
                    }
                }
        }
        return null;
    }
}
