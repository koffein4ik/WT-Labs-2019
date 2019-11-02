package dao;

import bean.Admin;

import java.util.List;

public interface AdminDAO {
    void updateAdmin(Admin oldAdmin, Admin newAdmin) throws DAOException;
    void deleteAdmin(Admin admin) throws DAOException;
    void addAdmin(Admin admin) throws DAOException;
    void saveAllAdmins(List<Admin> admins) throws DAOException;
    List<Admin> getAllAdmins() throws DAOException;
}
