package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.data.UserRepository;
import com.allstate.speedyclaimsserver.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BootstrapService {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    ClaimsDetailsRepository claimsDetailsRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void inititalizeData(){
        if (statusRepository.findAll().size() == 0){
            Statuses newStatus = new Statuses(null, "new", "awaiting assessment", true);
            Statuses openStatus = new Statuses(null, "open", "currently under assessment", true);
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

        if (userRepository.findAll().size() == 0){
            User newUser = new User("Agent1", "FSD", "Dale Totton", UserRole.USER);
            userManagementService.save(newUser);
        }

        if(claimsDetailsRepository.findAll().size() == 0){

            Customer customer1 = new Customer(1, "Mr", "Simon", "Smith");
            Customer customer2 = new Customer(2, "Mrs", "Jane", "Jones");
            Customer customer3 = new Customer(3, "Dr", "Geraldine", "Green");
            Customer customer4 = new Customer(4, "Prof", "Clive", "Cole");
            Customer customer5 = new Customer(5, "Miss", "Wanda", "Web");
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            ClaimsDetails user1 = new ClaimsDetails(null , customer1,
                    new Statuses(2, "open", "currently under assessment", true), "Motor", 400.00,
                    LocalDate.of(2022, 05, 19), "Backed into lamp post", "Car was reversed into a lamp post and damaged the back of the car",
                    LocalDate.of(2022, 05, 18), "Claimed that the lamp post wasn't there the last time they looked",
                    "Nissan", "Juke", 2018, null, null, null, null);

            ClaimsDetails user2 = new ClaimsDetails(null , customer2,
                    new Statuses(4, "paid", "payment complete", false), "Pet", 240.21,
                    LocalDate.of(2022, 05, 20), "Cut on front left paw", "The dog scraped up against a fence and cut its paw",
                    LocalDate.of(2022, 05, 18), null,
                    null, null, null, null, "Dog", "Border collie", 240.21);

            ClaimsDetails user3 = new ClaimsDetails(null , customer3,
                    new Statuses(5, "rejected", "claim unsuccessful", false), "Motor", 380.40,
                    LocalDate.of(2022, 04, 22), "Skidded on ice", "The car lost control on the road due to the build-up of ice",
                    LocalDate.of(2022, 04, 18), "Had been snowing all morning",
                    "Citroen", "Berlingo", 2021, null, null, null, null);

            ClaimsDetails user4 = new ClaimsDetails(null , customer4,
                    new Statuses(6, "pushed", "passed to main claims system", false), "Property", 200.87,
                    LocalDate.of(2022, 06, 02), "Damage from flood", "Electrics and furniture damage due to the flood",
                    LocalDate.of(2022, 06, 01), null,
                    null, null, null, "15 Acacia Avenue, Bridge End", null, null, null);

            ClaimsDetails user5 = new ClaimsDetails(null , customer5,
                    new Statuses(3, "accepted", "awaiting payment", true), "Property", 300.23,
                    LocalDate.of(2022, 05, 12), "Window broken by neighbour's child playing football", "Window broken by neighbour's child playing football, windows needs replaced",
                    LocalDate.of(2022, 05, 11), "claimed that the lamp post wasn't there the last time they looked",
                    null, null, null, "27 Summer View, Kensington", null, null, null);

            claimsDetailsRepository.save(user1);
            claimsDetailsRepository.save(user2);
            claimsDetailsRepository.save(user3);
            claimsDetailsRepository.save(user4);
            claimsDetailsRepository.save(user5);

        }

    }
}
