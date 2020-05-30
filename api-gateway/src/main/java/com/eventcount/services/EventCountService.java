package com.eventcount.services;

import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import java.util.List;

public interface EventCountService {
    
    public List<User> getAll();

    public List<EventCount> getEventCountByUserEmaill(String email);

    EventCount createEventCount(EventCount todo);
}
