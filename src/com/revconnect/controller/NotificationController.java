package com.revconnect.controller;

import com.revconnect.service.INotificationService;
import com.revconnect.service.NotificationServiceImpl;

public class NotificationController {
    private final INotificationService notificationService; // Field is final

        public NotificationController() {
            this.notificationService = new NotificationServiceImpl(); // Constructor used below
        }

        public void sendNotification(int userId, String message) {
            boolean success = notificationService.notifyUser(userId, message); // Uses service
            if (success) {
                System.out.println("Notification successfully delivered to User " + userId + ".");
            } else {
                System.out.println("Error: Could not deliver notification to User " + userId + ".");
            }
        }

        public static void main(String[] args) {
            NotificationController controller = new NotificationController();

            // Calling the method clears the "never used" warning
            controller.sendNotification(101, "Test Notification Message");
        }
    }
