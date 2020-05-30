/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventcount.eventsourcing.events;

import com.eventcount.eventsourcing.entities.Email;
import com.eventcount.AppEvent;

/**
 *
 * @author eventcount
 */
public interface EmailEvent extends AppEvent{
    
    Email getEmail();
    
}
