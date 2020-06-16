package com.huiwl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huiwl.springboot.dao.UserDao;
import com.huiwl.springboot.dto.UserDto_jpa;

@Controller
@RequestMapping("/jpa")
public class UserListJpaController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/userpage")
	public String userListFindAll(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		start = start < 0 ? 0 : start;
		Sort sort = new Sort(Sort.Direction.DESC, "usrId");
		Pageable pageable = new PageRequest(start, size, sort);
		Page<UserDto_jpa> page = userDao.findAll(pageable);
		m.addAttribute("page", page);
		return "/jpa/userpage";
	}

	@RequestMapping("/useradd")
	public String userListInsert(UserDto_jpa user) throws Exception {
		System.out.println("user:" + user);
//		userDao.save(user);
		return "redirect:/jpa/userpage";
	}

	@RequestMapping("/userdelete")
	public String userListDelete(UserDto_jpa user) throws Exception {
		System.out.println("user:" + user);
//		userDao.delete(user);
		return "redirect:/jpa/userpage";
	}

	@RequestMapping("/userupdate")
	public String userListUpdate(UserDto_jpa user) throws Exception {
		userDao.save(user);
		return "redirect:/jpa/userpage";
	}

	@RequestMapping("/useredit")
	public String userListEdit(String usrId, Model m) throws Exception {
		UserDto_jpa user = userDao.getOne(usrId);
		m.addAttribute("user", user);
		return "/jpa/useredit";
	}

}
