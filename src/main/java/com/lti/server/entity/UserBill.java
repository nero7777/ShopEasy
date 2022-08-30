package com.lti.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERBILLS")
public class UserBill {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "BILLSEQ")
    @SequenceGenerator(name="BILLSEQ",sequenceName = "BILLSEQ",allocationSize = 1)
    int billId;

    @Column(name="USERID")
    int userId;

    @ManyToOne
    @JoinColumn(name="PRDID")
    Product prd;

    @Column(name="EMIMONTH")
    int emiMonth;

    @Column(name="EMIPAID")
    int emiPaid=0;

    public int getEmiPaid() {
        return emiPaid;
    }

    public void setEmiPaid(int emiPaid) {
        this.emiPaid = emiPaid;
    }

    public int getBillId() {
        return billId;
    }

    public int getEmiMonth() {
        return emiMonth;
    }

    public void setEmiMonth(int emiMonth) {
        this.emiMonth = emiMonth;
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

    public Product getPrd() {
        return prd;
    }

    public void setPrd(Product prd) {
        this.prd = prd;
    }



    public UserBill() {
        super();
    }

    public UserBill(int billId, int userId, Product prd, int emiMonth, int emiPaid) {
        super();
        this.billId = billId;
        this.userId = userId;
        this.prd = prd;
        this.emiMonth = emiMonth;
        this.emiPaid = emiPaid;
    }

    @Override
    public String toString() {
        return "UserBill [billId=" + billId + ", userId=" + userId + ", prd=" + prd + ", emiMonth=" + emiMonth
                + ", emiPaid=" + emiPaid + "]";
    }






}