package com.aug.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.demo.dao.UserDao;
import com.aug.demo.exception.ServiceException;
import com.aug.demo.model.User;
import com.aug.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.insert(user);
    }

    @Override
    public User update(User user) {
        User existingUser = userDao.getById(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            existingUser.setGender(user.getGender());
            existingUser.setUpdateTime(new Date());
            userDao.update(existingUser);
        } else {
            throw new ServiceException("User is not exist for id: " + user.getId() + "");
        }
        return existingUser;
    }

    @Override
    public void deleteByName(String name) {
        int count = userDao.deleteByName(name);
        if (count <= 0) {
            throw new ServiceException("Delete user by name failed. ");
        }
    }

    @Override
    public int deleteAllUsers() {
        return userDao.deleteAllUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUserById(int userId) {
        int count = userDao.deleteById(userId);
        if (count <= 0) {
            throw new ServiceException("Delete user by id failed. caused by: userId =  " + userId);
        }
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

}
