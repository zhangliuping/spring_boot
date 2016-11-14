package com.aug.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.demo.dao.DemoDao;
import com.aug.demo.exception.ServiceException;
import com.aug.demo.model.Demo;
import com.aug.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void createDemo(Demo demo) {
        Demo newDemo = demoDao.insert(demo);
        System.out.println(newDemo);
    }

    @Override
    public void updateDemo(Demo demo) {
        Demo existingDemo = demoDao.getById(demo.getId());
        if (existingDemo != null) {
            existingDemo.setName(demo.getName());
            demoDao.update(existingDemo);
        } else {
            throw new ServiceException("Demo is not exist for id: " + demo.getId() + "");
        }
        System.out.println(demoDao.getById(demo.getId()));
    }

    @Override
    public void getDemoById(int demoId) {
        if (demoId > 0) {
            System.out.println(demoDao.getById(demoId));
        }
    }

    @Override
    public void deleteDemoById(int demoId) {
        if (demoId > 0) {
            demoDao.deleteById(demoId);
        }
    }
}
