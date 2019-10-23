package dao;

import bean.User;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

public class XMLUserDAO implements UserDAO {
    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void saveAllUsers(List<User> users) {

    }

    @Override
    public List<User> getAllUsers() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("./src/XMLStorage/Users.xml");
            Node root = document.getDocumentElement();
            NodeList users = root.getChildNodes();
            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                if (user.getNodeType() != Node.TEXT_NODE) {
                    NodeList userProps = user.getChildNodes();
                    for (int j = 0; j < userProps.getLength(); j++) {
                        Node userProp = userProps.item(j);
                        if (userProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(userProp.getNodeName() + " : " + userProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                }
            }

        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
