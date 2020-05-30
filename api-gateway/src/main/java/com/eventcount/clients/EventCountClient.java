package com.eventcount.clients;

import com.eventcount.pojos.EventCount;
import com.eventcount.pojos.User;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("todo")
public interface EventCountClient {

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<User> getAll();

    @RequestMapping(value = "/todos/search", method = RequestMethod.GET)
    public List<EventCount> getEventCountByUserEmaill(@RequestParam("email") String email);

    @RequestMapping(
            value = "/todos",
            method = RequestMethod.POST
    )
    EventCount createEventCount(EventCount todo);
}
