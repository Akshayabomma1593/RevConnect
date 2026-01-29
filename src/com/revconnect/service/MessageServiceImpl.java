package com.revconnect.service;

import com.revconnect.dao.IMessageDao;
import com.revconnect.dao.MessageDaoImpl;
import com.revconnect.model.Message;

import java.util.List;

public class MessageServiceImpl implements IMessageService {

    private final IMessageDao messageDao = new MessageDaoImpl();

    @Override
    public boolean sendMessage(Message message) {
        return messageDao.sendMessage(message);
    }

    @Override
    public List<Message> viewInbox(int receiverId) {
        return messageDao.getMessagesByReceiver(receiverId);
    }

    @Override
    public boolean markMessageAsRead(int messageId) {
        return messageDao.markAsRead(messageId);
    }
}