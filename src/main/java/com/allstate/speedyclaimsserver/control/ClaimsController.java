package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.CustomerService;
import com.allstate.speedyclaimsserver.service.StatusService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class ClaimsController {

    //For testing
    @Autowired
    StatusRepository statusRepository;

    //For testing
    @Autowired
    ClaimsDetailsRepository claimsDetailsRepository;

    @Autowired
    ClaimsService claimsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StatusService statusService;

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
        Statuses newStatus = statusService.findStatusById(1);
        claimsService.setCustomer(newClaimsDetails, newCustomer);
        claimsService.setStatus(newClaimsDetails, newStatus);
        return claimsService.addNewClaim(newClaimsDetails);
    }

    @PostMapping("/newClaim")
    public ClaimsDetails newClaim(@RequestBody ObjectNode objectNode){
        Customer newCustomer = customerService.findCustomerByFirstName(objectNode);
        if(ObjectUtils.isEmpty(newCustomer)){
            Customer customer = new Customer();
            customerService.addNewCustomer(customer);
            System.out.println("Null");
        }
        System.out.println(newCustomer);
        ClaimsDetails newClaimDetails = claimsService.setNewClaim(newCustomer, objectNode.get("address").asText());
        return claimsService.addNewClaim(newClaimDetails);
    }

    @PostMapping("/addNewCustomer")
    public Customer addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomerIfNotAlreadyAdded(customer);
    }

    @GetMapping("/displayClaims/{selectedStatus}")
    public List<ClaimsDetails> getClaimsBasedOnStatus(@PathVariable("selectedStatus") String selectedStatus){
        // StatusService.checkOpenStatus(String selectedStatus)
        List<Integer> ids = Arrays.asList(5,1);
        return claimsService.getClaimsByStatus(ids);
    }

    @GetMapping("/testDisplayClaims/{selectedStatus}")
    public List<ClaimsDetails> getTestClaimsBasedOnStatus(@PathVariable("selectedStatus") String selectedStatus){
        System.out.println(selectedStatus);
        if (selectedStatus.equals("open")){
            return claimsDetailsRepository.findAllByStatusOpen(true);
        }else if (selectedStatus.equals("closed")){
            return claimsDetailsRepository.findAllByStatusOpen(false);
        }
        return claimsDetailsRepository.findAll();
    }
}
