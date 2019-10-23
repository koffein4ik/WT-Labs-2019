import bean.User;
import dao.XMLUserDAO;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        XMLUserDAO userDAO = new XMLUserDAO();
        User us = new User("Johnnie", "Walker", "+3156484964", "MP2352362", "JWalker", 10000, 10);
        List<User> users = new ArrayList<>();
        users.add(us);
        userDAO.saveAllUsers(users);
        userDAO.getAllUsers();
    }
}
