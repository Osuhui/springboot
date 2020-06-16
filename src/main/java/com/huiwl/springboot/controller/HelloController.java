package com.huiwl.springboot.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huiwl.springboot.dto.UserDto_mybatis;
import com.huiwl.springboot.mapper.UserMapper;

@RestController
public class HelloController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/hello")
	public String hello() throws Exception {
		return DateFormat.getDateTimeInstance().format(new Date());
	}


	@RequestMapping("/user")
	public UserDto_mybatis userInfo() {
		UserDto_mybatis user = userMapper.findOne("Y99999");
		return user;
	}

	@RequestMapping("/userList")
	public List<UserDto_mybatis> userList() {
		List<UserDto_mybatis> userList = userMapper.findAll();
		return userList;
	}

	@PutMapping("/userJson")
	public void getUser(@RequestBody UserDto_mybatis user) {
		System.out.println(user);
	}

}
