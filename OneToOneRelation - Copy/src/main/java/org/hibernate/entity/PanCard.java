package org.hibernate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int panCardId;
    @Column(nullable = false,unique = true)
    private  String panCardNumber;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private long pinCode;

    public int getPanCardId() {
        return panCardId;
    }

    public void setPanCardId(int panCardId) {
        this.panCardId = panCardId;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }
}
