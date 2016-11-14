package com.aug.demo.dao;

import java.util.List;

import com.aug.demo.model.User;

public interface UserDao {

    /**
     * Add a user.
     * 
     * @param user
     * @return
     */
    public User insert(User user);

    /**
     * Update user
     * 
     * @param user
     * @return
     */
    public User update(User user);

    /**
     * Get user by userId
     * 
     * @param id
     * @return
     */
    public User getById(int userId);

    /**
     * Delete user by userId
     * 
     * @param userId
     * @return
     */
    public int deleteById(int userId);

    /**
     * Delete all users
     * 
     * @return
     */
    public int deleteAllUsers();

    /**
     * Get all users
     * 
     * @return
     */
    public List<User> getAllUsers();

    /**
     * Delete user by userName
     * 
     * @param name
     * @return
     */
    public int deleteByName(String name);
}
