package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
