package com.elosztott.controller;

import java.util.List;

import com.elosztott.model.User;
import com.elosztott.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findUsers() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addItem(@Valid @RequestBody User user, BindingResult result) {
        User def = new User();
        if(!result.hasErrors())
        {
            def= repo.saveAndFlush(user);
        }
        return def;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User updatedUser, @PathVariable Integer id) {
        updatedUser.setId(id);
        return repo.saveAndFlush(updatedUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Integer id) {
        repo.delete(id);
    }

}
