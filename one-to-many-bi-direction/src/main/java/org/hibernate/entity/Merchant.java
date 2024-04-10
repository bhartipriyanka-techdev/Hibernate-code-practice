package org.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id;
   @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
   private long phone;
    @Column(nullable = false, unique = true)
   private String gstNO;
    @Column(nullable = false)
   private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGstNO() {
        return gstNO;
    }

    public void setGstNO(String gstNO) {
        this.gstNO = gstNO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
