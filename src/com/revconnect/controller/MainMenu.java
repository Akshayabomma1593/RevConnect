package com.revconnect.controller;

import com.revconnect.model.User;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserController userController = new UserController();
        ProfileController profileController = new ProfileController();
        PostController postController = new PostController();
        InteractionController interactionController = new InteractionController();
        ConnectionController connectionController = new ConnectionController();
        NotificationController notificationController = new NotificationController();
        MessageController messageController = new MessageController();

        while (true) {
            System.out.println("\n=== RevConnect ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // MODULE-1 : AUTH
                case 1:
                    userController.register();
                    break;

                case 2:
                    User user = userController.login();

                    if (user != null) {
                        boolean loggedIn = true;

                        while (loggedIn) {
                            System.out.println("\n=== Welcome " + user.getUsername() + " ===");

                            // PROFILE MODULE
                            System.out.println("1. Create / Update Profile");
                            System.out.println("2. View My Profile");

                            // MODULE-2 : POSTS
                            System.out.println("3. Create Post");
                            System.out.println("4. View All Posts");

                            // MODULE-3 : INTERACTIONS
                            System.out.println("5. Like a Post");
                            System.out.println("6. Comment on a Post");
                            System.out.println("7. View Comments");

                            // MODULE-4 : CONNECTIONS & NOTIFICATIONS
                            System.out.println("8. Send Connection Request");
                            System.out.println("9. View Pending Requests");
                            System.out.println("10. Accept Connection Request");
                            System.out.println("11. View Connections");
                            System.out.println("12. View Notifications");
                            System.out.println("13. Mark Notification as Read");

                            // MODULE-5 : MESSAGING
                            System.out.println("14. Send Message");
                            System.out.println("15. View Chat");

                            System.out.println("16. Logout");
                            System.out.print("Choose: ");

                            int option = sc.nextInt();
                            sc.nextLine();

                            switch (option) {

                                // PROFILE
                                case 1:
                                    profileController.createOrUpdateProfile(user);
                                    break;

                                case 2:
                                    profileController.viewProfile(user);
                                    break;

                                // POSTS
                                case 3:
                                    postController.createPost(user);
                                    break;

                                case 4:
                                    postController.viewAllPosts();
                                    break;

                                // INTERACTIONS
                                case 5:
                                    interactionController.likePost(user);
                                    break;

                                case 6:
                                    interactionController.commentOnPost(user);
                                    break;

                                case 7:
                                    interactionController.viewComments();
                                    break;

                                // CONNECTIONS
                                case 8:
                                    connectionController.sendRequest(user);
                                    break;

                                case 9:
                                    connectionController.viewPending(user);
                                    break;

                                case 10:
                                    connectionController.acceptRequest();
                                    break;

                                case 11:
                                    connectionController.viewConnections(user);
                                    break;

                                // NOTIFICATIONS
                                case 12:
                                    notificationController.viewNotifications(user);
                                    break;

                                case 13:
                                    notificationController.markAsRead();
                                    break;

                                // MESSAGING
                                case 14:
                                    messageController.sendMessage(user);
                                    break;

                                case 15:
                                    messageController.viewChat(user);
                                    break;

                                case 16:
                                    loggedIn = false;
                                    System.out.println("👋 Logged out successfully");
                                    break;

                                default:
                                    System.out.println("❌ Invalid option");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting RevConnect...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
