package com.revconnect.dao;

import com.revconnect.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NotificationDaoImpl implements INotificationDao {

    @Override
    public boolean createNotification(int userId, String message) {
        String sql = "INSERT INTO notifications (notification_id, user_id, message, status) " +
                "VALUES (notifications_seq.NEXTVAL, ?, ?, 'UNREAD')";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, message);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
