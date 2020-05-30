
package com.eventcount.clients;

import com.eventcount.pojos.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author eventcount
 */
@FeignClient("user")
@Component
public interface UserClient {
    
    @RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
    public User getUserByEmail(@RequestParam("email") String email);
    
}
