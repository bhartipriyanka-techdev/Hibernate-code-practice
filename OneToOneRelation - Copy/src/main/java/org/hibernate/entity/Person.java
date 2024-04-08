package org.hibernate.entity;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    @Column(nullable = false)
    private String personName;
    @Column(nullable = false,unique = true)
    private long personPhoneNo;
    @OneToOne
    private PanCard panCard;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public long getPersonPhoneNo() {
        return personPhoneNo;
    }

    public void setPersonPhoneNo(long personPhoneNo) {
        this.personPhoneNo = personPhoneNo;
    }

    public PanCard getPanCard() {
        return panCard;
    }

    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }
}
