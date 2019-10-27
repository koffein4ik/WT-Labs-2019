package dao;

import bean.Driver;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLDriverDAO implements DriverDAO {
    @Override
    public void updateDriver(Driver oldDriver, Driver newDriver) {
        List<Driver> drivers = getAllDrivers();
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).equals(oldDriver)) {
                drivers.remove(i);
                drivers.add(i, newDriver);
                saveAllDrivers(drivers);
                return;
            }
        }
    }

    @Override
    public void deleteDriver(Driver driver) {
        List<Driver> drivers = getAllDrivers();
        if (drivers.contains(driver)) {
            drivers.remove(driver);
            saveAllDrivers(drivers);
        }
    }

    @Override
    public void addDriver(Driver driver) {
        List<Driver> drivers = getAllDrivers();
        if (!drivers.contains(driver)) {
            drivers.add(driver);
            saveAllDrivers(drivers);
        }
    }

    @Override
    public void saveAllDrivers(List<Driver> drivers) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("./src/XMLStorage/Drivers.xml")));
            encoder.writeObject(drivers.size());
            for (Driver u : drivers) {
                encoder.writeObject(u);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (encoder != null)
                encoder.close();
        }
    }

    @Override
    public List<Driver> getAllDrivers() {
        XMLDecoder decoder = null;
        List<Driver> drivers = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./src/XMLStorage/Drivers.xml")));
            int driversCount = (Integer)decoder.readObject();
            for(int i = 0; i < driversCount; i++) {
                drivers.add((Driver)decoder.readObject());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return drivers;
    }
}
