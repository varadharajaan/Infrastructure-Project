package com.eventcount.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.eventcount.entities.Account;
import org.springframework.stereotype.Component;
import com.eventcount.repositories.AccountRepository;


@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final AccountRepository userRepository;

    private final Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    @Autowired
    public UserLoader(AccountRepository todoRepository) {
        this.userRepository = todoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        Account user1 = new Account("Alex lindo", "varadharajaan@gmail.com", "1234");
        Account user2 = new Account("Gaekke delicia", "gaelle@meama.com", "2222");
        Account user3 = new Account("Márcia almeida", "marciapalito@hotmail.com", "2222");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        log.info("Created the todos.");
    }

}
