package com.revconnect.service;

import com.revconnect.model.Message;
import java.util.List;

public interface IMessageService {

    boolean sendMessage(Message message);

    List<Message> viewInbox(int receiverId);

    boolean markMessageAsRead(int messageId);
}