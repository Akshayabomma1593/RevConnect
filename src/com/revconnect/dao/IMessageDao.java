package com.revconnect.dao;

import com.revconnect.model.Message;
import java.util.List;

public interface IMessageDao {

    boolean sendMessage(Message message);

    List<Message> getMessagesByReceiver(int receiverId);

    boolean markAsRead(int messageId);
}