package com.lti.server.dao;

import com.lti.server.entity.User;
import com.lti.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    UserService services;

    @Test
    public void testUserList() {
        List<User> testList=services.getAllUsers();
        int listSize = testList.size();
        assertNotNull(listSize);
        assertEquals(2, listSize);
    }

    @Test
    public void testFindUserbyName() {
        String name="Hritik";
        List<User> myList = services.findUserByName(name);
        assertNotNull(myList);
        assertEquals("Hritik", myList.get(0).getUserName());
    }

    @Test
    public void testUpdatePhoneNo() {
        int id=111, newPhoneNo=48744;
        int userId=services.updateByPhone(id, newPhoneNo);
        assertEquals(147, userId);
    }

}
