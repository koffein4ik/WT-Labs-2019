package service;

import bean.Driver;

import java.util.List;

public interface DriverService {
    void updateDriver(Driver oldDriver, Driver newDriver);
    void deleteDriver(Driver driver);
    void addDriver(Driver driver);
    void saveAllDrivers(List<Driver> drivers);
    List<Driver> getAllDrivers();
}
