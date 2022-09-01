package com.lti.server.dao;

import com.lti.server.entity.Admin;
import com.lti.server.entity.Product;
import com.lti.server.entity.User;
import com.lti.server.service.AdminService;
import com.lti.server.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {
    @Autowired
    AdminService adminService;

    @Autowired
    ProductService prodService;

    @Autowired
    AdminDao admindao;

    @MockBean
    ProductDao prddao;

    @Test
    void testGetPrdList() {
        Product prod1 = new Product(1, "Car", 12536, "Car");
        Product prod2 = new Product(2, "Bus", 6532, "Bus");
        List<Product> prdList = new ArrayList();

        prdList.add(prod1);
        prdList.add(prod2);

        Mockito.when(prddao.getPrdList()).thenReturn(prdList);
        assertEquals(prdList,prodService.getPrdList());
    }

    @Test
    void testGetAdminTrue() {
        List<Admin> admin = admindao.getByAdminId(101);// adminId 101 is in database
        assertEquals(true, admin.size() > 0);
    }

    @Test
    void testGetAdminFalse() {
        List<Admin> admin = admindao.getByAdminId(102);// adminId 102 is not in database
        assertEquals(false, admin.size() > 0);
    }

    // Testing User Details having values

    @Test
    void testUserDetailsTrue() {
        List<User> user = admindao.findUser(401);// UserId 401 is in database
        assertEquals(true, user.size() > 0);
    }

    @Test
    void testUserDetailsFalse() {
        List<User> user = admindao.findUser(236);// UserId 236 is not in database
        assertEquals(false, user.size() > 0);
    }

    // Testing AddProduct module

    @Test
    void testAddProduct() {
        adminService.deleteProduct(3);//Test product deleted with prdId 3
        Product prod = new Product(3, "Car", 650000, "Mercedez Benz Q2");
        String result = adminService.addProduct(prod);//Test product added with prdId 3
        assertEquals("Car", result);// expected output is the prdName

    }

    // Testing Delete Product module

    @Test
    void testDeleteProduct() {
        Product prod = new Product(1, "Car", 650000, "Mercedez Benz Q2");
        adminService.addProduct(prod);//Test product added with prdId 1
        boolean result = adminService.deleteProduct(1);//Test product deleted with prdId1
        assertEquals(true, result);//expected output is the boolen value

    }


}