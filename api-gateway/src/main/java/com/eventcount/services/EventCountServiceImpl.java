package com.eventcount.services;

import com.eventcount.clients.EventCountClient;
import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventCountServiceImpl implements EventCountService {

    @Autowired
    EventCountClient todoClient;

    @Override
    public List<User> getAll() {
        return todoClient.getAll();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackEventCounts")
    public List<EventCount> getEventCountByUserEmaill(String email) {
        return todoClient.getEventCountByUserEmaill(email);
    }

    @Override
    public EventCount createEventCount(EventCount todo) {
        return todoClient.createEventCount(todo);
    }

    public List<EventCount> getFallbackEventCounts(String email) {
        return Collections.emptyList();
    }
}
