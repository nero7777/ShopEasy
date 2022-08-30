package com.lti.server.dao;

import com.lti.server.entity.User;
import com.lti.server.exception.UserException;

import java.util.List;

public interface UserDao {
    public int addUser();

    public List<User> getAllUser();

    public List<User> findUserByName(String name);

    public int updateByPhone(int id,long newPhoneNo);

    public boolean Validate(int userId,String userName,String userPass) throws UserException;
}
