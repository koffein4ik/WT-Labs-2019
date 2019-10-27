package dao;

import bean.Driver;

import java.util.List;

public interface DriverDAO {
    void updateDriver(Driver oldDriver, Driver newDriver);
    void deleteDriver(Driver driver);
    void addDriver(Driver driver);
    void saveAllDrivers(List<Driver> drivers);
    List<Driver> getAllDrivers();
}
