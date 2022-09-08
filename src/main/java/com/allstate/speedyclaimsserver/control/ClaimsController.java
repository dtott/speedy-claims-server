package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.CustomerService;
import com.allstate.speedyclaimsserver.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ClaimsController {

    @Autowired
    ClaimsService claimsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StatusService statusService;

    //addNewClaim
    @PostMapping("/claim/{id}")
    public ClaimsDetails addNewClaim(@RequestBody ClaimsDetails newClaimsDetails, @PathVariable("id") Integer id){
        Customer newCustomer = customerService.findCustomerById(id);
        Statuses newStatus = statusService.findStatusById(1);
        claimsService.setCustomer(newClaimsDetails, newCustomer);
        claimsService.setStatus(newClaimsDetails, newStatus);
        return claimsService.addNewClaim(newClaimsDetails);
    }

    //addNewCustomer
    @PostMapping("/customer")
    public Customer addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomerIfNotAlreadyAdded(customer);
    }

    //getClaimsWithSelectedStatus
    @GetMapping("/claim")
    public List<ClaimsDetails> getClaimsBasedOnStatus(@RequestParam(value="selectedStatus", required = false) String selectedStatus){
        return claimsService.getClaimsByStatus(selectedStatus);
    }

    //getClaim
    @GetMapping("/claim/{id}")
    public ClaimsDetails getClaimDetailsById(@PathVariable("id") Integer id){
        return claimsService.findById(id);
    }

    //updateClaim
    @PutMapping("/claim/{id}")
    public ClaimsDetails updateClaimDetails(@PathVariable("id") Integer id, @RequestBody Map<String, String> data){
        return claimsService.updateClaimDetails(id, data);
    }

    //updateClaimStatus
    @PutMapping("/claim/{claimId}/{statusId}")
    public ClaimsDetails updateClaimStatus(@PathVariable("claimId") Integer claimId, @PathVariable("statusId") Integer statusId){
        return claimsService.updateClaimStatus(claimId, statusId);
    }

}
