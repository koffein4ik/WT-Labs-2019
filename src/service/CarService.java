package service;

import bean.Car;

import java.util.List;

public interface CarService {
    void updateCar(Car oldCar, Car newCar);
    void deleteCar(Car car);
    void addCar(Car car);
    void saveAllCars(List<Car> cars);
    List<Car> getAllCars();
}
