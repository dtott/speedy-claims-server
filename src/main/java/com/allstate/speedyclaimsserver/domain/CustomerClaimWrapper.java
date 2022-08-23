package com.allstate.speedyclaimsserver.domain;

import java.util.List;

public class CustomerClaimWrapper {

    private Customer customer;
    private ClaimsDetails claimsDetails;

    public CustomerClaimWrapper() {
    }

    public CustomerClaimWrapper(Customer customer, ClaimsDetails claimsDetails) {
        this.customer = customer;
        this.claimsDetails = claimsDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ClaimsDetails getClaimsDetails() {
        return claimsDetails;
    }

    public void setClaimsDetails(ClaimsDetails claimsDetails) {
        this.claimsDetails = claimsDetails;
    }
}
