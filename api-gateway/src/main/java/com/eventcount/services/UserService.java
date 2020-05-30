package com.eventcount.services;

import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import java.util.List;


public interface UserService {
    
    List<User> getAll();

    User getUserByEmail(String email);
    
    EventCount createUser(User user);
}
