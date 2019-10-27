package dao;

import bean.Car;

import java.util.List;

public interface CarDAO {
    void updateCar(Car oldCar, Car newCar);
    void deleteCar(Car car);
    void addCar(Car car);
    void saveAllCars(List<Car> cars);
    List<Car> getAllCars();
}
