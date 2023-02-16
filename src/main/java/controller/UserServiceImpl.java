package controller;

import model.User;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private static final HashMap<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public HashMap<String, User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    @Override
    public Boolean userExist(String id) {
        return null;
    }
}
