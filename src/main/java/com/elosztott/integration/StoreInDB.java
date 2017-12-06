package com.elosztott.integration;

import com.elosztott.model.User;
import com.elosztott.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreInDB {

    @Autowired
    UserRepository repo;

    public User save(User u) {
        return repo.saveAndFlush(u);
    }
}
