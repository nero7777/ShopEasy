package com.lti.server.service;

import java.util.List;

import com.lti.server.entity.UserBill;

public interface UserBillService {
    public List<UserBill> getUserProduct(int userId);
    public int addUserBill(UserBill tempBill);
    public boolean updateEmiByOne(int billId);

}
