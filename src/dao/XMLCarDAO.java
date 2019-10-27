package dao;

import bean.Car;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLCarDAO implements CarDAO {
    @Override
    public void updateCar(Car oldCar, Car newCar) {
        List<Car> cars = getAllCars();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).equals(oldCar)) {
                cars.remove(i);
                cars.add(i, newCar);
                saveAllCars(cars);
                return;
            }
        }
    }

    @Override
    public void deleteCar(Car car) {
        List<Car> cars = getAllCars();
        if (cars.contains(car)) {
            cars.remove(car);
            saveAllCars(cars);
        }
    }

    @Override
    public void addCar(Car car) {
        List<Car> cars = getAllCars();
        if (!cars.contains(car)) {
            cars.add(car);
            saveAllCars(cars);
        }
    }

    @Override
    public void saveAllCars(List<Car> cars) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("./src/XMLStorage/Cars.xml")));
            encoder.writeObject(cars.size());
            for (Car u : cars) {
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
    public List<Car> getAllCars() {
        XMLDecoder decoder = null;
        List<Car> cars = new ArrayList<>();
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./src/XMLStorage/Cars.xml")));
            int carsCount = (Integer)decoder.readObject();
            for(int i = 0; i < carsCount; i++) {
                cars.add((Car)decoder.readObject());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        finally {
            if (decoder != null)
                decoder.close();
        }
        return cars;
    }
}
