package com.eventcount.repositories;


import com.eventcount.entities.EventCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author eventcount
 */
@Repository
public interface EventCountRepository  extends JpaRepository<EventCount, Long>  {
    
     void deleteById(Long id);
     
     List<EventCount> findByUserEmail(String email);
}
