package com.revconnect.dao;

import com.revconnect.model.Message;
import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements IMessageDao {

    @Override
    public boolean sendMessage(Message message) {

        String sql =
                "INSERT INTO messages (message_id, sender_id, receiver_id, content, is_read, sent_at) " +
                        "VALUES (?, ?, ?, ?, 0, SYSDATE)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, message.getMessageId());
            ps.setInt(2, message.getSenderId());
            ps.setInt(3, message.getReceiverId());
            ps.setString(4, message.getContent());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Message> getMessagesByReceiver(int receiverId) {

        List<Message> messages = new ArrayList<>();

        String sql = "SELECT * FROM messages WHERE receiver_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, receiverId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Message msg = new Message();
                msg.setMessageId(rs.getInt("message_id"));
                msg.setSenderId(rs.getInt("sender_id"));
                msg.setReceiverId(rs.getInt("receiver_id"));
                msg.setContent(rs.getString("content"));
                msg.setRead(rs.getInt("is_read") == 1);
                messages.add(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public boolean markAsRead(int messageId) {

        String sql = "UPDATE messages SET is_read = 1 WHERE message_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, messageId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}