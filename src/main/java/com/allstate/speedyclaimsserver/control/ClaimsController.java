package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import com.allstate.speedyclaimsserver.dtos.CustomerClaimDto;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.CustomerService;
import com.allstate.speedyclaimsserver.service.StatusService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class ClaimsController {

    //For testing
    @Autowired
    StatusRepository statusRepository;

    //For testing
    @Autowired
    ClaimsDetailsRepository claimsDetailsRepository;

    //For testing
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ClaimsService claimsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StatusService statusService;

    @PostMapping("/addNewClaim/{id}")
    public ClaimsDetails addNewClaim(@RequestBody ClaimsDetails newClaimsDetails, @PathVariable("id") Integer id){
        Customer newCustomer = customerService.findCustomerById(id);
        Statuses newStatus = statusService.findStatusById(1);
        claimsService.setCustomer(newClaimsDetails, newCustomer);
        claimsService.setStatus(newClaimsDetails, newStatus);
        return claimsService.addNewClaim(newClaimsDetails);
    }

    @PostMapping("/addNewCustomer")
    public Customer addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomerIfNotAlreadyAdded(customer);
    }

    @GetMapping("/DisplayClaims/{selectedStatus}")
    public List<ClaimsDetails> getTestClaimsBasedOnStatus(@PathVariable("selectedStatus") String selectedStatus){
        return claimsService.getClaimsByStatus(selectedStatus);
    }

    @GetMapping("/getClaim/{id}")
    public ClaimsDetails getClaimDetailsById(@PathVariable("id") Integer id){
        Optional<ClaimsDetails> validClaim = claimsDetailsRepository.findById(id);
        return validClaim.get();
    }

    @PutMapping("/updateClaim/{id}")
    public ClaimsDetails updateClaimDetails(@PathVariable("id") Integer id, @RequestBody Map<String, String> data){
        return claimsService.updateClaimDetails(id, data);
    }

    @PostMapping("/testAddClaim")
    public ClaimsDetails testAddClaim(@RequestBody ClaimsDetails claimsDetails){
        System.out.println(claimsDetails.getCustomer());
        CustomerClaimDto customerClaimDto = new CustomerClaimDto();
        customerClaimDto.setCustomerFields(claimsDetails);
        System.out.println(customerClaimDto.getCustomer());
        Customer customer = customerClaimDto.getCustomer();
        claimsDetails.setCustomer(customer);
        return claimsDetails;
    }

}
