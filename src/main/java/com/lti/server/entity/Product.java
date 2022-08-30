package com.lti.server.entity;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Prod_Seq") //generating sequence that is created in database
    @SequenceGenerator(name="Prod_Seq", sequenceName="Prod_Seq", allocationSize=1)
    @Column(name="PRDID")
    int prdId;

    @Column(name="PRDNAME")
    String prdName;

    @Column(name="PRDPRICE")
    double prdPrice;

    @Column(name="PRDDESC")
    String prdDesc;

    public int getPrdId() {
        return prdId;
    }
    public void setPrdId(int prdId) {
        this.prdId = prdId;
    }
    public String getPrdName() {
        return prdName;
    }
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }
    public double getPrdPrice() {
        return prdPrice;
    }
    public void setPrdPrice(double prdPrice) {
        this.prdPrice = prdPrice;
    }
    public String getPrdDesc() {
        return prdDesc;
    }
    public void setPrdDesc(String prdDesc) {
        this.prdDesc = prdDesc;
    }
    public Product() {
        super();
    }
    public Product(int prdId, String prdName, double prdPrice, String prdDesc) {
        super();
        this.prdId = prdId;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdDesc = prdDesc;
    }
    @Override
    public String toString() {
        return "Product [prdId=" + prdId + ", prdName=" + prdName + ", prdPrice=" + prdPrice + ", prdDesc=" + prdDesc
                + "]";
    }



}

