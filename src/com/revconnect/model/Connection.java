
package com.revconnect.model;

import java.time.LocalDateTime;

public class Connection {

    private int connectionId;
    private int requesterId;
    private int targetUserId;
    private String connectionType;
    private String status;
    private LocalDateTime createdAt;

    public Connection() {}

    public Connection(int connectionId, int requesterId, int targetUserId,
                      String connectionType, String status,
                      LocalDateTime createdAt) {
        this.connectionId = connectionId;
        this.requesterId = requesterId;
        this.targetUserId = targetUserId;
        this.connectionType = connectionType;
        this.status = status;
        this.createdAt = createdAt;
    }

    // getters & setters
    public int getConnectionId() { return connectionId; }
    public void setConnectionId(int connectionId) { this.connectionId = connectionId; }

    public int getRequesterId() { return requesterId; }
    public void setRequesterId(int requesterId) { this.requesterId = requesterId; }

    public int getTargetUserId() { return targetUserId; }
    public void setTargetUserId(int targetUserId) { this.targetUserId = targetUserId; }

    public String getConnectionType() { return connectionType; }
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}