package controller;

import bean.User;
import service.ServiceFactory;
import service.UserService;
import view.Display;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserController {
    private Display display = new Display().getDisplay();
    private List<User> users = new ArrayList<>();

    public void showOptions() {
        boolean exit = false;

        ServiceFactory factory = new ServiceFactory();
        UserService userService = factory.getUserService();
        users = userService.getAllUsers();

        while (!exit) {
            display.displayResponse("1. Show all Users \n2. Edit User \n3. Sort Users \n4. Add new User \n" +
                    "5. Delete User \n6. Search in users \n7. Save all users \n8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    showUsers();
                    break;
                }
                case 2: {
                    editUser();
                    break;
                }
                case 3: {
                    Collections.sort(users);
                    break;
                }
                case 4: {
                    addUser();
                    break;
                }
                case 5: {
                    deleteUser();
                    break;
                }
                case 6: {
                    searchUser();
                    break;
                }
                case 7: {
                    saveUsers();
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

    private void showUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).toString());
        }
    }

    private void editUser() {
        display.displayResponse("Enter number of user you want to edit");
        int number = View.getUserChoice();
        number--;
        if ((number < 0) || (number >= users.size())) {
            display.displayResponse("Incorrect user chosen");
            return;
        }
        User currUser = users.get(number);
        display.displayResponse(currUser.toString());
        boolean exit = false;
        while (!exit) {
            display.displayResponse("What you want to edit: \n1. Name \n2. Surname\n3. Phone Number\n4. Passport Number\n" +
                    "5. Nickname\n6. Money on Balance\n 7. Trips completed\n 8. Exit");
            switch (View.getUserChoice()) {
                case 1: {
                    System.out.println("Enter new name");
                    currUser.setName(View.getUserString());
                    break;
                }
                case 2: {
                    System.out.println("Enter new surname");
                    currUser.setSurname(View.getUserString());
                    break;
                }
                case 3: {
                    System.out.println("Enter new phone number");
                    currUser.setPhoneNumber(View.getUserString());
                    break;
                }
                case 4: {
                    System.out.println("Enter new phone Passportnumber");
                    currUser.setPassportNumber(View.getUserString());
                    break;
                }
                case 5: {
                    System.out.println("Enter new Nickname");
                    currUser.setNickname(View.getUserString());
                    break;
                }
                case 6: {
                    System.out.println("Enter new value for money on balance");
                    currUser.setMoneyOnBalance(View.getUserChoice());
                    break;
                }
                case 7: {
                    System.out.println("Enter new value for trips completed");
                    currUser.setTripsCompleted(View.getUserChoice());
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
        System.out.println("Edited successfully");
    }

    private void addUser() {
        User currUser = new User();
        System.out.println("Enter name");
        currUser.setName(View.getUserString());
        System.out.println("Enter Surname");
        currUser.setSurname(View.getUserString());
        System.out.println("Enter phone number");
        currUser.setPhoneNumber(View.getUserString());
        System.out.println("Enter phone Passportnumber");
        currUser.setPassportNumber(View.getUserString());
        System.out.println("Enter Nickname");
        currUser.setNickname(View.getUserString());
        System.out.println("Enter value for money on balance");
        currUser.setMoneyOnBalance(View.getUserChoice());
        System.out.println("Enter value for trips completed");
        currUser.setTripsCompleted(View.getUserChoice());
        users.add(currUser);
        display.displayResponse("Added successfully");
    }

    private void saveUsers() {
        ServiceFactory factory = new ServiceFactory();
        UserService userService = factory.getUserService();
        userService.saveAllUsers(users);
        display.displayResponse("Save successfully");
    }

    private void deleteUser() {
        System.out.println("Enter nickname of the user you want to delete");
        String nickname = View.getUserString();
        for (User u : users) {
            if (u.getNickname().equals(nickname))
                users.remove(u);
        }
    }

    private void searchUser() {
        System.out.println("How do you want to search: \n1. By surname\n2. By nickname");
        switch (View.getUserChoice()) {
            case 1: {
                System.out.println("Enter surname");
                String surname = View.getUserString();
                for (User u : users) {
                    if (u.getSurname().equals(surname))
                        System.out.println(u.toString());
                }
                break;
            }
            case 2: {
                    System.out.println("Enter nickname");
                    String nickname = View.getUserString();
                    for (User u : users) {
                        if (u.getNickname().equals(nickname))
                            System.out.println(u.toString());
                    }
                    break;
                }
            default:
                System.out.println("Incorrect option chosen");
            }
        }
    }
