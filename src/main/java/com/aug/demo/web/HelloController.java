package com.aug.demo.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aug.demo.enums.Gender;
import com.aug.demo.exception.ServiceException;
import com.aug.demo.model.LoadProperties;
import com.aug.demo.model.User;

@Controller
public class HelloController {

    @Autowired
    private LoadProperties loadProperties;

    @RequestMapping("/hello1")
    @ResponseBody
    public String hello() {
        return loadProperties.getDesc() + " : " + loadProperties.getStr() + " : " + loadProperties.getNumber() + " : "
                + loadProperties.getNumberLong() + " : " + loadProperties.getTest1() + " : " + loadProperties.getTest2()
                + " : " + loadProperties.getServerName();
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new RuntimeException("发生错误");
    }

    @RequestMapping("/runtimeException")
    @ResponseBody
    public User runtimeException() {
        throw new ServiceException("发生错误");
    }

    @RequestMapping("/hello")
    public String test() {
        return "Hello, world!";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("evan");
        user.setPassword("abc123_");
        user.setEmail("evan@qq.com");
        user.setGender(Gender.FEMAEL.name());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return user;
    }
}
