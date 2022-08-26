package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public List<ClaimsDetails> getClaimsFromStatus(String selectedStatus) {
        if (selectedStatus.equals("open")){
            List<Integer> ids = Arrays.asList(1, 2);
            return claimsDetailsRepository.findAllById(ids);
        }
        System.out.println("not working" + selectedStatus);
        return null;
    }

    public List<ClaimsDetails> getClaimsByStatus(List<Integer> selectedStatus) {
            return null;
    }
}
