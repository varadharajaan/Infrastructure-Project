package com.eventcount.services;

import com.eventcount.EventPublisher;
import com.eventcount.entities.EventCount;
import com.eventcount.events.EventCountCreatedEvent;
import com.eventcount.exceptions.DataNotFoundException;
import com.eventcount.monitoring.Monitored;
import com.eventcount.repositories.EventCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventCountServiceImpl implements EventCountService {

    @Autowired
    private EventCountRepository eventCountRepository;
    
    @Autowired
    private EventPublisher publisher;

    @Override
    @Monitored
    public Optional<EventCount> findById(long id) {

        return this.eventCountRepository.findById(id);
    }

    @Override
    @Monitored
    public Boolean delete(long id) throws DataNotFoundException {
        this.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Not found ToDo id " + id));

         this.eventCountRepository.deleteById(id);

         return true;
    }

    @Override
    @Monitored
    public List<EventCount> all() {
        return this.eventCountRepository.findAll();
    }

    @Override
    @Monitored
    public EventCount save(EventCount todo) {
        EventCount savedEventCount = this.eventCountRepository.save(todo);
        this.publisher.stream(new EventCountCreatedEvent(savedEventCount));
        return savedEventCount;
        
    }

    @Override
    @Monitored
    public EventCount updateStatus(long id, EventCount.EventCountStatus status) throws DataNotFoundException {
        return this.findById(id)
                .map((t) -> {
                    t.setStatus(status);
                    return eventCountRepository.save(t);
                }).orElseThrow(() -> new DataNotFoundException("Not found ToDo id " + id));
    }

    @Override
    @Monitored
    public EventCount update(Long id, EventCount eventCount) throws DataNotFoundException {
        return this.findById(id)
                .map(todo -> {
                    todo.setCaption(eventCount.getCaption());
                    todo.setDescription(eventCount.getDescription());
                    todo.setPriority(eventCount.getPriority());
                    return save(todo);
                }).orElseThrow(() -> new DataNotFoundException("User not found"));
    }

    @Override
    @Monitored
    public List<EventCount> getByUserEmail(String email) {
        return this.eventCountRepository.findByUserEmail(email);
    }

}
