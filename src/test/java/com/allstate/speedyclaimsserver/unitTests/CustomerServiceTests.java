package com.allstate.speedyclaimsserver.unitTests;

import com.allstate.speedyclaimsserver.control.LoginController;
import com.allstate.speedyclaimsserver.data.ClaimsDetailsRepository;
import com.allstate.speedyclaimsserver.data.CustomerRepository;
import com.allstate.speedyclaimsserver.data.StatusRepository;
import com.allstate.speedyclaimsserver.data.UserRepository;
import com.allstate.speedyclaimsserver.domain.Customer;
import com.allstate.speedyclaimsserver.service.CustomerService;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CustomerServiceTests {

    @Autowired
    CustomerService customerService;

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
    public void testFindCustomerByID(){

        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(new Customer(1, "Mr", "John", "Smith")));
        Customer result = customerService.findCustomerById(1);

        assertEquals(new Customer(1, "Mr", "John", "Smith"), result);

    }

}
