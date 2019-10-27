package controller;

import bean.Truck;
import service.ServiceFactory;
import service.TruckService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TruckController {
    private Display display = new Display().getDisplay();
    private List<Truck> trucks = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        TruckService truckService = factory.getTruckService();
        trucks = truckService.getAllTrucks();

        while (!exit) {
            display.displayResponse("1. Show all Trucks \n2. Edit Truck \n3. Sort Trucks \n4. Add new Truck \n" +
                    "5. Delete Truck \n6. Search in trucks \n7. Save all trucks \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showTrucks();
                    break;
                }
                case 2: {
                    editTruck();
                    break;
                }
                case 3: {
                    Collections.sort(trucks);
                    break;
                }
                case 4: {
                    addTruck();
                    break;
                }
                case 5: {
                    deleteTruck();
                    break;
                }
                case 6: {
                    searchTruck();
                    break;
                }
                case 7: {
                    saveTrucks();
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

    private void showTrucks() {
        for (int i = 0; i < trucks.size(); i++) {
            System.out.println((i + 1) + ". " + trucks.get(i).toString());
        }
    }

    private void editTruck() {
        display.displayResponse("Enter number of truck you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= trucks.size())) {
            display.displayResponse("Incorrect truck chosen");
            return;
        }
        Truck currTruck = trucks.get(number);
        display.displayResponse(currTruck.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Max speed \n2. Weight\n3. Drive range\n4. Brand\n" +
                    "5. Model\n6. Color\n7. Payment per minute\n8. Cargo capacity\n9. Cargo volume\n" +
                    "10. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new max speed");
                    currTruck.setMaxSpeed(View.getUserChoice());
                    break;
                }
                case 2: {
                    System.out.println("Enter new weight");
                    currTruck.setWeight(View.getUserChoice());
                    break;
                }
                case 3: {
                    System.out.println("Enter new drive range");
                    currTruck.setDriveRange(View.getUserChoice());
                    break;
                }
                case 4: {
                    System.out.println("Enter new brand");
                    currTruck.setBrand(View.getUserString());
                    break;
                }
                case 5: {
                    System.out.println("Enter new model");
                    currTruck.setModel(View.getUserString());
                    break;
                }
                case 6: {
                    System.out.println("Enter new color");
                    currTruck.setColor(View.getUserString());
                    break;
                }
                case 7: {
                    System.out.println("Enter new value for payment per minute");
                    currTruck.setPaymentPerMinute(View.getUserChoice());
                    break;
                }
                case 8: {
                    System.out.println("Enter new value for cargo capacity");
                    currTruck.setCargoCapacity(View.getUserChoice());
                    break;
                }
                case 9: {
                    System.out.println("Enter new value for cargo volume");
                    currTruck.setCargoVolume(View.getUserChoice());
                    break;
                }
                case 10: {
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

    private void addTruck() {
        Truck currTruck = new Truck();
        System.out.println("Enter new max speed");
        currTruck.setMaxSpeed(View.getUserChoice());
        System.out.println("Enter new weight");
        currTruck.setWeight(View.getUserChoice());
        System.out.println("Enter new drive range");
        currTruck.setDriveRange(View.getUserChoice());
        System.out.println("Enter new brand");
        currTruck.setBrand(View.getUserString());
        System.out.println("Enter new model");
        currTruck.setModel(View.getUserString());
        System.out.println("Enter new color");
        currTruck.setColor(View.getUserString());
        System.out.println("Enter new value for payment per minute");
        currTruck.setPaymentPerMinute(View.getUserChoice());
        System.out.println("Enter new value for cargo volume");
        currTruck.setCargoVolume(View.getUserChoice());
        System.out.println("Enter new value for cargo capacity");
        currTruck.setCargoCapacity(View.getUserChoice());
        trucks.add(currTruck);
        display.displayResponse("Added successfully");
    }

    private void saveTrucks() {
        ServiceFactory factory = new ServiceFactory();
        TruckService truckService = factory.getTruckService();
        truckService.saveAllTrucks(trucks);
        display.displayResponse("Save successfully");
    }

    private void deleteTruck() {
        System.out.println("Enter number of the truck you want to delete");
        String number = View.getUserString();
        for (Truck t : trucks) {
            if (t.getNumber().equals(number))
                trucks.remove(t);
        }
    }

    private void searchTruck() {
        System.out.println("How do you want to search: \n1. By number\n2. By brand");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter number");
                String number = View.getUserString();
                for (Truck t : trucks) {
                    if (t.getNumber().equals(number))
                        System.out.println(t.toString());
                }
                break;
            }
            case 2: {
                System.out.println("Enter brand");
                String brand = View.getUserString();
                for (Truck t : trucks) {
                    if (t.getBrand().equals(brand))
                        System.out.println(t.toString());
                }
                break;
            }
            default:
                System.out.println("Incorrect option chosen");
        }
    }
}
