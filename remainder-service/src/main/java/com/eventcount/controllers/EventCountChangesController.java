package com.eventcount.controllers;

import com.eventcount.events.EventCountChangedEvent;
import com.eventcount.monitors.EventCountStoreEventChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to get the To do changes
 *
 * @author eventcount
 */
@RequestMapping("/todo-changes")
@RestController
public class EventCountChangesController {

    @Autowired
    EventCountStoreEventChanges monitor;

    @GetMapping
    public List<EventCountChangedEvent> expose() {
        return this.monitor.getRecentEvents();
    }

}
