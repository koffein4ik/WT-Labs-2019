package dao;

import bean.Truck;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLTruckDAO implements TruckDAO {
    @Override
    public void updateTruck(Truck oldTruck, Truck newTruck) {
        List<Truck> trucks = getAllTrucks();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).equals(oldTruck)) {
                trucks.remove(i);
                trucks.add(i, newTruck);
                saveAllTrucks(trucks);
                return;
            }
        }
    }

    @Override
    public void deleteTruck(Truck truck) {
        List<Truck> trucks = getAllTrucks();
        if (trucks.contains(truck)) {
            trucks.remove(truck);
            saveAllTrucks(trucks);
        }
    }

    @Override
    public void addTruck(Truck truck) {
        List<Truck> trucks = getAllTrucks();
        if (!trucks.contains(truck)) {
            trucks.add(truck);
            saveAllTrucks(trucks);
        }
    }

    @Override
    public void saveAllTrucks(List<Truck> trucks) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("./src/XMLStorage/Trucks.xml")));
            encoder.writeObject(trucks.size());
            for (Truck u : trucks) {
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
    public List<Truck> getAllTrucks() {
        XMLDecoder decoder = null;
        List<Truck> trucks = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./src/XMLStorage/Trucks.xml")));
            int trucksCount = (Integer)decoder.readObject();
            for(int i = 0; i < trucksCount; i++) {
                trucks.add((Truck)decoder.readObject());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return trucks;
    }
}
