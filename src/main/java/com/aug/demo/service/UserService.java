package com.aug.demo.service;

import java.util.List;

import com.aug.demo.model.User;

public interface UserService {

    /**
     * Add a new user
     * 
     * @param user
     * @return
     */
    User create(User user);

    /**
     * Update a user
     * 
     * @param user
     * @return
     */
    User update(User user);

    /**
     * Delete user by userName
     * 
     * @param name
     */
    void deleteByName(String name);

    /**
     * Delete user by userId
     * 
     * @param userId
     */
    void deleteUserById(int userId);

    /**
     * Delete all users
     * 
     * @return
     */
    int deleteAllUsers();

    /**
     * Get user by Id
     * 
     * @param userId
     * @return
     */
    User getById(int userId);

    /**
     * Get all users
     * 
     * @return
     */
    List<User> getAllUsers();
}
