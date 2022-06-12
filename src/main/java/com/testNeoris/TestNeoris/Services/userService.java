package com.testNeoris.TestNeoris.Services;

import com.testNeoris.TestNeoris.Entity.PeopleEntity;
import com.testNeoris.TestNeoris.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class userService {

    /*@Autowired
    private PeopleRepository peopleRepository;
    public PeopleEntity getUserEntity(int userId) {

        PeopleEntity userEntity = peopleRepository.findByUser(userId);

        if(userEntity == null) {
            String cause = String.format("Does not exist an user with userId %s", userId);
            /*String message = exceptionLoggin.buildMessage(cause
                    ,this.getClass().toString());
            exceptionLoggin.saveLog(message);*
        }

        return userEntity;
    }*/
}
