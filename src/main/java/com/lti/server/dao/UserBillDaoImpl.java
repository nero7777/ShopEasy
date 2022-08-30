package com.lti.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.server.entity.UserBill;

@Repository
public class UserBillDaoImpl implements UserBillDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserBill> getUserProduct(int userId) {
        Query qry=em.createQuery("select ub from UserBill ub where ub.userId=:uId");
        qry.setParameter("uId", userId);
        List<UserBill> userBillList=qry.getResultList();
        return userBillList;

    }

    @Override
    @Transactional
    public int addUserBill(UserBill tempBill) {
        System.out.println(tempBill.getBillId());
        System.out.println(tempBill.getUserId());
        System.out.println(tempBill.getPrd());
        em.persist(tempBill);
        return tempBill.getBillId();

    }

    @Override
    @Transactional
    public boolean updateEmiByOne(int billId) {
        UserBill bill=em.find(UserBill.class, billId);
        bill.setEmiPaid(bill.getEmiPaid()+1);
        em.merge(bill);
        return true;
    }
}
