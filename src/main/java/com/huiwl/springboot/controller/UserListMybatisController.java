package com.huiwl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiwl.springboot.dto.UserDto_mybatis;
import com.huiwl.springboot.mapper.UserMapper;

@Controller
public class UserListMybatisController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("userList_mybatis")
	public String userListFindAll(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		PageHelper.startPage(start, size, "usr_id desc");
		List<UserDto_mybatis> userList = userMapper.findAll();
		PageInfo<UserDto_mybatis> page = new PageInfo<>(userList);
		m.addAttribute("page", page);
		return "userList_mybatis";
	}

}
