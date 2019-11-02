package service;

import bean.Admin;
import dao.DAOException;
import dao.DAOFactory;
import dao.AdminDAO;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public void updateAdmin(Admin oldAdmin, Admin newAdmin) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        try {
            adminDAO.updateAdmin(oldAdmin, newAdmin);
        }
        catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        try {
            adminDAO.deleteAdmin(admin);
        }
        catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void addAdmin(Admin admin) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        try {
            adminDAO.addAdmin(admin);
        }
        catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public void saveAllAdmins(List<Admin> admins) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        try {
            adminDAO.saveAllAdmins(admins);
        }
        catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }
    }

    @Override
    public List<Admin> getAllAdmins() throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        AdminDAO adminDAO = factory.getAdminDAO();
        List<Admin> admins = null;
        try {
            admins = adminDAO.getAllAdmins();
        }
        catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }
        return admins == null ? new ArrayList<>() : admins;
    }
}

