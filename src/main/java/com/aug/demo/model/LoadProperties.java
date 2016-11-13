package com.aug.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoadProperties {

    // @Value("${properties name}")
    @Value("${name}")
    private String name;
    @Value("${title}")
    private String title;
    @Value("${desc}")
    private String desc;
    @Value("${str}")
    private String str;
    @Value("${number}")
    private int number;
    @Value("${numberLong}")
    private long numberLong;
    @Value("${test1}")
    private int test1;
    @Value("${test2}")
    private int test2;

    @Value("${serverName}")
    private String serverName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getNumberLong() {
        return numberLong;
    }

    public void setNumberLong(long numberLong) {
        this.numberLong = numberLong;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

}
