package bean;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String location;
    private int carCapacity;
    private int truckCapacity;
    private List<Vehicle> vehiclesOnParking = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public int getTruckCapacity() {
        return truckCapacity;
    }

    public void setTruckCapacity(int truckCapacity) {
        this.truckCapacity = truckCapacity;
    }

    public List<Vehicle> getVehiclesOnParking() {
        return vehiclesOnParking;
    }

    public void setVehiclesOnParking(List<Vehicle> vehiclesOnParking) {
        this.vehiclesOnParking = vehiclesOnParking;
    }
}
