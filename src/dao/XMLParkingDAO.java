package dao;

import bean.Parking;
import bean.Vehicle;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParkingDAO implements ParkingDAO {
    @Override
    public void updateParking(Parking oldParking, Parking newParking) {
        List<Parking> parkings = getAllParkings();
        for (int i = 0; i < parkings.size(); i++) {
            if (parkings.get(i).equals(oldParking)) {
                parkings.remove(i);
                parkings.add(i, newParking);
                saveAllParkings(parkings);
                return;
            }
        }
    }

    @Override
    public void deleteParking(Parking parking) {
        List<Parking> parkings = getAllParkings();
        if (parkings.contains(parking)) {
            parkings.remove(parking);
            saveAllParkings(parkings);
        }
    }

    @Override
    public void addParking(Parking parking) {
        List<Parking> parkings = getAllParkings();
        if (!parkings.contains(parking)) {
            parkings.add(parking);
            saveAllParkings(parkings);
        }
    }

    @Override
    public void saveAllParkings(List<Parking> parkings) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("./src/XMLStorage/Parkings.xml")));
            encoder.writeObject(parkings.size());
            for (Parking u : parkings) {
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
    public List<Parking> getAllParkings() {
        XMLDecoder decoder = null;
        List<Parking> parkings = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./src/XMLStorage/Parkings.xml")));
            int parkingsCount = (Integer)decoder.readObject();
            for(int i = 0; i < parkingsCount; i++) {
                parkings.add((Parking)decoder.readObject());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return parkings;
    }

    @Override
    public boolean addVehicleToParking(Vehicle vehicle, Parking parking) {
        List<Parking> parkings = getAllParkings();
        for(Parking p : parkings) {
            if (p.equals(parking)) {
                List<Vehicle> allVehiclesOnParking = p.getVehiclesOnParking();
                if (!allVehiclesOnParking.contains(vehicle))
                    allVehiclesOnParking.add(vehicle);
                saveAllParkings(parkings);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeVehicleFromParking(Vehicle vehicle, Parking parking) {
        List<Parking> parkings = getAllParkings();
        for(Parking p : parkings) {
            if (p.equals(parking)) {
                List<Vehicle> allVehiclesOnParking = p.getVehiclesOnParking();
                if (!allVehiclesOnParking.contains(vehicle))
                    allVehiclesOnParking.remove(vehicle);
                saveAllParkings(parkings);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vehicle> getVehiclesOnParking(Parking parking) {
        List<Parking> parkings = getAllParkings();
        for(Parking p : parkings) {
            if (p.equals(parking)) {
               return p.getVehiclesOnParking();
            }
        }
        return new ArrayList<>();
    }
}
