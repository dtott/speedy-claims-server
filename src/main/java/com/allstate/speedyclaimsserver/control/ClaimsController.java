package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ClaimsController {

    @Autowired
    ClaimsService claimsService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getClaims")
    public List<ClaimsDetails> getAll(){
        return claimsService.getAllClaimsDetails();
    }

    @PostMapping("/addClaimCustomer")
    public Customer addNewClaimsCustomer(@RequestBody Customer newClaimsDetails){
        return customerService.addNewCustomer(newClaimsDetails);
    }

    @PostMapping("/addNewClaim/{id}")
    public ClaimsDetails addNewClaim(@RequestBody ClaimsDetails newClaimsDetails, @PathVariable("id") Integer id){
        Customer newCustomer = customerService.findCustomerById(id);
        claimsService.setCustomer(newClaimsDetails, newCustomer);
        return claimsService.addNewClaim(newClaimsDetails);
    }

}
