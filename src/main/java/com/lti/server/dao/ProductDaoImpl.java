package com.lti.server.dao;

import com.lti.server.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getPrdList() {
        Query qry=em.createQuery("select p from Product p");
        List<Product> prdList=qry.getResultList();
        return prdList;
    }


    @Override
    public List<Product> getPrdByName(String pName) {
        Query qry=em.createQuery("select p from Product p where p.prdName=:pName");
        qry.setParameter("pName", pName);
        List<Product> prdListByName=qry.getResultList();
        return prdListByName;
    }
}
