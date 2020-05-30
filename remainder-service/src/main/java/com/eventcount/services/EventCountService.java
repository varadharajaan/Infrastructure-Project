package com.eventcount.services;

import com.eventcount.entities.EventCount;
import com.eventcount.exceptions.DataNotFoundException;
import java.util.List;
import java.util.Optional;

public interface EventCountService {

    Optional<EventCount> findById(long id);

    Boolean delete(long id) throws DataNotFoundException;

    List<EventCount> all();

    EventCount save(EventCount todo);

    EventCount updateStatus(long id, EventCount.EventCountStatus status) throws DataNotFoundException;
    
    EventCount update(Long id, EventCount eventCount) throws DataNotFoundException;

    List<EventCount> getByUserEmail(String email);
}
