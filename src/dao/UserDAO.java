package dao;

import bean.User;

import java.util.List;

public interface UserDAO {
    void updateUser(User user);
    void deleteUser(User user);
    void saveAllUsers(List<User> users);
    List<User> getAllUsers();
}
