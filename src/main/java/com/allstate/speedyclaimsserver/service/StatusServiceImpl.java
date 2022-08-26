package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService{

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Statuses findStatusById(Integer id) {
        // Optional<Customer> customerEntity = customerRepository.findCustomerByFirstNameAndSurname(customer.getFirstName(), customer.getSurname());
        Optional<Statuses> statusEntity = statusRepository.findById(id);
        Statuses newStatus = statusEntity.get();
        return newStatus;
    }
}
