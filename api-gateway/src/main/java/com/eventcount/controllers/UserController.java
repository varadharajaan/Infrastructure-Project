package com.eventcount.controllers;

import com.eventcount.clients.EventCountClient;
import com.eventcount.clients.UserClient;
import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import com.eventcount.services.EventCountService;
import com.eventcount.services.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/accounts")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EventCountService todoService;

    @GetMapping
    public List<User> all() {
        return this.userService.getAll();
    }

    @GetMapping("/me")
    public User me(OAuth2Authentication auth) {
        return this.userService.getUserByEmail(auth.getName());
    }

    @GetMapping("/me/todos")
    public List<EventCount> todos(OAuth2Authentication auth) {
        return this.todoService.getEventCountByUserEmaill(auth.getName());
    }

    @PostMapping("/me/todos")
    public EventCount create(@RequestBody EventCount todo) {
        return this.todoService.createEventCount(todo);
    }

}
