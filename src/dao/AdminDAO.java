package dao;

import bean.Admin;

import java.util.List;

public interface AdminDAO {
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    void addAdmin(Admin admin);
    void saveAllAdmins(List<Admin> admins);
    List<Admin> getAllAdmins();
}