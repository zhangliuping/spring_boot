package com.aug.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.demo.model.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleApplication.class)
public class RedisTemplateTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Demo> redisTemplate;

    @Test
    public void test1() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test() throws Exception {
        // 保存对象
        Demo demo = new Demo(1, "超人");
        redisTemplate.opsForValue().set(demo.getName(), demo);
        demo = new Demo(2, "蝙蝠侠");
        redisTemplate.opsForValue().set(demo.getName(), demo);
        demo = new Demo(3, "蜘蛛侠");
        redisTemplate.opsForValue().set(demo.getName(), demo);
        System.out.println(redisTemplate.opsForValue().get("超人").getId());
        System.out.println(redisTemplate.opsForValue().get("蝙蝠侠").getId());
        System.out.println(redisTemplate.opsForValue().get("蜘蛛侠").getId());
    }
}
