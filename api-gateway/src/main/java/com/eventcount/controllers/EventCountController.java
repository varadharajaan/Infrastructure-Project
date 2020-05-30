package com.eventcount.controllers;

import com.eventcount.clients.EventCountClient;
import com.eventcount.pojos.User;
import com.eventcount.services.EventCountService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/events")
@RestController
public class EventCountController {

    @Autowired
    EventCountService eventService;

    @GetMapping
    public List<User> all() {
        return this.eventService.getAll();
    }

}
