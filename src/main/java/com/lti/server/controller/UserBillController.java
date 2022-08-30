package com.lti.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Product;
import com.lti.beans.UserBill;
import com.lti.services.UserBillService;

@CrossOrigin("*")
@RestController
@RequestMapping("/bill-api")
public class UserBillController {

    @Autowired
    UserBillService userBillService;

    //http://localhost:8090/bill-api/getUserBill/101
    @GetMapping("/getUserBill/{uId}")
    public List<UserBill> getUserBill(@PathVariable("uId") int userId){
        System.out.println("inside controller");
        return userBillService.getUserProduct(userId);

    }


    //http://localhost:8090/bill-api/addUserBill/101/1/3

    @PostMapping("/addUserBill/{uId}/{pId}/{eId}")
    public int addUserBill(@PathVariable("uId") int userId,@PathVariable("pId") int prdId,@PathVariable("eId") int emiMonth) {
        UserBill tempBill=new UserBill();
        tempBill.setUserId(userId);
        tempBill.setEmiMonth(emiMonth);


        Product tempP=new Product();
        tempP.setPrdId(prdId);
        tempBill.setPrd(tempP);

        return userBillService.addUserBill(tempBill);
    }

    //http://localhost:8090/bill-api/updateEmiByOne/1001
    @PutMapping("/updateEmiByOne/{bId}")
    public boolean updateEmiByOne(@PathVariable("bId") int billId) {
        return userBillService.updateEmiByOne(billId);
    }

}
