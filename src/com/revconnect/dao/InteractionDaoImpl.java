package com.revconnect.dao;

import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InteractionDaoImpl {

    // INSERT interaction
    public void saveInteraction(long userId, long postId, String type, String comment) {

        String sql = "INSERT INTO interactions " +
                "(user_id, post_id, interaction_type, comment_text) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, userId);
            ps.setLong(2, postId);
            ps.setString(3, type);
            ps.setString(4, comment);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to save interaction", e);
        }
    }

    // COUNT by type
    public int countByType(long postId, String type) {

        String sql = "SELECT COUNT(*) FROM interactions " +
                "WHERE post_id = ? AND interaction_type = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, postId);
            ps.setString(2, type);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to count interactions", e);
        }
    }
}
