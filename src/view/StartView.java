package view;

import controller.*;

import java.util.Scanner;

public class StartView {
    public static void main(String args[]) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose what you want to CRUD: \n 1. Users \n 2. Admins \n 3. Drivers \n 4. Cars" +
                    "\n 5. Trucks \n 6. Parkings \n 7. Exit");

            switch (View.getUserChoice()) {
                case 1: {
                    UserController userController = new UserController();
                    userController.showOptions();
                    break;
                }
                case 2: {
                    AdminController adminController = new AdminController();
                    adminController.showOptions();
                    break;
                }
                case 3: {
                    DriverController driverController = new DriverController();
                    driverController.showOptions();
                }
                case 4: {
                    CarController carController = new CarController();
                    carController.showOptions();
                    break;
                }
                case 5: {
                    TruckController truckController = new TruckController();
                    truckController.showOptions();
                }
                case 6: {
                    break;
                }
                case 7: {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect option chosen");
                }
            }

        }
    }
}
