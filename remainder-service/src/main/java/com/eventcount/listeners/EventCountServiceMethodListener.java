package com.eventcount.listeners;

import com.eventcount.events.EventCountServiceMethodInvokedEvent;
import com.eventcount.monitors.EventCountServiceMethodInvokedStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * EventCountService method invoked listener
 * 
 * @author eventcount
 */
@Component
public class EventCountServiceMethodListener {
    
    @Autowired
    private EventCountServiceMethodInvokedStore methodMonitor;
    
    @EventListener
    public void onMethodCalled(EventCountServiceMethodInvokedEvent event){
        methodMonitor.addNewEvent(event);
    }
    
}
