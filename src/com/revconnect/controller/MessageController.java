package com.revconnect.controller;

import com.revconnect.model.Message;
import com.revconnect.service.IMessageService;
import com.revconnect.service.MessageServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MessageController {

    private final IMessageService messageService = new MessageServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void messageMenu(int loggedInUserId) {

        while (true) {
            System.out.println("\n--- Message Menu ---");
            System.out.println("1. Send Message");
            System.out.println("2. View Inbox");
            System.out.println("3. Mark Message as Read");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    sendMessage(loggedInUserId);
                    break;
                case 2:
                    viewInbox(loggedInUserId);
                    break;
                case 3:
                    markMessageAsRead();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void sendMessage(int senderId) {
        System.out.print("Enter Receiver ID: ");
        int receiverId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Message Text: ");
        String messageText = scanner.nextLine();

        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setMessageText(messageText);

        boolean success = messageService.sendMessage(message);

        if (success) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Failed to send message.");
        }
    }

    private void viewInbox(int receiverId) {
        List<Message> messages = messageService.viewInbox(receiverId);

        if (messages.isEmpty()) {
            System.out.println("Inbox is empty.");
            return;
        }

        System.out.println("\n--- Inbox ---");
        for (Message msg : messages) {
            System.out.println("Message ID : " + msg.getMessageId());
            System.out.println("From       : " + msg.getSenderId());
            System.out.println("Message    : " + msg.getMessageText());
            System.out.println("Read       : " + (msg.isRead() ? "Yes" : "No"));
            System.out.println("-------------------------");
        }
    }

    private void markMessageAsRead() {
        System.out.print("Enter Message ID to mark as read: ");
        int messageId = scanner.nextInt();

        boolean success = messageService.markMessageAsRead(messageId);

        if (success) {
            System.out.println("Message marked as read.");
        } else {
            System.out.println("Failed to update message.");
        }
    }
}
