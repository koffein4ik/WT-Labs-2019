package dao;

import bean.Driver;

import java.util.List;

public interface DriverDAO {
    void updateDriver(Driver driver);
    void deleteDriver(Driver driver);
    void saveAllDrivers(List<Driver> drivers);
    List<Driver> getAllDrivers();
}
