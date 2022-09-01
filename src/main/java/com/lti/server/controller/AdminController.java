package com.lti.server.controller;


import java.util.List;

import com.lti.server.entity.Admin;
import com.lti.server.entity.Product;
import com.lti.server.entity.User;
import com.lti.server.exception.UserException;
import com.lti.server.exception.UserPassMismatchException;
import com.lti.server.service.AdminService;

import com.lti.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/adminRest/api")
public class AdminController {

	@Autowired
	AdminService adminloginservice;
	

	@GetMapping("/validate/{adminId}/{adminName}/{adminPassword}")
	public int validateAdmin(@PathVariable(value = "adminId") long adminId,
			@PathVariable(value = "adminName") String adminName,
			@PathVariable(value = "adminPassword") String adminPassword) throws UserException, UserPassMismatchException{

		List<Admin> a = adminloginservice.getByAdminId(adminId);
		

//		try{
//            if(a.get(0).getAdminName().equalsIgnoreCase(adminName) && a.get(0).getAdminPassword().equals(adminPassword)){
//                return "Login Successfull";
//            }
//            else{
//               throw new UserPassMismatchException("Username or Password Incorrect !!");
//            }
//
//        }catch(Exception u){
//            throw new UserException("Admin Not Found !!");
//        }

//		try{
//            if(a.get(0).getAdminName().equalsIgnoreCase(adminName) && a.get(0).getAdminPassword().equals(adminPassword)){
//                return "Login Successful!";
//            }
//            else{
//               throw new UserPassMismatchException("Username or Password Incorrect !!");
//            }
//
//        }catch(Exception u){
//            throw new UserException("Admin Not Found !!");
//        }

		

		if (a.get(0).getAdminId() != adminId && (a.get(0).getAdminName().equals(adminName) && a.get(0).getAdminPassword().equals(adminPassword))) {
			return 2;			//UserId is invalid/does not exist
		} else if (a.get(0).getAdminName().equals(adminName) && a.get(0).getAdminPassword().equals(adminPassword)) {
			return 1;			//Successfully logged-In
		}
		else
			return 3;			//Wrong Password
		}

	@GetMapping("/userDetails")
	public List<User> getAllUserdetails() {
		return adminloginservice.getUserdetails();
	}


	@GetMapping("/userDetails/{userId}")
	public List<User> findUserDetailsById(@PathVariable(value = "userId") int userId) {
		List<User> result = adminloginservice.findUser(userId);
		return result;
	}


	@DeleteMapping("/userDetails/delete/{userId}")
	public String deleteUser(@PathVariable(value = "userId") int userId) {
		adminloginservice.deleteUser(userId);
		return "User Id " + userId + " deleted";
	}


	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product) {
		
		return adminloginservice.addProduct(product);
	}


	@DeleteMapping("/deleteProduct/{prdId}")
	public String deleteProduct(@PathVariable(value = "prdId") int prdId) {
		adminloginservice.deleteProduct(prdId);
		return "Product Id " + prdId + " deleted";
	}

	

	@PutMapping("/updateCardStatus/{userId}")
	public String updateCardStatus(@PathVariable(value="userId") int userId) {
		adminloginservice.updateCardStatus(userId);
		return "UserId "+userId+" is verified";
	}


}
