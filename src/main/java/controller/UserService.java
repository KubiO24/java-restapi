package controller;

import model.User;

import java.util.HashMap;

public interface UserService {
    HashMap<String, User> users = new HashMap<>();

    void addUser(User user);
    HashMap<String, User> getUsers();
    User getUser(String id);
    User editUser(User user);
    void deleteUser(String id);
    Boolean userExist(String id);
}
