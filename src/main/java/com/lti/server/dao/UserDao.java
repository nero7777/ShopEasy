package com.lti.server.dao;

import com.lti.server.entity.User;
import com.lti.server.exception.UserException;
import com.lti.server.exception.UserPassMismatchException;

import java.util.List;

public interface UserDao {
    public int addUser(User user);

    public List<User> getAllUsers();

    public List<User> findUserByName(String name);

    public int updateByPhone(int id,long newPhoneNo);

    public int Validate(int userId, String userName, String userPass) throws UserException, UserPassMismatchException;
}
