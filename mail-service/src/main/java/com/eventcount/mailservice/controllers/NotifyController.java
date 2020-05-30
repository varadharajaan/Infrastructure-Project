package com.eventcount.mailservice.controllers;

import com.eventcount.eventsourcing.aggregates.EmailState;
import com.eventcount.eventsourcing.commands.EmailCommandHandler;
import com.eventcount.eventsourcing.commands.EmailCreateCommand;
import com.eventcount.eventsourcing.entities.Email;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eventcount
 */
@RestController
@RequestMapping("/send")
public class NotifyController {

    @Autowired
    EmailCommandHandler emailCommandHandler;

    @GetMapping("email")
    public @ResponseBody Future<String> sendEmail() {
        Supplier supplier = () -> {
            String uuid = UUID.randomUUID().toString();
            EmailCreateCommand command = new EmailCreateCommand(
                    uuid,
                    new Email("Alexsandro", "varadharajaan@gmail.com", EmailState.CREATED)
            );
            Executors.newCachedThreadPool().submit(() -> {
                try {
                    emailCommandHandler.create(command);
                } catch (Exception ex) {
                    ReflectionUtils.rethrowRuntimeException(ex);
                }
            });
            return "Email sent successfully.  - code= " + uuid;
        };

        return CompletableFuture.supplyAsync(supplier, Executors.newCachedThreadPool());

    }

}
