package com.revconnect.dao;

public interface IConnectionDao {
    boolean sendRequest(int senderId, int receiverId);
    boolean acceptRequest(int senderId, int receiverId);
}