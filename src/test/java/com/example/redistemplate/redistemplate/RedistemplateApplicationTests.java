package com.example.redistemplate.redistemplate;

import com.example.redistemplate.redistemplate.bo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedistemplateApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        Student student = new Student();
        student.setAge(10);
        student.setName("zhansan");
        student.setSex(1);
        redisTemplate.opsForValue().set("student:zhansan", student);
        System.out.println(redisTemplate.opsForValue().get("student:zhansan"));
        System.out.println(stringRedisTemplate.opsForValue().get("student:zhansan"));
        /**
         * 输出结果：
         * com.example.redistemplate.redistemplate.bo.Student@786ff1cb
         * ["com.example.redistemplate.redistemplate.bo.Student",{"name":"zhansan","age":10,"sex":1}]
         */

        redisTemplate.opsForValue().set("111-222-333", "[1,2,3,4]");
        System.out.println(redisTemplate.opsForValue().get("111-222-333"));
        System.out.println(stringRedisTemplate.opsForValue().get("111-222-333"));
        /**
         * 输出结果：
         * [1,2,3,4]
         * "[1,2,3,4]"
         */
    }

}
