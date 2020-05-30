package com.eventcount.services;

import com.eventcount.clients.UserClient;
import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserClient userClient;

    @Override
    public List<User> getAll() {
        return userClient.getAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userClient.getUserByEmail(email);
    }

    @Override
    public EventCount createUser(User user) {
        return userClient.createUser(user);
    }

}
