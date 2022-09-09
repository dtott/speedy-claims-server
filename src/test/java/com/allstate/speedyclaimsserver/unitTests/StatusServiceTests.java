package com.allstate.speedyclaimsserver.unitTests;

import com.allstate.speedyclaimsserver.control.LoginController;
import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.data.UserRepository;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.domain.Statuses;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class StatusServiceTests {

    @Autowired
    StatusService statusService;

    @MockBean
    ClaimsDetailsRepository claimsDetailsRepository;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    StatusRepository statusRepository;

    @MockBean
    LoginController loginController;

    @MockBean
    UserRepository userRepository;


    @Test
    public void testFindStatusById(){

        Mockito.when(customerRepository.findCustomerByFirstNameAndSurname("John", "Smith")).thenReturn(Optional.of(new Customer(1, "Mr", "John", "Smith")));
        Mockito.when(statusRepository.findById(1)).thenReturn(Optional.of(new Statuses(1, "new", "new", true)));

        Statuses result = statusService.findStatusById(1);

        assertEquals(new Statuses(1, "new", "new", true), result);

    }

}
