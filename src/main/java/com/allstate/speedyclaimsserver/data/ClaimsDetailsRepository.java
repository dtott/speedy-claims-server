package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsDetailsRepository extends JpaRepository<ClaimsDetails, Integer> {
}
