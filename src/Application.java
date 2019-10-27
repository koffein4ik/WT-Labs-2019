import bean.Car;
import bean.Parking;
import bean.User;
import dao.XMLParkingDAO;
import dao.XMLUserDAO;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        XMLParkingDAO pdao = new XMLParkingDAO();
        Car car = new Car();
        car.setBrand("Audi");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Parking p = new Parking();
        p.setLocation("New York");
        p.setVehiclesOnParking(new ArrayList<>(cars));
        List<Parking> plist = new ArrayList<>();
        plist.add(p);
        pdao.saveAllParkings(plist);
        plist = pdao.getAllParkings();
        System.out.println(plist.get(0).getVehiclesOnParking().get(0).getBrand());
    }
}
