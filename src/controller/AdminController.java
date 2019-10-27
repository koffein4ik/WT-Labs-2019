package controller;

import bean.Admin;
import service.ServiceFactory;
import service.AdminService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminController {
    private Display display = new Display().getDisplay();
    private List<Admin> admins = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        AdminService adminService = factory.getAdminService();
        admins = adminService.getAllAdmins();

        while (!exit) {
            display.displayResponse("1. Show all Admins \n2. Edit Admin \n3. Sort Admins \n4. Add new Admin \n" +
                    "5. Delete Admin \n6. Search in admins \n7. Save all admins \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showAdmins();
                    break;
                }
                case 2: {
                    editAdmin();
                    break;
                }
                case 3: {
                    Collections.sort(admins);
                    break;
                }
                case 4: {
                    addAdmin();
                    break;
                }
                case 5: {
                    deleteAdmin();
                    break;
                }
                case 6: {
                    searchAdmin();
                    break;
                }
                case 7: {
                    saveAdmins();
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

    private void showAdmins() {
        for (int i = 0; i < admins.size(); i++) {
            System.out.println((i + 1) + ". " + admins.get(i).toString());
        }
    }

    private void editAdmin() {
        display.displayResponse("Enter number of admin you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= admins.size())) {
            display.displayResponse("Incorrect admin chosen");
            return;
        }
        Admin currAdmin = admins.get(number);
        display.displayResponse(currAdmin.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Name \n2. Surname\n3. Phone Number\n4. Passport Number\n" +
                    "5. Nickname\n6. User requests answered\n 7. Salary\n8. Access level\n9. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new name");
                    currAdmin.setName(View.getUserString());
                    break;
                }
                case 2: {
                    System.out.println("Enter new surname");
                    currAdmin.setSurname(View.getUserString());
                    break;
                }
                case 3: {
                    System.out.println("Enter new phone number");
                    currAdmin.setPhoneNumber(View.getUserString());
                    break;
                }
                case 4: {
                    System.out.println("Enter new phone Passport number");
                    currAdmin.setPassportNumber(View.getUserString());
                    break;
                }
                case 5: {
                    System.out.println("Enter new Nickname");
                    currAdmin.setNickname(View.getUserString());
                    break;
                }
                case 6: {
                    System.out.println("Enter new value for user requests answered");
                    currAdmin.setUserRequestsAnswered(View.getUserChoice());
                    break;
                }
                case 7: {
                    System.out.println("Enter new value for salary");
                    currAdmin.setSalary(View.getUserChoice());
                    break;
                }
                case 8: {
                    System.out.println("Enter new value for access level");
                    currAdmin.setAccessLevel(View.getUserChoice());
                    break;
                }
                case 9: {
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

    private void addAdmin() {
        Admin currAdmin = new Admin();
        System.out.println("Enter name");
        currAdmin.setName(View.getUserString());
        System.out.println("Enter Surname");
        currAdmin.setSurname(View.getUserString());
        System.out.println("Enter phone number");
        currAdmin.setPhoneNumber(View.getUserString());
        System.out.println("Enter phone Passportnumber");
        currAdmin.setPassportNumber(View.getUserString());
        System.out.println("Enter Nickname");
        currAdmin.setNickname(View.getUserString());
        System.out.println("Enter new value for user requests answered");
        currAdmin.setUserRequestsAnswered(View.getUserChoice());
        System.out.println("Enter new value for salary");
        currAdmin.setSalary(View.getUserChoice());
        System.out.println("Enter new value for access level");
        currAdmin.setAccessLevel(View.getUserChoice());
        admins.add(currAdmin);
        display.displayResponse("Added successfully");
    }

    private void saveAdmins() {
        ServiceFactory factory = new ServiceFactory();
        AdminService adminService = factory.getAdminService();
        adminService.saveAllAdmins(admins);
        display.displayResponse("Save successfully");
    }

    private void deleteAdmin() {
        System.out.println("Enter nickname of the admin you want to delete");
        String nickname = View.getUserString();
        for (Admin a : admins) {
            if (a.getNickname().equals(nickname))
                admins.remove(a);
        }
    }

    private void searchAdmin() {
        System.out.println("How do you want to search: \n1. By surname\n2. By nickname");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter surname");
                String surname = View.getUserString();
                for (Admin a : admins) {
                    if (a.getSurname().equals(surname))
                        System.out.println(a.toString());
                }
                break;
            }
            case 2: {
                System.out.println("Enter nickname");
                String nickname = View.getUserString();
                for (Admin a : admins) {
                    if (a.getNickname().equals(nickname))
                        System.out.println(a.toString());
                }
                break;
            }
            default:
                System.out.println("Incorrect option chosen");
        }
    }
}
