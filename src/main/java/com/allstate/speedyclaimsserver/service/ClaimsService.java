package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ClaimsService {

    public ClaimsDetails addNewClaim(ClaimsDetails newClaimsDetails);
    public void setCustomer(ClaimsDetails newClaimsDetails, Customer newCustomer);
    public void setStatus(ClaimsDetails newClaimsDetails, Statuses status);
    public List<ClaimsDetails> getClaimsByStatus(String selectedStatus);
    public ClaimsDetails updateClaimDetails(Integer id, Map<String, String> data);

}
