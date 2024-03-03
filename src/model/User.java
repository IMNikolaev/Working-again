package model;


import repository.ReaderRepository;
import repository.UserRepository;

public class User {
    private static int nextId = 1;
    private String name;
    private int id;
    private String email;
    private String password;
    private Role role;
    private Reader reader;



    public User(String email, String password, String name) {
        this.name = name;
        this.id = nextId++;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
    }

    public int getId() {
        return id;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}
