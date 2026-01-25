package com.revconnect.controller;

import com.revconnect.model.User;
import com.revconnect.service.IUserService;
import com.revconnect.service.UserServiceImpl;

import java.util.Scanner;

public class UserController {

    private final IUserService userService;
    private final Scanner sc;

    public UserController() {
        userService = new UserServiceImpl();
        sc = new Scanner(System.in);
    }

    public void userMenu() {
        while (true) {
            System.out.println("\n--- User Module ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.println("4. Back to Main Menu");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> viewProfile();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void registerUser() {
        User user = new User();

        System.out.print("Enter User ID: ");
        user.setUserId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Username: ");
        user.setUsername(sc.nextLine());

        System.out.print("Enter Email: ");
        user.setEmail(sc.nextLine());

        System.out.print("Enter Password: ");
        user.setPassword(sc.nextLine());

        // ROLE SELECTION
        System.out.println("Select Role:");
        System.out.println("1. PERSONAL_USER");
        System.out.println("2. CONTENT_CREATOR");
        System.out.println("3. BUSINESS_USER");

        int roleChoice = sc.nextInt();
        sc.nextLine();

        switch (roleChoice) {
            case 1 -> user.setRole("PERSONAL_USER");
            case 2 -> user.setRole("CONTENT_CREATOR");
            case 3 -> user.setRole("BUSINESS_USER");
            default -> user.setRole("PERSONAL_USER");
        }

        boolean success = userService.registerUser(user);

        if (success) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed!");
        }
    }

    private void loginUser() {
        System.out.println("Login feature coming next...");
    }

    private void viewProfile() {
        System.out.println("Profile feature coming next...");
    }
}