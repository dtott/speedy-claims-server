package com.allstate.speedyclaimsserver.dtos;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;

import javax.persistence.Column;

public class CustomerClaimDto {

    private String title;
    private String firstName;
    private String surname;

    private ClaimsDetails claimsDetails;

    public CustomerClaimDto() {
    }

    public CustomerClaimDto(String title, String firstName, String surname, ClaimsDetails claimsDetails) {
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.claimsDetails = claimsDetails;
    }

    public void setCustomerFields(ClaimsDetails claimsDetails){
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Customer getCustomer(){
        Customer newCustomer = new Customer(null, title, firstName, surname, null);
        return newCustomer;
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

    public ClaimsDetails getClaimsDetails() {
        return claimsDetails;
    }

    public void setClaimsDetails(ClaimsDetails claimsDetails) {
        this.claimsDetails = claimsDetails;
    }
}
