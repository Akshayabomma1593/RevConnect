package com.revconnect.dao;

import com.revconnect.model.Profile;
import com.revconnect.model.User;

public interface IUserDao {

    boolean registerUser(User user);

    User login(String email, String password);

    Profile getProfileByUserId(int userId);
}
