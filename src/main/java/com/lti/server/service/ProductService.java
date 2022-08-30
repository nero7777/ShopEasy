package com.lti.server.service;

import com.lti.server.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getPrdList();
    public List<Product> getPrdByName(String pName);

}
