package com.allstate.speedyclaimsserver.unitTests;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainClassTests {

    @Test
    public void testEqualityForClaimDetails(){
        //Given two claimDetails entries
        ClaimsDetails claim1 = new ClaimsDetails();
        ClaimsDetails claim2 = new ClaimsDetails();

        //When both have the same ID
        claim1.setClaimId(123);
        claim2.setClaimId(123);

        //Then the claims should be equal
        assertEquals(claim1, claim2);

    }

    @Test
    public void testEqualityForCustomer(){

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setCustomerID(123);
        customer2.setCustomerID(123);

        assertEquals(customer1, customer2);
    }

    @Test
    public void testEqualityForStatuses(){
        Statuses status1 = new Statuses();
        Statuses status2 = new Statuses();

        status1.setId(123);
        status2.setId(123);

        assertEquals(status1, status2);
    }

}
