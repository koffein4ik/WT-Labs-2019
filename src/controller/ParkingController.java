package controller;

import bean.Car;
import bean.Parking;
import bean.Truck;
import bean.Vehicle;
import service.ServiceFactory;
import service.ParkingService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingController {
    private Display display = new Display().getDisplay();
    private List<Parking> parkings = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        ParkingService parkingService = factory.getParkingService();
        parkings = parkingService.getAllParkings();

        while (!exit) {
            display.displayResponse("1. Show all Parkings \n2. Edit Parking \n3. Sort Parkings \n4. Add new Parking \n" +
                    "5. Delete Parking \n6. Search in parkings \n7. Save all parkings \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showParkings();
                    break;
                }
                case 2: {
                    editParking();
                    break;
                }
                case 3: {
                    Collections.sort(parkings);
                    break;
                }
                case 4: {
                    addParking();
                    break;
                }
                case 5: {
                    deleteParking();
                    break;
                }
                case 6: {
                    searchParking();
                    break;
                }
                case 7: {
                    saveParkings();
                    break;
                }
                case 8: {
                    exit = true;
                    break;
                }
                default: {
                    display.displayResponse("Incorrect option chosen");
                }
            }
        }
    }

    private void showParkings() {
        for (int i = 0; i < parkings.size(); i++) {
            System.out.println((i + 1) + ". " + parkings.get(i).toString());
        }
    }

    private void editParking() {
        display.displayResponse("Enter number of parking you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= parkings.size())) {
            display.displayResponse("Incorrect parking chosen");
            return;
        }
        Parking currParking = parkings.get(number);
        display.displayResponse(currParking.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Location \n2. Car capacity\n3. Truck capacity\n" +
                    "4. Show all vehicles from this parking\n5. Add vehicle to this parking" +
                    "\n6. Remove vehicle from this parking \n7. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new location");
                    currParking.setLocation(View.getUserString());
                    break;
                }
                case 2: {
                    System.out.println("Enter new car capacity");
                    currParking.setCarCapacity(View.getUserChoice());
                    break;
                }
                case 3: {
                    System.out.println("Enter new truck capacity");
                    currParking.setTruckCapacity(View.getUserChoice());
                    break;
                }
                case 4: {
                    showVehicleOnParking(currParking);
                    break;
                }
                case 5: {
                    addNewVehicleToParking(currParking);
                    break;
                }
                case 6: {
                    removeVehicleFromThisParking(currParking);
                    break;
                }
                case 7: {
                    exit = true;
                    break;
                }
                default: {
                    display.displayResponse("Incorrect option chosen");
                }
            }
        }
        System.out.println("Edited successfully");
    }

    private void showVehicleOnParking(Parking p) {
        List<Vehicle> vehiclesOnParking = p.getVehiclesOnParking();
        for (int i = 0; i < vehiclesOnParking.size(); i++) {
            if (vehiclesOnParking.get(i) instanceof Car) {
                System.out.println(i + 1 + ". " + ((Car)vehiclesOnParking.get(i)).toString());
            }
            else {
                System.out.println(i + 1 + ". " + ((Truck)vehiclesOnParking.get(i)).toString());
            }
        }
    }

    private void addNewVehicleToParking(Parking currParking) {
        ServiceFactory factory = new ServiceFactory();
        List<Vehicle> availableVehicles = new ArrayList<>(factory.getCarService().getAllCars());
        availableVehicles.addAll(factory.getTruckService().getAllTrucks());

        for (Parking p : parkings) {
            for (Vehicle v : p.getVehiclesOnParking()) {
                availableVehicles.remove(v);
            }
        }
        System.out.println("Available vehicles: ");
        for (int i = 0; i < availableVehicles.size(); i++) {
            if (availableVehicles.get(i) instanceof Car) {
                System.out.println(i + 1 + ". " + ((Car) availableVehicles.get(i)).toString());
            }
            else {
                System.out.println(i + 1 + ". " + ((Truck) availableVehicles.get(i)).toString());
            }

        }
        System.out.println("Choose vehicle you want to add: ");
        int vehicleNumber = View.getUserChoice();
        vehicleNumber--;
        if ((vehicleNumber >= availableVehicles.size()) || (vehicleNumber < 0)) {
            System.out.println("Incorrect vehicle number entered.");
            return;
        }
        int truckSpacesAvailable = currParking.getTruckCapacity();
        int carSpacesAvailable = currParking.getCarCapacity();
        for (Vehicle v : currParking.getVehiclesOnParking()) {
            if (v instanceof Car) {
                carSpacesAvailable--;
            }
            else {
                truckSpacesAvailable--;
            }
        }
        if (availableVehicles.get(vehicleNumber) instanceof Car) {
            if (carSpacesAvailable > 0) {
                currParking.getVehiclesOnParking().add(availableVehicles.get(vehicleNumber));
                System.out.println("Added successfully");
            }
            else
                System.out.println("Not enough space on parking");
        }
        else {
            if (truckSpacesAvailable > 0) {
                currParking.getVehiclesOnParking().add(availableVehicles.get(vehicleNumber));
                System.out.println("Added successfully");
            }
            else
                System.out.println("Not enough space on parking");
        }
    }

    private void removeVehicleFromThisParking(Parking p) {
        System.out.println("Vehicles on parking: ");
        List<Vehicle> vehicles = p.getVehiclesOnParking();
        for (int i = 0; i < vehicles.size(); i++) {
            if (p.getVehiclesOnParking().get(i) instanceof Car) {
                System.out.println(i + 1 + ". " + ((Car) vehicles.get(i)).toString());
            } else {
                System.out.println(i + 1 + ". " + ((Truck) vehicles.get(i)).toString());
            }
        }
        System.out.println("Enter number of vehicle you want to remove");
        int carNumber = View.getUserChoice();
        carNumber--;
        if ((carNumber >= vehicles.size()) || (carNumber < 0)) {
            System.out.println("Incorrect vehicle chosen.");
            return;
        }
        else {
            vehicles.remove(carNumber);
            System.out.println("Removed successfully");
        }
    }

    private void addParking() {
        Parking currParking = new Parking();
        System.out.println("Enter location");
        currParking.setLocation(View.getUserString());
        System.out.println("Enter car capacity");
        currParking.setCarCapacity(View.getUserChoice());
        System.out.println("Enter truck capacity");
        currParking.setTruckCapacity(View.getUserChoice());
        parkings.add(currParking);
        display.displayResponse("Added successfully");
    }

    private void saveParkings() {
        ServiceFactory factory = new ServiceFactory();
        ParkingService parkingService = factory.getParkingService();
        parkingService.saveAllParkings(parkings);
        display.displayResponse("Saved successfully");
    }

    private void deleteParking() {
        System.out.println("Enter location of the parking you want to delete");
        String location = View.getUserString();
        for (Parking p : parkings) {
            if (p.getLocation().equals(location))
                parkings.remove(p);
        }
    }

    private void searchParking() {
        System.out.println("How do you want to search: \n1. By location\n2. By car capacity");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter location");
                String location = View.getUserString();
                for (Parking p : parkings) {
                    if (p.getLocation().equals(location))
                        System.out.println(p.toString());
                }
                break;
            }
            case 2: {
                System.out.println("Enter car capacity");
                int carCapacity = View.getUserChoice();
                for (Parking p : parkings) {
                    if (p.getCarCapacity() == carCapacity)
                        System.out.println(p.toString());
                }
                break;
            }
            default:
                System.out.println("Incorrect option chosen");
        }
    }
}
