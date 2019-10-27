package service;

public class ServiceFactory {
    private static final ServiceFactory factory = new ServiceFactory();

    private final UserServiceImpl userService = new UserServiceImpl();
    private final AdminServiceImpl adminService = new AdminServiceImpl();
    private final DriverServiceImpl driverService = new DriverServiceImpl();
    private final CarServiceImpl carService = new CarServiceImpl();
    private final TruckServiceImpl truckService = new TruckServiceImpl();
    private final ParkingServiceImpl parkingService = new ParkingServiceImpl();

    public static ServiceFactory getFactory() {
        return factory;
    }

    public UserService getUserService() {
        return userService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public DriverService getDriverService() {
        return driverService;
    }

    public CarService getCarService() {
        return carService;
    }

    public TruckService getTruckService() {
        return truckService;
    }

    public ParkingService getParkingService() {
        return parkingService;
    }

    public ServiceFactory getInstance() {
        return factory;
    }
}
