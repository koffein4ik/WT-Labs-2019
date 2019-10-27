package service;

import bean.Admin;
import dao.DAOFactory;
import dao.AdminDAO;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public void updateAdmin(Admin oldAdmin, Admin newAdmin) {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        adminDAO.updateAdmin(oldAdmin, newAdmin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        adminDAO.deleteAdmin(admin);
    }

    @Override
    public void addAdmin(Admin admin) {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        adminDAO.addAdmin(admin);
    }

    @Override
    public void saveAllAdmins(List<Admin> admins) {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        adminDAO.saveAllAdmins(admins);
    }

    @Override
    public List<Admin> getAllAdmins() {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        return adminDAO.getAllAdmins();
    }
}

