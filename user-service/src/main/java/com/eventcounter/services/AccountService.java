package com.eventcount.services;

import com.eventcount.entities.Account;
import com.eventcount.exceptions.DataNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Account service interface
 *
 * @author eventcount
 */
public interface AccountService {

    Optional<Account> findById(long id);

    List<Account> all();

    Account save(Account user);

    Account update(Long id, Account user) throws DataNotFoundException;

    Optional<Account> findByEmail(String name);

    void delete(Account a);
}
