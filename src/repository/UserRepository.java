package repository;

import model.Role;
import model.User;
import util.MyLinkedList;


public class UserRepository {
    private final MyLinkedList<User> users;
    private User activeUser;


    public UserRepository() {
        this.users = new MyLinkedList<>();
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
        if (isEmailValid(email) && isPasswordValid(password)){
            User user = new User(email,password,name);
            users.add(user);
        return user;
    }
        return null;
    }


    private boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()){
            return false;
        }

        int indexAt = email.indexOf("@");
        if (indexAt <= 0 || indexAt != email.lastIndexOf("@")) {
            return false;
        }


        int indexFirstDotAfterAt = email.indexOf('.', indexAt);
        if (indexFirstDotAfterAt == -1 || indexFirstDotAfterAt == indexAt + 1){
            return false;
        }

        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }

        boolean isCharAlphabetic = Character.isAlphabetic(email.charAt(0));

        if (!isCharAlphabetic) {
            return false;
        }

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);

            boolean isCharValid = (Character.isAlphabetic(c)
                    || Character.isDigit(c)
                    || c == '-'
                    || c == '_'
                    || c == '.'
                    || c == '@');
            if (!isCharValid){
                return false;
            }
        }

        return true;
    }


    private boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) return false;

        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isDigit = false;
        boolean isSpacialSymbol = false;



        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                isDigit = true;
                continue;
            }

            if (Character.isLowerCase(c)) {
                isLowerCase = true;
                continue;
            }
            if (Character.isUpperCase(c)) {
                isUpperCase = true;
                continue;
            }

            if ("!%$@&*()[]".indexOf(c) >= 0) {
                isSpacialSymbol = true;
                continue;
            }

        }

        return isLowerCase && isUpperCase && isDigit && isSpacialSymbol;

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

    public void blockUserById(Integer blockedUserId) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==blockedUserId){
                user = users.get(i);
                break;
            }
            
        }
        if (user!=null){
            user.setRole(Role.BLOCKED);
        }
    }
}
