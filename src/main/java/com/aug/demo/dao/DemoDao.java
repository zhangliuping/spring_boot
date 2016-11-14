package com.aug.demo.dao;

import com.aug.demo.model.Demo;

public interface DemoDao {

    Demo insert(Demo demo);

    void update(Demo existingDemo);

    Demo getById(int id);

    void deleteById(int demoId);

}
