package com.eventcount.clients;

import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("user")
public interface UserClient {

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<User> getAll();

    @RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
    public User getUserByEmail(@RequestParam("email") String email);

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    EventCount createUser(User user);
}
