package com.aug.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aug.demo.model.Demo;
import com.aug.demo.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
@WebAppConfiguration
public class DemoServiceTest {
    @Autowired
    private DemoService demoServicel;

    @Test
    public void testGetName() {
        System.out.println(demoServicel.getName());
    }

    // @Test
    public void testCreateDemo() {
        demoServicel.createDemo(new Demo(1, "zhangsan"));
        demoServicel.createDemo(new Demo(2, "lisi"));
        demoServicel.createDemo(new Demo(3, "wangwu"));
        demoServicel.createDemo(new Demo(4, "zhaoliu"));
        demoServicel.createDemo(new Demo(5, "七郎"));
        demoServicel.createDemo(new Demo(6, "八姑"));
    }

    @Test
    public void testUpdateDemo() {
        demoServicel.updateDemo(new Demo(4, "zhaoliu1"));
    }

    @Test
    public void testGetDemoById() {
        demoServicel.getDemoById(5);
    }

    @Test
    public void testDeleteDemoById() {
        demoServicel.deleteDemoById(6);
    }
}
