package controller;

import bean.Car;
import service.ServiceFactory;
import service.CarService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarController {
    private Display display = new Display().getDisplay();
    private List<Car> cars = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        CarService carService = factory.getCarService();
        cars = carService.getAllCars();

        while (!exit) {
            display.displayResponse("1. Show all Cars \n2. Edit Car \n3. Sort Cars \n4. Add new Car \n" +
                    "5. Delete Car \n6. Search in cars \n7. Save all cars \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showCars();
                    break;
                }
                case 2: {
                    editCar();
                    break;
                }
                case 3: {
                    Collections.sort(cars);
                    break;
                }
                case 4: {
                    addCar();
                    break;
                }
                case 5: {
                    deleteCar();
                    break;
                }
                case 6: {
                    searchCar();
                    break;
                }
                case 7: {
                    saveCars();
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

    private void showCars() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i).toString());
        }
    }

    private void editCar() {
        display.displayResponse("Enter number of car you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= cars.size())) {
            display.displayResponse("Incorrect car chosen");
            return;
        }
        Car currCar = cars.get(number);
        display.displayResponse(currCar.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Max speed \n2. Weight\n3. Drive range\n4. Brand\n" +
                    "5. Model\n6. Color\n7. Payment per minute\n8. Passenger capacity\n9. Acceleration time\n" +
                    "10. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new max speed");
                    currCar.setMaxSpeed(View.getUserChoice());
                    break;
                }
                case 2: {
                    System.out.println("Enter new weight");
                    currCar.setWeight(View.getUserChoice());
                    break;
                }
                case 3: {
                    System.out.println("Enter new drive range");
                    currCar.setDriveRange(View.getUserChoice());
                    break;
                }
                case 4: {
                    System.out.println("Enter new brand");
                    currCar.setBrand(View.getUserString());
                    break;
                }
                case 5: {
                    System.out.println("Enter new model");
                    currCar.setModel(View.getUserString());
                    break;
                }
                case 6: {
                    System.out.println("Enter new color");
                    currCar.setColor(View.getUserString());
                    break;
                }
                case 7: {
                    System.out.println("Enter new value for payment per minute");
                    currCar.setPaymentPerMinute(View.getUserChoice());
                    break;
                }
                case 8: {
                    System.out.println("Enter new value for passenger capacity");
                    currCar.setPassengerCapacity(View.getUserChoice());
                    break;
                }
                case 9: {
                    System.out.println("Enter new value for acceleration time");
                    currCar.setAccelerationTime(View.getUserChoice());
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

    private void addCar() {
        Car currCar = new Car();
        System.out.println("Enter new max speed");
        currCar.setMaxSpeed(View.getUserChoice());
        System.out.println("Enter new weight");
        currCar.setWeight(View.getUserChoice());
        System.out.println("Enter new drive range");
        currCar.setDriveRange(View.getUserChoice());
        System.out.println("Enter new brand");
        currCar.setBrand(View.getUserString());
        System.out.println("Enter new model");
        currCar.setModel(View.getUserString());
        System.out.println("Enter new color");
        currCar.setColor(View.getUserString());
        System.out.println("Enter new value for payment per minute");
        currCar.setPaymentPerMinute(View.getUserChoice());
        System.out.println("Enter new value for passenger capacity");
        currCar.setPassengerCapacity(View.getUserChoice());
        System.out.println("Enter new value for acceleration time");
        currCar.setAccelerationTime(View.getUserChoice());
        cars.add(currCar);
        display.displayResponse("Added successfully");
    }

    private void saveCars() {
        ServiceFactory factory = new ServiceFactory();
        CarService carService = factory.getCarService();
        carService.saveAllCars(cars);
        display.displayResponse("Save successfully");
    }

    private void deleteCar() {
        System.out.println("Enter number of the car you want to delete");
        String number = View.getUserString();
        for (Car c : cars) {
            if (c.getNumber().equals(number))
                cars.remove(c);
        }
    }

    private void searchCar() {
        System.out.println("How do you want to search: \n1. By number\n2. By brand");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter number");
                String number = View.getUserString();
                for (Car c : cars) {
                    if (c.getNumber().equals(number))
                        System.out.println(c.toString());
                }
                break;
            }
            case 2: {
                System.out.println("Enter brand");
                String brand = View.getUserString();
                for (Car c : cars) {
                    if (c.getBrand().equals(brand))
                        System.out.println(c.toString());
                }
                break;
            }
            default:
                System.out.println("Incorrect option chosen");
        }
    }
}
