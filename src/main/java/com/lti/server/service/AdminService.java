package com.lti.server.service;

import java.util.List;

import com.lti.server.entity.Admin;
import com.lti.server.entity.Product;
import com.lti.server.entity.User;

public interface AdminService {
	
	public List<Admin> getByAdminId(long adminId);

	public List<User> getUserdetails();

	public List<User> findUser(int userId);

	public boolean deleteUser(int userId);

	public String addProduct(Product product);

	public boolean deleteProduct(int prdId);

	public String updateCardStatus(int userId);
}
