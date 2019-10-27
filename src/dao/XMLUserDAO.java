package dao;

import bean.User;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLUserDAO implements UserDAO {
    @Override
    public void updateUser(User oldUser, User newUser) {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(oldUser)) {
                users.remove(i);
                users.add(i, newUser);
                saveAllUsers(users);
                return;
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        List<User> users = getAllUsers();
        if (users.contains(user)) {
            users.remove(user);
            saveAllUsers(users);
        }
    }

    @Override
    public void addUser(User user) {
        List<User> users = getAllUsers();
        if (!users.contains(user)) {
            users.add(user);
            saveAllUsers(users);
        }
    }

    @Override
    public void saveAllUsers(List<User> users) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("./src/XMLStorage/Users.xml")));
            encoder.writeObject(users.size());
            for (User u : users) {
                encoder.writeObject(u);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (encoder != null)
                encoder.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        XMLDecoder decoder = null;
        List<User> users = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./src/XMLStorage/Users.xml")));
            int usersCount = (Integer)decoder.readObject();
            for(int i = 0; i < usersCount; i++) {
                users.add((User)decoder.readObject());
            }
            for (User u : users) {
                System.out.println(u.getMoneyOnBalance());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return users;
    }
}
