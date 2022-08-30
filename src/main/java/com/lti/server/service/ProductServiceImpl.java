package com.lti.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("prdService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao prdDao;

    @Override
    public List<Product> getPrdList() {
        return prdDao.getPrdList() ;
    }

    @Override
    public List<Product> getPrdByName(String pName) {
        return prdDao.getPrdByName(pName);
    }

}
