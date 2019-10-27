package dao;

public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    private final UserDAO userDAO = new XMLUserDAO();
    private final AdminDAO adminDAO = new XMLAdminDAO();
    private final DriverDAO driverDAO = new XMLDriverDAO();
    private final CarDAO carDAO = new XMLCarDAO();
    private final TruckDAO truckDAO = new XMLTruckDAO();
    private final ParkingDAO parkingDAO = new XMLParkingDAO();

    public static DAOFactory getFactory() {
        return factory;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public DriverDAO getDriverDAO() {
        return driverDAO;
    }

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public TruckDAO getTruckDAO() {
        return truckDAO;
    }

    public ParkingDAO getParkingDAO() {
        return parkingDAO;
    }

    public DAOFactory getInstance() {
        return factory;
    }
}
