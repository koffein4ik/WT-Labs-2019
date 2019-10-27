package dao;

import bean.Truck;

import java.util.List;

public interface TruckDAO {
    void updateTruck(Truck oldTruck, Truck newTruck);
    void deleteTruck(Truck truck);
    void addTruck(Truck truck);
    void saveAllTrucks(List<Truck> trucks);
    List<Truck> getAllTrucks();
}
