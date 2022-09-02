package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ClaimsServiceImpl implements ClaimsService{

    @Autowired
    private ClaimsDetailsRepository claimsDetailsRepository;

    @Override
    public ClaimsDetails addNewClaim(ClaimsDetails newClaimsDetails) {
        return claimsDetailsRepository.save(newClaimsDetails);
    }

    @Override
    public void setCustomer(ClaimsDetails newClaimsDetails, Customer newCustomer) {
        newClaimsDetails.setCustomer(newCustomer);
    }

    @Override
    public void setStatus(ClaimsDetails newClaimsDetails, Statuses status) {
        newClaimsDetails.setStatus(status);
    }

    @Override
    public List<ClaimsDetails> getClaimsByStatus(String selectedStatus) {
        if (selectedStatus.equals("open")){
            return claimsDetailsRepository.findAllByStatusOpen(true);
        }else if (selectedStatus.equals("closed")){
            return claimsDetailsRepository.findAllByStatusOpen(false);
        }
        return claimsDetailsRepository.findAll();
    }

    @Override
    public ClaimsDetails updateClaimDetails(Integer id, Map<String, String> data) {
        Optional<ClaimsDetails> getClaim = claimsDetailsRepository.findById (id);
        ClaimsDetails claim = getClaim.get();
        Customer customer = claim.getCustomer();
        Statuses status = claim.getStatus();

        if(data.containsKey("title")){
            customer.setTitle(data.get("title"));
            claim.setCustomer(customer);
        }
        if(data.containsKey("firstName")){
            customer.setFirstName(data.get("firstName"));
            claim.setCustomer(customer);
        }
        if(data.containsKey("surname")){
            customer.setSurname(data.get("surname"));
            claim.setCustomer(customer);
        }
        if (data.containsKey("estimatedValue")) claim.setEstimatedValue(Double.parseDouble(data.get("estimatedValue")));
        if (data.containsKey("incidentDate")) claim.setIncidentDate(LocalDate.parse(data.get("incidentDate")));
        if (data.containsKey("make")) claim.setMake(data.get("make"));
        if (data.containsKey("model")) claim.setModel(data.get("model"));
        if (data.containsKey("year")) claim.setYear(Integer.parseInt(data.get("year")));
        if (data.containsKey("address")) claim.setAddress(data.get("address"));
        if (data.containsKey("animalType")) claim.setAnimalType(data.get("animalType"));
        if (data.containsKey("breed")) claim.setBreed(data.get("breed"));
        if (data.containsKey("claimReason")) claim.setClaimReason(data.get("claimReason"));
        if (data.containsKey("claimDescription")) claim.setClaimDescription(data.get("claimDescription"));
        if (data.containsKey("furtherDetails")) claim.setFurtherDetails(data.get("furtherDetails"));
        return claimsDetailsRepository.save(claim);
    }


}
