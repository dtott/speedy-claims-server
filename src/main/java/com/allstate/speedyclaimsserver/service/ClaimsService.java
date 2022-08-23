package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;

import java.util.List;

public interface ClaimsService {

    public List<ClaimsDetails> getAllClaimsDetails();
    public ClaimsDetails addNewClaim(ClaimsDetails newClaimsDetails);
    public void setCustomer(ClaimsDetails newClaimsDetails, Customer newCustomer);


}