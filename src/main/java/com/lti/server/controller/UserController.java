package com.lti.server.controller;


import com.lti.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user-api")
public class UserController {

    @Autowired
    private UserService userService;


    //Create a user in database (localhost:8085/user-api/adduser)
    @PostMapping("/adduser")
    public int addUser(@RequestBody User user){
        int userId = userService.addUser(user);
    }

    //Getting all users (localhost:8085/user-api/getAllUser)
    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    //Getting user by name (localhost:8085/user-api/finduserbyname/rahul)
    @GetMapping("/finduserbyname/{name}")
    public List<User> findUserByName(@PathVariable("name") String userName){
        List<User> mylist = userService.findUserByName(userName);
        return mylist;
    }

    //Updating user's phone number (localhost:8085/user-api/updateByPhone/1/9503092018)
    @PutMapping("/updateByPhone/{userId}/{newPhoneNo}")
    public String updateByPhone(@PathVariable("userId") int userId,@PathVariable("newPhoneNo") long newPhoneNo){
            int id = userService.updateByPhone(userId,newPhoneNo);
            return "Phone no for " + id + " updated Successfully !!";
    }

    //Validate User
    @GetMapping("/validate/{userId}/{userName}/{userPass}")
    public boolean validate(@PathVariable("userId") int userId
            ,@PathVariable("userName") String userName
            ,@PathVariable("userPass") String userPass)throws UserException {

        try{
                boolean res = userService.Validate(userId,userName,userPass);
                return res;
        }catch(UserException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    
        //Sample user for user Body
    	/*{
		   "userName":"Rahul",
		   "userPhone":78548965,
		   "userEmail":"def@gmail.com",
		   "userPass":"rahul@gmail.com",
		   "userConfirmPass":"ghft@",
		   "userAdd":"Mumbai",
		   "userSalary":60000,
		   "userCard":"Platinum"
		}*/
}
