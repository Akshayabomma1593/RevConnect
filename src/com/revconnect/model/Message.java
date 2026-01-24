package com.revconnect.model;

import java.time.LocalDateTime;

public class Message {

    private int messageId;
    private int senderId;
    private int receiverId;
    private String messageText;
    private boolean isRead;
    private LocalDateTime sentAt;

    public Message() {}

    public Message(int messageId, int senderId, int receiverId,
                   String messageText, boolean isRead,
                   LocalDateTime sentAt) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
        this.isRead = isRead;
        this.sentAt = sentAt;
    }

    // getters & setters
    public int getMessageId() { return messageId; }
    public void setMessageId(int messageId) { this.messageId = messageId; }

    public int getSenderId() { return senderId; }
    public void setSenderId(int senderId) { this.senderId = senderId; }

    public int getReceiverId() { return receiverId; }
    public void setReceiverId(int receiverId) { this.receiverId = receiverId; }

    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean isRead() { return isRead; }
    public void setRead(boolean isRead) { this.isRead = isRead; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}