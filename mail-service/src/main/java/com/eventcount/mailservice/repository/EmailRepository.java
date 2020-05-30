package com.eventcount.mailservice.repository;

import com.eventcount.eventsourcing.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eventcount
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
    
}
