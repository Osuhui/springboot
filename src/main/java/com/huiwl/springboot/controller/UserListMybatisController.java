package com.huiwl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiwl.springboot.dto.UserDto_mybatis;
import com.huiwl.springboot.mapper.UserMapper;

@RequestMapping("/mybatis")
@Controller
public class UserListMybatisController {

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/userpage")
	public String getAllUser(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		PageHelper.startPage(start, size, "usr_id desc");
		List<UserDto_mybatis> userList = userMapper.findAll();
		PageInfo<UserDto_mybatis> page = new PageInfo<>(userList);
		m.addAttribute("page", page);
		return "/mybatis/userpage";
	}

	@GetMapping("/userpage/{usrId}")
	public String getUser(@PathVariable("usrId") String usrId, Model m) throws Exception {
		UserDto_mybatis user = userMapper.findOne(usrId);
		m.addAttribute("user", user);
		return "/mybatis/useredit";
	}

	@PutMapping("/userpage/{usrId}")
	public String updateUser(UserDto_mybatis user) throws Exception {
		userMapper.updateUser(user);
		return "redirect:/mybatis/userpage";
	}

}
