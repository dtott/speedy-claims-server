package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    public Customer findCustomerById(int id);
    public Customer addNewCustomerIfNotAlreadyAdded(Customer customer);

}
