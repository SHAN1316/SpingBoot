package com.example.Spring.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RestController
public class CustomerController {
	@RequestMapping("/getUser")
	public User getUser() {
    	User user=new User();
    	user.setName("小明");
    	user.setPassword("xxxx");
        return user;
    }
	

}
