package dao;

import bean.Admin;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLAdminDAO implements AdminDAO {
    @Override
    public void updateAdmin(Admin oldAdmin, Admin newAdmin) throws DAOException {
        List<Admin> admins;
        try {
            admins = getAllAdmins();
        }
        catch (DAOException daoExcepetion) {
            throw daoExcepetion;
        }
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).equals(oldAdmin)) {
                admins.remove(i);
                admins.add(i, newAdmin);
                saveAllAdmins(admins);
                return;
            }
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws DAOException {
        List<Admin> admins = new ArrayList<>();
        try {
            admins = getAllAdmins();
        }
        catch (DAOException daoException) {
            throw new DAOException(daoException);
        }
        if (admins.contains(admin)) {
            admins.remove(admin);
            saveAllAdmins(admins);
        }
    }

    @Override
    public void addAdmin(Admin admin) throws DAOException {
        List<Admin> admins = new ArrayList<>();
        try {
            admins = getAllAdmins();
        }
        catch (DAOException daoException) {
            throw new DAOException(daoException);
        }
        if (!admins.contains(admin)) {
            admins.add(admin);
            saveAllAdmins(admins);
        }
    }

    @Override
    public void saveAllAdmins(List<Admin> admins) throws DAOException {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("../XMLStorage/Admins.xml")));
            encoder.writeObject(admins.size());
            for (Admin a : admins) {
                encoder.writeObject(a);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            throw new DAOException(e);
        }
        finally {
            if (encoder != null)
                encoder.close();
        }
    }

    @Override
    public List<Admin> getAllAdmins() throws DAOException {
        XMLDecoder decoder = null;
        List<Admin> admins = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("../XMLStorage/Admins.xml")));
            int adminsCount = (Integer)decoder.readObject();
            for(int i = 0; i < adminsCount; i++) {
                admins.add((Admin)decoder.readObject());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            throw new DAOException(e);
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return admins;
    }
}
