package com.revconnect.dao.analytics;

import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostAnalyticsDaoImpl implements PostAnalyticsDao {

    @Override
    public long getLikeCount(Long postId) {
        return countByType(postId, "LIKE");
    }

    @Override
    public long getCommentCount(Long postId) {
        return countByType(postId, "COMMENT");
    }

    private long countByType(Long postId, String type) {

        String sql = "SELECT COUNT(*) FROM interaction WHERE post_id=? AND type=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, postId);
            ps.setString(2, type);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
