package com.eventcount.controllers;

import com.eventcount.EventPublisher;
import com.eventcount.entities.EventCount;
import com.eventcount.exceptions.DataNotFoundException;
import com.eventcount.services.EventCountService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Controller responsible of accessing ToDo's functionalities
 *
 * @author eventcount
 */
@RequestMapping("/todos")
@RestController
public class EventCountController {

    @Autowired
    EventCountService todoService;

    @Autowired
    EventPublisher publisher;

    @GetMapping
    public List<EventCount> all() {
        return this.todoService.all();
    }
    
    @GetMapping("search")
    public List<EventCount> getByUserEmail(@RequestParam("email") String email) {
        return this.todoService.getByUserEmail(email);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid EventCount todo, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        EventCount saved = this.todoService.save(todo);
        Long id = saved.getId();
        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @RequestBody @Valid EventCount eventCount
    ) {
        return ResponseEntity.ok(todoService.update(id, eventCount));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable long id) {
        Optional<EventCount> findById = todoService.findById(id);
        return findById.map(todo -> {
            return ResponseEntity.ok(todo);
        }).orElseThrow(() -> new DataNotFoundException("EventCount not found"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{id}/status")
    public ResponseEntity<?> statusUpdate(@PathVariable long id, @RequestBody JsonNode statusUpdate) {
        JsonNode status = statusUpdate.get("status");
        if (status == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    header("reason", "JSON should contains field done").
                    build();
        }
        EventCount todo = todoService.updateStatus(
                id,
                EventCount.EventCountStatus.valueOf(status.asText())
        );
        return ResponseEntity.ok(todo);
    }

}
