import dao.XMLUserDAO;

public class Application {
    public static void main(String[] args) {
        XMLUserDAO userDAO = new XMLUserDAO();
        userDAO.getAllUsers();
    }
}
