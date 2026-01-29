package com.revconnect.service;

import com.revconnect.dao.INotificationDao;
import com.revconnect.dao.NotificationDaoImpl;

public class NotificationServiceImpl implements INotificationService {

    private INotificationDao notificationDao = new NotificationDaoImpl();

    @Override
    public boolean notifyUser(int userId, String message) {
        return notificationDao.createNotification(userId, message);
    }
}