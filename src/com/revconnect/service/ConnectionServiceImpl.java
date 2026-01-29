package com.revconnect.service;

import com.revconnect.dao.ConnectionDaoImpl;
import com.revconnect.dao.IConnectionDao;

public class ConnectionServiceImpl implements IConnectionService {

    private IConnectionDao connectionDao = new ConnectionDaoImpl();

    @Override
    public boolean sendRequest(int senderId, int receiverId) {
        return connectionDao.sendRequest(senderId, receiverId);
    }

    @Override
    public boolean acceptRequest(int senderId, int receiverId) {
        return connectionDao.acceptRequest(senderId, receiverId);
    }
}
