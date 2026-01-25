package com.revconnect.controller;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== RevConnect ======");
            System.out.println("1. User Module");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    UserController userController = new UserController();
                    userController.userMenu();
                    break;

                case 2:
                    System.out.println("Exiting RevConnect...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}