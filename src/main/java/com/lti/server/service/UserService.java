package com.lti.server.service;

import com.lti.server.entity.User;
import com.lti.server.exception.UserException;
import com.lti.server.exception.UserPassMismatchException;


import java.util.List;

public interface UserService {

    //Methods in Service Interface Implemented in UserServiceImplementation

    public int addUser(User user);

    public List<User> getAllUsers();

    public List<User> findUserByName(String name);

    public int updateByPhone(int userId,long newPhoneNo);

    public int Validate(int userId,String userName,String userPass) throws UserException, UserPassMismatchException;

}
