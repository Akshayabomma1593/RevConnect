package com.revconnect.dao;

import com.revconnect.model.Profile;
import com.revconnect.model.User;
import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao {

    @Override
    public boolean registerUser(User user) {

        String sql = "INSERT INTO users (user_id, username, email, password, role, is_private) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setInt(6, user.isPrivate() ? 1 : 0);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String email, String password) {

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setPrivate(rs.getInt("is_private") == 1);
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Profile getProfileByUserId(int userId) {

        String sql = "SELECT * FROM profiles WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Profile profile = new Profile();
                profile.setProfileId(rs.getInt("profile_id"));
                profile.setUserId(rs.getInt("user_id"));
                profile.setDisplayName(rs.getString("display_name"));
                profile.setBio(rs.getString("bio"));
                profile.setContactInfo(rs.getString("contact_info"));
                profile.setWebsite(rs.getString("website"));
                profile.setProfilePicturePath(rs.getString("profile_picture_path"));
                return profile;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

