package com.allstate.speedyclaimsserver.unitTests;

import com.allstate.speedyclaimsserver.control.ClaimsController;
import com.allstate.speedyclaimsserver.control.LoginController;
import com.allstate.speedyclaimsserver.data.UserRepository;
import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
import com.allstate.speedyclaimsserver.service.BootstrapService;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import com.allstate.speedyclaimsserver.service.CustomerService;
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

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ControllerClassTests {

    @Autowired
    ClaimsController claimsController;

    @MockBean
    CustomerService customerService;

    @MockBean
    ClaimsService claimsService;

    @MockBean
    StatusService statusService;

    @MockBean
    BootstrapService bootstrapService;

    @MockBean
    LoginController loginController;

    @MockBean
    UserRepository userRepository;

    //Post controller test
    @Test
    public void testThatNewCustomerIsAdded() {
        Customer newCustomer = new Customer();
        Mockito.when(customerService.addNewCustomerIfNotAlreadyAdded(newCustomer))
                        .thenReturn(new Customer(1, "Mr", "John", "Smith"));

        Customer result = claimsController.addNewCustomer(newCustomer);
        assertEquals(new Customer(1, "Mr", "John", "Smith"), result);
    }

    //Post controller test
    @Test
    public void testThatNewClaimWasAdded(){

        Customer newCustomer = new Customer(1, "Mr", "John", "Smith");
        Statuses newStatus = new Statuses(1, "new", "awaiting assessment", true);
        Mockito.when(claimsService.addNewClaim(new ClaimsDetails())).thenReturn(new ClaimsDetails(1, newCustomer, newStatus, "Motor", 200.00, null,
                "crashed Car", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));

        ClaimsDetails result = claimsController.addNewClaim(new ClaimsDetails(), 1);

        ClaimsDetails expectedClaim = new ClaimsDetails(1, newCustomer, newStatus, "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null);

        assertEquals(expectedClaim, result);

    }

    //Get controller test
    @Test
    public void testDisplayClaims(){
        List<ClaimsDetails> newClaims = new ArrayList<>();
        newClaims.add(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));
        newClaims.add(new ClaimsDetails(3, new Customer(2, "Mr", "Joe", "Bloggs"), new Statuses(1, "new", "awaiting assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null));

        Mockito.when(claimsService.getClaimsByStatus("open")).thenReturn(newClaims);

        int result = claimsController.getClaimsBasedOnStatus("open").size();

        assertEquals(2, result);

    }

    //Put controller test
    @Test
    public void testUpdateClaimsStatus(){

        Mockito.when(claimsService.updateClaimStatus(1, 2)).thenReturn(new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(2, "open", "currently under assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null ));

        ClaimsDetails result = claimsController.updateClaimStatus(1,2);

        ClaimsDetails expectedResult = new ClaimsDetails(1, new Customer(1, "Mr", "John", "Smith"), new Statuses(2, "open", "currently under assessment", true), "Motor", 200.00, null,
                "crashed Car!", "backed into lamp post", null, null,
                "renault", "clio", 2012, null, null, null, null );

        assertEquals(expectedResult, result);

    }

}







