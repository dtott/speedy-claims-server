package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ClaimsDetailsRepository claimsDetailsRepository;

    @Override
    public Customer findCustomerById(int id) {
        Optional<Customer> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()){
            Customer newCustomerEntity = customerEntity.get();
            return newCustomerEntity;
        }
        // add error here
        return null;
    }

    @Override
    public Customer addNewCustomerIfNotAlreadyAdded(Customer customer) {
        Optional<Customer> customerEntity = customerRepository.findCustomerByFirstNameAndSurname(customer.getFirstName(), customer.getSurname());
        System.out.println(customerEntity);
        if (customerEntity.isPresent()){
            Customer existingCustomerEntity = customerEntity.get();
            return  existingCustomerEntity;
        }
        return customerRepository.save(customer);
    }


}
