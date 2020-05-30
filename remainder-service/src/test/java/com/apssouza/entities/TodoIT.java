/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventcount.entities;

import com.eventcount.configuration.RepositoryConfiguration;
import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author eventcount
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class EventCountIT {
   
    
    @Test
    public void validateEventCountValid() {
        EventCount toDo = new EventCount("varadharajaan@gmail.com","caption", "description 1", 6);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<EventCount>> constraintViolations = validator.validate(toDo);
        assertTrue(constraintViolations.isEmpty());       
    }
    
     @Test
    public void validateEventCountInValid() {
        EventCount eventCount = new EventCount("varadharajaan@gmail.com","c", "description 1", 6);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<EventCount>> constraintViolations = validator.validate(eventCount);

        if (!constraintViolations.isEmpty()) {
            Iterator itr = constraintViolations.iterator();
            while (itr.hasNext()) {
                ConstraintViolation next = (ConstraintViolation)itr.next();
                Assert.assertEquals("size must be between 2 and 256", next.getMessage());
            }
        }
    }
    
    
    
}
