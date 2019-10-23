package dao;

import bean.Vehicle;

import java.util.List;

public class XMLParkingDAO implements ParkingDAO {
    @Override
    public boolean addVehicleToParking(Vehicle vehicle, bean.Parking parking) {
        return false;
    }

    @Override
    public boolean removeVehicleFromParking(Vehicle vehicle, bean.Parking parking) {
        return false;
    }

    @Override
    public List<Vehicle> getVehiclesOnParking(bean.Parking parking) {
        return null;
    }

    @Override
    public List<bean.Parking> getAllParkings() {
        return null;
    }

    @Override
    public void saveAllParkings(List<bean.Parking> parkings) {

    }

    @Override
    public void addParking(bean.Parking parking) {

    }

    @Override
    public void deleteParking(bean.Parking parking) {

    }
}
