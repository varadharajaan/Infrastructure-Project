package com.eventcount.listeners;

import com.eventcount.events.EventCountChangedEvent;
import com.eventcount.integrations.socket.EventCountChangeSocketNotify;
import com.eventcount.monitors.EventCountStoreEventChanges;
import javax.websocket.EncodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ToDo Changed listener.
 *
 * @author eventcount
 */
@Component
public class EventCountChangedListener {

    @Autowired
    EventCountStoreEventChanges changesMonitor;

    @Autowired
    EventCountChangeSocketNotify socketNotify;

    @EventListener
    public void onEventCountChange(EventCountChangedEvent event) throws EncodeException {
        changesMonitor.addNewEvent(event);
        socketNotify.notify(event);
    }

}
