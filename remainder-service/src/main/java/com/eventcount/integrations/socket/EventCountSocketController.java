package com.eventcount.integrations.socket;

import com.eventcount.pojos.SocketOutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class EventCountSocketController {

    @MessageMapping("/socket-events")
    @SendTo("/topic/events")
    public SocketOutputMessage send(SocketOutputMessage message) throws Exception {
        return message;
    }
}
