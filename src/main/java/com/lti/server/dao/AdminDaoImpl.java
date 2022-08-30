package com.lti.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lti.server.entity.Admin;
import com.lti.server.entity.Product;
import com.lti.server.entity.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Admin> getByAdminId(long adminId) {
		Query qry = em.createQuery("SELECT a FROM Admin a where a.adminId=:adminId");
		qry.setParameter("adminId", adminId);
		List<Admin> admindetail = qry.getResultList();
		System.out.println(admindetail);
		return admindetail;
	}

	@Override
	public List<User> getUserdetails() {
		Query qry = em.createQuery("SELECT u FROM User u order by u.userId ");
		List<User> userList = qry.getResultList();
		return userList;
	}

	@Override
	public List<User> findUser(int userId) {
		Query qry = em.createQuery("SELECT u FROM User u where u.userId=:userId");
		qry.setParameter("userId", userId);
		List<User> userdetail = qry.getResultList();
		System.out.println(userdetail);
		return userdetail;
	}

	@Override
	public boolean deleteUser(int userId) {
		User newuser = em.find(User.class, userId);
		em.remove(newuser);
		return true;
	}

	@Override
	@Transactional
	public String addProduct(Product product) {
		System.out.println("Dao layer add method called");
		em.persist(product);
		System.out.println("Record added");
		return product.getPrdName();
	}

	@Override
	public boolean deleteProduct(int prdId) {
		Product prd = em.find(Product.class, prdId);
		em.remove(prd);
		return true;
	}

	@Override
	public String updateCardStatus(int userId) {
		User newuser = em.find(User.class, userId);
		newuser.setVerified(true);
		return "ok";
	}
}
