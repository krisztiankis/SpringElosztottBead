package com.elosztott.integration;

import com.elosztott.model.Transaction;
import com.elosztott.model.User;
import com.elosztott.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplyTransaction {

    @Autowired
    UserRepository userRepository;

    public void applyTransaction(Transaction t) {
        List<User> allUsers = userRepository.findAll();
        User from = null;
        User to = null;

        for(User u : allUsers) {
            if(u.getUsername().equals(t.getFrom())) {
                from = u;
            }
            if(u.getUsername().equals(t.getTo())) {
                to=u;
            }
        }

        if(from==null || to==null) {
            return;
        }
        else {
            from.setBalance(from.getBalance()-t.getAmount());
            to.setBalance(to.getBalance()+t.getAmount());
            userRepository.saveAndFlush(from);
            userRepository.saveAndFlush(to);
        }
    }
}
