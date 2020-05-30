package com.eventcount.eventsourcing.commands;

import com.eventcount.eventsourcing.aggregates.EmailAggregate;
import com.eventcount.eventsourcing.services.EventSourcingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.desktop.AppEvent;
import java.util.List;

/**
 * Email command service handler. Deal with the business requirements before
 * send the command
 *
 * @author eventcount
 */
@Service
@Transactional
public class EmailCommandHandler  {

    private final EventSourcingService eventSourcingService;

    private final EventPublisher eventPublisher;

    public EmailCommandHandler(
            EventSourcingService eventSourcingService,
            EventPublisher eventPublisher
    ) {
        this.eventSourcingService = eventSourcingService;
        this.eventPublisher = eventPublisher;   
    }

    
    public void create(EmailCreateCommand command) throws Exception {
        EmailAggregate emailAggregate = getByUUID(command.getUuid());
        emailAggregate = emailAggregate.create(command);
        List<AppEvent> pendingEvents = emailAggregate.getUncommittedChanges();
        eventSourcingService.save(emailAggregate);

        pendingEvents.forEach(eventPublisher::publish);
        pendingEvents.forEach(eventPublisher::stream);
    }

    public void send(EmailSendCommand command) throws Exception {
        EmailAggregate emailAggregate = getByUUID(command.getUuid());
        emailAggregate = emailAggregate.send(command);

        List<AppEvent> pendingEvents = emailAggregate.getUncommittedChanges();
        pendingEvents.forEach(eventPublisher::stream);
        
        eventSourcingService.save(emailAggregate);
    }

    public void delivery(EmailDeliveryCommand command) throws Exception {
        EmailAggregate emailAggregate = getByUUID(command.getUuid());
        emailAggregate = emailAggregate.delivery(command);
        
        List<AppEvent> pendingEvents = emailAggregate.getUncommittedChanges();
        pendingEvents.forEach(eventPublisher::stream);
        
        eventSourcingService.save(emailAggregate);
    }

    public void delete(EmailDeleteCommand command) throws Exception {
        EmailAggregate emailAggregate = getByUUID(command.getUuid());
        emailAggregate.delete(command);
        
        List<AppEvent> pendingEvents = emailAggregate.getUncommittedChanges();
        pendingEvents.forEach(eventPublisher::stream);
        
        eventSourcingService.save(emailAggregate);
    }

    public EmailAggregate getByUUID(String uuid) {
        return EmailAggregate.from(uuid, eventSourcingService.getRelatedEvents(uuid));
    }
}
