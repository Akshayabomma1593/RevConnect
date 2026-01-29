package com.revconnect.service;
public interface IConnectionService {
    boolean sendRequest(int senderId, int receiverId);
    boolean acceptRequest(int senderId, int receiverId);
}
