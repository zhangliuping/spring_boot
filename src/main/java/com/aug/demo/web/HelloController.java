package com.aug.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aug.demo.exception.ServiceException;
import com.aug.demo.model.LoadProperties;

@Controller
public class HelloController {

    @Autowired
    private LoadProperties loadProperties;

    @RequestMapping("/hello")
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
    public String runtimeException() {
        throw new ServiceException("发生错误");
    }
}
