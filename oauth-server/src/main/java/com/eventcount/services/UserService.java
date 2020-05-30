package com.eventcount.services;

import com.eventcount.pojos.User;

/**
 * User service.
 *
 * @author eventcount
 */
public interface UserService {

    User getUserByEmail(String email);

}
