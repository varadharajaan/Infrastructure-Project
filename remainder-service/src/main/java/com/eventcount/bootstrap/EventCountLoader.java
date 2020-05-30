/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventcount.bootstrap;

import com.eventcount.entities.EventCount;
import com.eventcount.repositories.EventCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class EventCountLoader implements ApplicationListener<ContextRefreshedEvent>  {

    private final EventCountRepository todoRepository;
    private final Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    @Autowired
    public EventCountLoader(EventCountRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public void onApplicationEvent(ContextRefreshedEvent e) {
        EventCount todo1 = new EventCount("varadharajaan@gmail.com","Test caption", "description 1", 2);
        EventCount todo2 = new EventCount("gael@gmail.com","Test caption 2", "description 2", 3);
        EventCount todo3 = new EventCount("marcia@gmail.com","Test caption 3", "description 3", 2);
        
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        
        log.info("Created the to-dos.");
    }
    
}
