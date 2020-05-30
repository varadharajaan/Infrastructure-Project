package com.eventcount.integrations.socket;

import com.eventcount.annotations.ChangeEvent;
import com.eventcount.entities.EventCount;
import com.eventcount.events.EventCountChangedEvent;
import com.eventcount.pojos.SocketOutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.EncodeException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class EventCountChangeSocketNotify {


    private SimpMessagingTemplate template;

    @Autowired
    public void setTemplate(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void notify(EventCountChangedEvent e) throws EncodeException {
        EventCount todo = e.getEventCount();
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        Class<? extends EventCountChangedEvent> aClass = e.getClass();

        ChangeEvent annotation = aClass.getAnnotation(ChangeEvent.class);
        ChangeEvent.Type value = annotation.value();
        SocketOutputMessage socketOutputMessage = new SocketOutputMessage(todo, value.toString(), time);
        template.convertAndSend("/topic/todos", socketOutputMessage);
    }

}
