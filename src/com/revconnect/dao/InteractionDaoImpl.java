package com.revconnect.dao;

import com.revconnect.model.Interaction;
import com.revconnect.model.PostAnalytics;
import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InteractionDaoImpl implements InteractionDao {

    @Override
    public void saveInteraction(Interaction interaction) {

        String sql = "INSERT INTO interaction (user_id, post_id, type, comment) VALUES (?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, interaction.getUserId());
            ps.setInt(2, interaction.getPostId());
            ps.setString(3, interaction.getInteractionType());
            ps.setString(4, interaction.getCommentText());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PostAnalytics getPostAnalytics(int postId) {

        PostAnalytics analytics = new PostAnalytics();
        analytics.setPostId(postId);

        try (Connection con = JDBCUtil.getConnection()) {

            analytics.setTotalLikes(countByType(con, postId, "LIKE"));
            analytics.setTotalComments(countByType(con, postId, "COMMENT"));
            analytics.setTotalShares(countByType(con, postId, "SHARE"));

            analytics.setReach(
                    analytics.getTotalLikes()
                            + analytics.getTotalComments()
                            + analytics.getTotalShares()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return analytics;
    }

    private int countByType(Connection con, int postId, String type) throws Exception {

        String sql = "SELECT COUNT(*) FROM interaction WHERE post_id=? AND type=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, postId);
            ps.setString(2, type);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
