package com.lti.server.entity;

public class UserBillPrdDto {
    int billId;
    int userId;
    int prdId;
    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getPrdId() {
        return prdId;
    }
    public void setPrdId(int prdId) {
        this.prdId = prdId;
    }
    public UserBillPrdDto() {
        super();
    }

}