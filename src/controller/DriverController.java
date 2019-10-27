package controller;

import bean.Driver;
import service.ServiceFactory;
import service.DriverService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverController {
    private Display display = new Display().getDisplay();
    private List<Driver> drivers = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        DriverService driverService = factory.getDriverService();
        drivers = driverService.getAllDrivers();

        while (!exit) {
            display.displayResponse("1. Show all Drivers \n2. Edit Driver \n3. Sort Drivers \n4. Add new Driver \n" +
                    "5. Delete Driver \n6. Search in drivers \n7. Save all drivers \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showDrivers();
                    break;
                }
                case 2: {
                    editDriver();
                    break;
                }
                case 3: {
                    Collections.sort(drivers);
                    break;
                }
                case 4: {
                    addDriver();
                    break;
                }
                case 5: {
                    deleteDriver();
                    break;
                }
                case 6: {
                    searchDriver();
                    break;
                }
                case 7: {
                    saveDrivers();
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

    private void showDrivers() {
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).toString());
        }
    }

    private void editDriver() {
        display.displayResponse("Enter number of driver you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= drivers.size())) {
            display.displayResponse("Incorrect driver chosen");
            return;
        }
        Driver currDriver = drivers.get(number);
        display.displayResponse(currDriver.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Name \n2. Surname\n3. Phone Number\n4. Passport Number\n" +
                    "5. Salary\n6. Hours worked this month\n7. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new name");
                    currDriver.setName(View.getUserString());
                    break;
                }
                case 2: {
                    System.out.println("Enter new surname");
                    currDriver.setSurname(View.getUserString());
                    break;
                }
                case 3: {
                    System.out.println("Enter new phone number");
                    currDriver.setPhoneNumber(View.getUserString());
                    break;
                }
                case 4: {
                    System.out.println("Enter new phone Passport number");
                    currDriver.setPassportNumber(View.getUserString());
                    break;
                }
                case 5: {
                    System.out.println("Enter new salary");
                    currDriver.setSalary(View.getUserChoice());
                    break;
                }
                case 6: {
                    System.out.println("Enter new value for hours worked this month");
                    currDriver.setHoursWorkedThisMonth(View.getUserChoice());
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

    private void addDriver() {
        Driver currDriver = new Driver();
        System.out.println("Enter name");
        currDriver.setName(View.getUserString());
        System.out.println("Enter Surname");
        currDriver.setSurname(View.getUserString());
        System.out.println("Enter phone number");
        currDriver.setPhoneNumber(View.getUserString());
        System.out.println("Enter phone Passportnumber");
        currDriver.setPassportNumber(View.getUserString());
        System.out.println("Enter new salary");
        currDriver.setSalary(View.getUserChoice());
        System.out.println("Enter new value for hours worked this month");
        currDriver.setHoursWorkedThisMonth(View.getUserChoice());
        drivers.add(currDriver);
        display.displayResponse("Added successfully");
    }

    private void saveDrivers() {
        ServiceFactory factory = new ServiceFactory();
        DriverService driverService = factory.getDriverService();
        driverService.saveAllDrivers(drivers);
        display.displayResponse("Save successfully");
    }

    private void deleteDriver() {
        System.out.println("Enter surname of the driver you want to delete");
        String surname = View.getUserString();
        System.out.println("Enter name of the driver you want to delete");
        String name = View.getUserString();
        for (Driver d : drivers) {
            if ((d.getSurname().equals(surname)) && (d.getName().equals(name)))
                drivers.remove(d);
        }
    }

    private void searchDriver() {
        System.out.println("How do you want to search: \n1. By surname\n2. By name");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter surname");
                String surname = View.getUserString();
                for (Driver d : drivers) {
                    if (d.getSurname().equals(surname))
                        System.out.println(d.toString());
                }
                break;
            }
            case 2: {
                System.out.println("Enter name");
                String name = View.getUserString();
                for (Driver d : drivers) {
                    if (d.getName().equals(name))
                        System.out.println(d.toString());
                }
                break;
            }
            default:
                System.out.println("Incorrect option chosen");
        }
    }
}
