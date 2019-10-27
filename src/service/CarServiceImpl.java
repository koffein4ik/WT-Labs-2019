package service;

import bean.Car;
import dao.DAOFactory;
import dao.CarDAO;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public void updateCar(Car oldCar, Car newCar) {
        DAOFactory factory = DAOFactory.getFactory();
        CarDAO carDAO = factory.getCarDAO();
        carDAO.updateCar(oldCar, newCar);
    }

    @Override
    public void deleteCar(Car car) {
        DAOFactory factory = DAOFactory.getFactory();
        CarDAO carDAO = factory.getCarDAO();
        carDAO.deleteCar(car);
    }

    @Override
    public void addCar(Car car) {
        DAOFactory factory = DAOFactory.getFactory();
        CarDAO carDAO = factory.getCarDAO();
        carDAO.addCar(car);
    }

    @Override
    public void saveAllCars(List<Car> cars) {
        DAOFactory factory = DAOFactory.getFactory();
        CarDAO carDAO = factory.getCarDAO();
        carDAO.saveAllCars(cars);
    }

    @Override
    public List<Car> getAllCars() {
        DAOFactory factory = DAOFactory.getFactory();
        CarDAO carDAO = factory.getCarDAO();
        return carDAO.getAllCars();
    }
}
