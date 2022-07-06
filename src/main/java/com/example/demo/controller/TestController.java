package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.vo.Restful;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }



    @RequestMapping("/test")
    public Restful test(){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setAge(22);
        user.setUsername("测试人员");
        user.setPassword("123456");
        user.setRealName("张三");
        users.add(user);
        Restful ok = Restful.ok(users);
        return ok;
    }

}
