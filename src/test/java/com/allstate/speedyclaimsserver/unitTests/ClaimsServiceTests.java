package com.allstate.speedyclaimsserver.unitTests;

import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.StatusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ClaimsServiceTests {

    @Autowired
    ClaimsService claimsService;

    @MockBean
    ClaimsDetailsRepository claimsDetailsRepository;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    StatusRepository statusRepository;

    @MockBean
    StatusService mockStatusService;

    @Test
    public void testAddNewClaim(){

        Mockito.when(claimsDetailsRepository.save(new ClaimsDetails())).thenReturn(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));

        ClaimsDetails result = claimsService.addNewClaim(new ClaimsDetails());

        assertEquals(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null), result);

    }

    @Test
    public void testFindById(){

        Mockito.when(claimsDetailsRepository.findById(1)).thenReturn(Optional.of(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null)));

        ClaimsDetails results = claimsService.findById(1);

        assertEquals(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null), results);

    }

    @Test
    public void testGetClaimsByStatus(){

        List<ClaimsDetails> trueList = new ArrayList<>();
        trueList.add(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));
        trueList.add(new ClaimsDetails(2, new Customer(3, "Miss", "Sally", "White"), new Statuses(2, "open", "open", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));

        Mockito.when(claimsDetailsRepository.findAllByStatusOpen(true)).thenReturn(trueList);

        Mockito.when(claimsDetailsRepository.findAll()).thenReturn(trueList);

        int results = claimsService.getClaimsByStatus("open").size();

        assertEquals(2, results);

    }

    @Test
    public void testUpdateClaimStatus(){

        Mockito.when(claimsDetailsRepository.findById(1)).thenReturn(Optional.of(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null)));

        Mockito.when(mockStatusService.findStatusById(1)).thenReturn(new Statuses(1, "new", "new", true));

        ClaimsDetails claim = new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null);

        Mockito.when(claimsDetailsRepository.save(claim)).thenReturn(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));

        ClaimsDetails result = claimsService.updateClaimStatus(1, 1);

        assertEquals(claim, result);

    }

}
