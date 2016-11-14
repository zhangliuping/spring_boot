package com.aug.demo.service;

import com.aug.demo.model.Demo;

public interface DemoService {

    public String getName();

    public void createDemo(Demo demo);

    public void updateDemo(Demo demo);

    public void getDemoById(int demoId);

    public void deleteDemoById(int demoId);
}
