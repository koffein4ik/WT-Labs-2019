package dao;

import bean.Truck;

import java.util.List;

public interface TruckDAO {
    void updateTruck(Truck truck);
    void deleteTruck(Truck truck);
    void addTruck(Truck truck);
    void saveAllTrucks(List<Truck> trucks);
    List<Truck> getAllTrucks();
}
