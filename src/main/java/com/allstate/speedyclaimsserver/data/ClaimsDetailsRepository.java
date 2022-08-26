package com.allstate.speedyclaimsserver.data;

import com.allstate.speedyclaimsserver.domain.ClaimsDetails;
import com.allstate.speedyclaimsserver.domain.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimsDetailsRepository extends JpaRepository<ClaimsDetails, Integer> {

    public List<ClaimsDetails> findAllByStatusOpen(Boolean selectedStatus);

}
