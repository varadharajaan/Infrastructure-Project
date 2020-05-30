package com.eventcount.services;

import com.eventcount.clients.UserClient;
import com.eventcount.pojos.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author eventcount
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserClient userClient;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackUserByEmail")
    public User getUserByEmail(String email) {
        return userClient.getUserByEmail(email);
    }

    public User getFallbackUserByEmail(String email) {
        return new User();
    }

}
