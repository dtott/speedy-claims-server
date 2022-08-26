package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BootstrapService {

    @Autowired
    StatusRepository statusRepository;

    @PostConstruct
    public void inititalizeData(){
        Statuses newStatus = new Statuses(null, "new", "awaiting assessment", true);
        Statuses openStatus = new Statuses(null, "Open", "currently under assessment", true);
        Statuses acceptedStatus = new Statuses(null, "accepted", "awaiting payment", true);
        Statuses paidStatus = new Statuses(null, "paid", "payment complete", false);
        Statuses rejectedStatus = new Statuses(null, "rejected", "claim unsuccessful", false);
        Statuses pushedStatus = new Statuses(null, "pushed", "passed to main claims system", false);

        statusRepository.save(newStatus);
        statusRepository.save(openStatus);
        statusRepository.save(acceptedStatus);
        statusRepository.save(paidStatus);
        statusRepository.save(rejectedStatus);
        statusRepository.save(pushedStatus);

    }

}
