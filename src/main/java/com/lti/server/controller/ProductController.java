package com.lti.server.controller;

import com.lti.server.entity.Product;
import com.lti.server.service.ProductService;
<<<<<<< HEAD

=======
>>>>>>> 967ee29281c1f73f5ab4bfb9ec2fdd6d8077a16e
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/prd-api")
public class ProductController {
    @Autowired
    ProductService service;

    // http://localhost:8090/prd-api/prdlist
    @GetMapping("/prdlist")
    public List<Product> getPrdList() {
        List<Product> prdList=service.getPrdList();
        return prdList;
    }

    // http://localhost:8090/prd-api/prdlistbyname/mercedes
    @GetMapping("/prdlistbyname/{pname}")
    public List<Product> getPrdByName(@PathVariable("pname") String pName){
        List<Product> prdList=service.getPrdByName(pName);
        return prdList;
    }
}
