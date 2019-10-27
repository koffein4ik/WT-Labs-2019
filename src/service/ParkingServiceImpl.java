package service;

import bean.Parking;
import bean.Vehicle;
import dao.DAOFactory;
import dao.ParkingDAO;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    @Override
    public void updateParking(Parking oldParking, Parking newParking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        parkingDAO.updateParking(oldParking, newParking);
    }

    @Override
    public void deleteParking(Parking parking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        parkingDAO.deleteParking(parking);
    }

    @Override
    public void addParking(Parking parking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        parkingDAO.addParking(parking);
    }

    @Override
    public void saveAllParkings(List<Parking> parkings) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        parkingDAO.saveAllParkings(parkings);
    }

    @Override
    public boolean addVehicleToParking(Vehicle vehicle, Parking parking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        return parkingDAO.addVehicleToParking(vehicle, parking);
    }

    @Override
    public boolean removeVehicleFromParking(Vehicle vehicle, Parking parking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        return parkingDAO.removeVehicleFromParking(vehicle, parking);
    }

    @Override
    public List<Vehicle> getVehiclesOnParking(Parking parking) {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        return parkingDAO.getVehiclesOnParking(parking);
    }

    @Override
    public List<Parking> getAllParkings() {
        DAOFactory factory = DAOFactory.getFactory();
        ParkingDAO parkingDAO = factory.getParkingDAO();
        return parkingDAO.getAllParkings();
    }
}
