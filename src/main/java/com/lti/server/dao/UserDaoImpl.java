package com.lti.server.dao;

import com.lti.server.entity.User;
import com.lti.server.exception.UserException;
import com.lti.server.exception.UserPassMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao{

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public int addUser(User user) {
        em.persist(user);
        return user.getUserId();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createQuery("select u from User u");
        List<User> myList = query.getResultList();
        return myList;
    }

    @Override
    @Transactional
    public List<User> findUserByName(String name) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.userName=:name", User.class);
        query.setParameter("name",name);
        List<User> myList = query.getResultList();
        return myList;
    }

    @Override
    @Transactional
    public int updateByPhone(int userId, long newPhoneNo) {
        User user = em.find(User.class,userId);
        user.setUserPhone(newPhoneNo);
        User temp = em.merge(user);
        return temp.getUserId();
    }

    @Override
    public boolean Validate(int userId, String userName, String userPass) throws UserException, UserPassMismatchException {
        try{
            User user = em.find(User.class,userId);
            if(user.getUserName().equalsIgnoreCase(userName) && user.getUserPass().equals(userPass)){
                return true;
            }else{
               throw new UserPassMismatchException("Username or Password Incorrect !!");
            }

        }catch(Exception u){
            throw new UserException("User Not Found !!");
        }
    }
}
