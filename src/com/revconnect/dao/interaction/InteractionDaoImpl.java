package com.revconnect.dao.interaction;

import com.revconnect.model.Interaction;
import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InteractionDaoImpl implements InteractionDao {

    @Override
    public void save(Interaction interaction) {
        System.out.println("SAVE METHOD CALLED");

        String sql = "INSERT INTO interaction(user_id, post_id, type, comment) VALUES (?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, interaction.getUserId());
            ps.setLong(2, interaction.getPostId());
            ps.setString(3, interaction.getType().name());
            ps.setString(4, interaction.getComment());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsLike(Long userId, Long postId) {

        String sql = "SELECT 1 FROM interaction WHERE user_id=? AND post_id=? AND type='LIKE'";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, userId);
            ps.setLong(2, postId);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
