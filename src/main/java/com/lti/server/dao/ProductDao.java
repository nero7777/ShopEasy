package com.lti.server.dao;

import com.lti.server.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getPrdList();
    public List<Product> getPrdByName(String pName);
}
