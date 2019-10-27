package service;

import bean.User;
import dao.DAOFactory;
import dao.UserDAO;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void updateUser(User oldUser, User newUser) {
        DAOFactory factory = DAOFactory.getFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateUser(oldUser, newUser);
    }

    @Override
    public void deleteUser(User user) {
        DAOFactory factory = DAOFactory.getFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.deleteUser(user);
    }

    @Override
    public void addUser(User user) {
        DAOFactory factory = DAOFactory.getFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.addUser(user);
    }

    @Override
    public void saveAllUsers(List<User> users) {
        DAOFactory factory = DAOFactory.getFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.saveAllUsers(users);
    }

    @Override
    public List<User> getAllUsers() {
        DAOFactory factory = DAOFactory.getFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getAllUsers();
    }
}
