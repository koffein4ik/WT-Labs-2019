package dao;

import bean.Admin;

import java.util.List;

public interface AdminDao {
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    void saveAllAdmins(List<Admin> admins);
    List<Admin> getAllAdmins();
}
