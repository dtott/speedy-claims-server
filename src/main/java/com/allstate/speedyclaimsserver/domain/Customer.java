package com.allstate.speedyclaimsserver.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;
    private String title;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    public Customer(Integer customerID, String title, String firstName, String surname, List<ClaimsDetails> claimsDetails) {
        this.customerID = customerID;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Customer() {
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
