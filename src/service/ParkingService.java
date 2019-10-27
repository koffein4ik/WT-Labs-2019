package service;

import bean.Parking;
import bean.Vehicle;

import java.util.List;

public interface ParkingService {
    boolean addVehicleToParking(Vehicle vehicle, Parking parking);
    boolean removeVehicleFromParking(Vehicle vehicle, Parking parking);
    List<Vehicle> getVehiclesOnParking(Parking parking);
    List<Parking> getAllParkings();
    void saveAllParkings(List<Parking> parkings);
    void updateParking(Parking oldParking, Parking newParking);
    void addParking(Parking parking);
    void deleteParking(Parking parking);

}
