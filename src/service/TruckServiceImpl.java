package service;

import bean.Truck;
import dao.DAOFactory;
import dao.TruckDAO;

import java.util.List;

public class TruckServiceImpl implements TruckService {
    @Override
    public void updateTruck(Truck oldTruck, Truck newTruck) {
        DAOFactory factory = DAOFactory.getFactory();
        TruckDAO truckDAO = factory.getTruckDAO();
        truckDAO.updateTruck(oldTruck, newTruck);
    }

    @Override
    public void deleteTruck(Truck truck) {
        DAOFactory factory = DAOFactory.getFactory();
        TruckDAO truckDAO = factory.getTruckDAO();
        truckDAO.deleteTruck(truck);
    }

    @Override
    public void addTruck(Truck truck) {
        DAOFactory factory = DAOFactory.getFactory();
        TruckDAO truckDAO = factory.getTruckDAO();
        truckDAO.addTruck(truck);
    }

    @Override
    public void saveAllTrucks(List<Truck> trucks) {
        DAOFactory factory = DAOFactory.getFactory();
        TruckDAO truckDAO = factory.getTruckDAO();
        truckDAO.saveAllTrucks(trucks);
    }

    @Override
    public List<Truck> getAllTrucks() {
        DAOFactory factory = DAOFactory.getFactory();
        TruckDAO truckDAO = factory.getTruckDAO();
        return truckDAO.getAllTrucks();
    }
}
