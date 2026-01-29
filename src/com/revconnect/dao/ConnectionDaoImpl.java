package com.revconnect.dao;



import com.revconnect.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

    public class ConnectionDaoImpl implements IConnectionDao {

        @Override
        public boolean sendRequest(int senderId, int receiverId) {
            String sql = "INSERT INTO connections (connection_id, sender_id, receiver_id, status) " +
                    "VALUES (connections_seq.NEXTVAL, ?, ?, 'PENDING')";

            try (Connection con = JDBCUtil.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, senderId);
                ps.setInt(2, receiverId);
                return ps.executeUpdate() > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean acceptRequest(int senderId, int receiverId) {
            String sql = "UPDATE connections SET status='ACCEPTED' " +
                    "WHERE sender_id=? AND receiver_id=?";

            try (Connection con = JDBCUtil.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, senderId);
                ps.setInt(2, receiverId);
                return ps.executeUpdate() > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }


