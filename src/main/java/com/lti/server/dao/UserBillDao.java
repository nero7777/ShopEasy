package com.lti.server.dao;

import java.util.List;

import com.lti.server.entity.UserBill;

public interface UserBillDao {
    public List<UserBill> getUserProduct(int userId);
    public int addUserBill(UserBill tempBill);
    public boolean updateEmiByOne(int billId);
}
