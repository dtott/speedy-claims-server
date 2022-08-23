package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClaimsServiceImpl implements ClaimsService{

    @Autowired
    private ClaimsDetailsRepository claimsDetailsRepository;


    @Override
    public List<ClaimsDetails> getAllClaimsDetails() {
        return claimsDetailsRepository.findAll();
    }

    @Override
    public ClaimsDetails addNewClaim(ClaimsDetails newClaimsDetails) {
        return claimsDetailsRepository.save(newClaimsDetails);
    }

    @Override
    public void setCustomer(ClaimsDetails newClaimsDetails, Customer newCustomer) {
        newClaimsDetails.setCustomer(newCustomer);
    }

    @Override
    public ClaimsDetails setNewClaim(Customer newCustomer, String address) {
        ClaimsDetails newClaimDetails = new ClaimsDetails();
        newClaimDetails.setCustomer(newCustomer);
        newClaimDetails.setAddress(address);
        System.out.println(newClaimDetails);
        return claimsDetailsRepository.save(newClaimDetails);
    }

    @Override
    public void setStatus(ClaimsDetails newClaimsDetails, Statuses status) {
        newClaimsDetails.setStatus(status);
    }


}
