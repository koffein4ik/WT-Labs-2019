package dao;

import bean.User;

import java.util.List;

public interface UserDAO {
    void updateUser(User oldUser, User newUser);
    void deleteUser(User user);
    void addUser(User user);
    void saveAllUsers(List<User> users);
    List<User> getAllUsers();
}
