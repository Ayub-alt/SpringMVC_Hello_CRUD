package web.hiber.service;

import web.hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUserById(int id);
    List<User> listUsers();
}
