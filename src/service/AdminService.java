package service;

import bean.Admin;
import dao.DAOException;

import java.util.List;

public interface AdminService {
    void updateAdmin(Admin oldAdmin, Admin newAdmin) throws ServiceException;
    void deleteAdmin(Admin admin) throws ServiceException;
    void addAdmin(Admin admin) throws ServiceException;
    void saveAllAdmins(List<Admin> admins) throws ServiceException;
    List<Admin> getAllAdmins() throws ServiceException;
}
