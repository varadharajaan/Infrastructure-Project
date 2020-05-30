package com.eventcount.mailservice.controllers;

import com.eventcount.eventsourcing.entities.Email;
import com.eventcount.mailservice.repository.EmailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eventcount
 */
@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    EmailRepository repository;

    @GetMapping
    public List<Email> list() {
        return repository.findAll();
    }

}
