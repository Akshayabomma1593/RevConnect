package com.revconnect.service;

import com.revconnect.dao.IUserDao;
import com.revconnect.dao.UserDaoImpl;
import com.revconnect.model.Profile;
import com.revconnect.model.User;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public boolean registerUser(User user) {

        // simple validation
        if (user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        return userDao.registerUser(user);
    }

    @Override
    public User login(String email, String password) {

        if (email == null || password == null) {
            return null;
        }
        return userDao.login(email, password);
    }

    @Override
    public Profile viewProfile(int userId) {
        return userDao.getProfileByUserId(userId);
    }
}