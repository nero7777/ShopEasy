package com.lti.server.service;

import com.lti.server.dao.UserDao;
import com.lti.server.entity.User;
import com.lti.server.exception.UserException;
import com.lti.server.exception.UserPassMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public int updateByPhone(int userId, long newPhoneNo) {
        return userDao.updateByPhone(userId,newPhoneNo);
    }

    @Override
    public int Validate(int userId, String userName, String userPass) throws UserException, UserPassMismatchException {
        return userDao.Validate(userId,userName,userPass);
    }
}
