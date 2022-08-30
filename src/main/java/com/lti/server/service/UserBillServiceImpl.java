package com.lti.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.server.entity.UserBill;
import com.lti.server.dao.UserBillDao;

@Service("userBillService")
public class UserBillServiceImpl implements UserBillService{

    @Autowired
    UserBillDao userBillDao;

    @Override
    public List<UserBill> getUserProduct(int userId) {
        return userBillDao.getUserProduct(userId);
    }

    @Override
    public int addUserBill(UserBill tempBill) {

        return userBillDao.addUserBill(tempBill);
    }

    @Override
    public boolean updateEmiByOne(int billId) {

        return userBillDao.updateEmiByOne(billId);
    }

}

