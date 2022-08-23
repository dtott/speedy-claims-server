package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
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
    public Customer addNewCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

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

}
