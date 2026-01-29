package com.revconnect.service;

import com.revconnect.model.Profile;
import com.revconnect.model.User;

public interface IUserService {

    boolean registerUser(User user);

    User login(String email, String password);

    Profile viewProfile(int userId);
}
