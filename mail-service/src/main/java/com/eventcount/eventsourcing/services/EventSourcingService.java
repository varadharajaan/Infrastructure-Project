/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventcount.eventsourcing.services;

import com.eventcount.eventsourcing.aggregates.Aggregate;
import com.eventcount.eventsourcing.eventstore.EventStream;
import com.eventcount.AppEvent;
import java.util.List;

/**
 *
 * @author eventcount
 */
public interface EventSourcingService {
    
    Aggregate save(Aggregate aggregate) ;
    
    List<AppEvent> getRelatedEvents(String uuid);
    
    EventStream getAggregate(String uuid);
}
