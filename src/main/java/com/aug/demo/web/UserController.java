package com.aug.demo.web;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aug.demo.model.User;
import com.aug.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(User user) {
        user.setCreateTime(new Date());
        return userService.create(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User updateUserById(@PathVariable int id, User user) {
        user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
