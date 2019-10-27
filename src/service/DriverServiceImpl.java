package service;

import bean.Driver;
import dao.DAOFactory;
import dao.DriverDAO;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    @Override
    public void updateDriver(Driver oldDriver, Driver newDriver) {
        DAOFactory factory = DAOFactory.getFactory();
        DriverDAO driverDAO = factory.getDriverDAO();
        driverDAO.updateDriver(oldDriver, newDriver);
    }

    @Override
    public void deleteDriver(Driver driver) {
        DAOFactory factory = DAOFactory.getFactory();
        DriverDAO driverDAO = factory.getDriverDAO();
        driverDAO.deleteDriver(driver);
    }

    @Override
    public void addDriver(Driver driver) {
        DAOFactory factory = DAOFactory.getFactory();
        DriverDAO driverDAO = factory.getDriverDAO();
        driverDAO.addDriver(driver);
    }

    @Override
    public void saveAllDrivers(List<Driver> drivers) {
        DAOFactory factory = DAOFactory.getFactory();
        DriverDAO driverDAO = factory.getDriverDAO();
        driverDAO.saveAllDrivers(drivers);
    }

    @Override
    public List<Driver> getAllDrivers() {
        DAOFactory factory = DAOFactory.getFactory();
        DriverDAO driverDAO = factory.getDriverDAO();
        return driverDAO.getAllDrivers();
    }
}
