package com.eventcount.mailservice.integration.reminder;

import com.eventcount.eventsourcing.aggregates.EmailState;
import com.eventcount.eventsourcing.commands.EmailCommandHandler;
import com.eventcount.eventsourcing.commands.EmailCreateCommand;
import com.eventcount.eventsourcing.entities.Email;
import java.time.Instant;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

/**
 *
 * The Stream Kafka event input
 *
 * @author eventcount
 */
@EnableBinding(Sink.class)
public class EventInput {

    Logger LOG = Logger.getLogger(EventInput.class);
    
    private final EmailCommandHandler commanderHandler;

    public EventInput(EmailCommandHandler commander) {
        this.commanderHandler = commander;
    }
    

    @StreamListener(
            target = Sink.INPUT,
            condition = "headers['type']=='EventCountCreatedEvent'"
    )
    public void todoCreated(@Payload EventCountCreatedEvent event) throws Exception {
        LOG.info("EventCount created");
        LOG.info("when = " + event.when());
        LOG.info("todo = " + event.getEventCount().toString());

        String uuid = UUID.randomUUID().toString();
        Email email = new Email("Alexsandro", "test"+Instant.now().getEpochSecond()+"@gmail.com", EmailState.CREATED);
        EmailCreateCommand command = new EmailCreateCommand(uuid, email);
        commanderHandler.create(command);
    }

}
