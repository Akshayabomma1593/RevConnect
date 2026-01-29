package com.revconnect.controller;
import com.revconnect.service.ConnectionServiceImpl;
import com.revconnect.service.IConnectionService;

public class ConnectionController {

    private final IConnectionService connectionService; // Field is final

    public ConnectionController() {
        this.connectionService = new ConnectionServiceImpl(); // Constructor used below
    }

    public void sendConnectionRequest(int senderId, int receiverId) {
        boolean success = connectionService.sendRequest(senderId, receiverId); // Uses service
        if (success) {
            System.out.println("Connection request sent successfully from User " + senderId + " to User " + receiverId + ".");
        } else {
            System.out.println("Failed to send connection request.");
        }
    }

    public void acceptConnectionRequest(int senderId, int receiverId) {
        boolean success = connectionService.acceptRequest(senderId, receiverId); // Uses service
        if (success) {
            System.out.println("Connection between User " + senderId + " and User " + receiverId + " is now active.");
        } else {
            System.out.println("Failed to accept connection request.");
        }
    }

    public static void main(String[] args) {
        ConnectionController controller = new ConnectionController();

        // Calling both methods clears the "never used" warnings
        controller.sendConnectionRequest(101, 102);
        controller.acceptConnectionRequest(102, 101);
    }
}