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
        System.out.println(isEmailValid(email));
        System.out.println(isPasswordValid(password));
        if (isEmailValid(email) && isPasswordValid(password)){
            User user = new User(email,password,name);
            System.out.println(user);
            users.add(user);
        return user;
    }
        return null;
    }
    private boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()){
            System.out.println("Ошибка1");
            return false;
        }

        int indexAt = email.indexOf("@");
        if (indexAt <= 0 || indexAt != email.lastIndexOf("@")) {
            System.out.println("Ошибка2");
            return false;
        }


        int indexFirstDotAfterAt = email.indexOf('.', indexAt);
        if (indexFirstDotAfterAt == -1 || indexFirstDotAfterAt == indexAt + 1){
            System.out.println("Ошибка3");
            return false;
        }

        if (email.lastIndexOf('.') >= email.length() - 2) {
            System.out.println("Ошибка4");
            return false;
        }

        boolean isCharAlphabetic = Character.isAlphabetic(email.charAt(0));

        if (!isCharAlphabetic) {
            System.out.println("Ошибка5");
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
                System.out.println("Ошибка6");
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


        boolean[] res = new boolean[4];

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
}
