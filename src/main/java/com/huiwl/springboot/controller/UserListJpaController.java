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
public class UserListJpaController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("userList_jpa_page")
	public String userListFindAll(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		start = start < 0 ? 0 : start;
		Sort sort = new Sort(Sort.Direction.DESC, "usrId");
		Pageable pageable = new PageRequest(start, size, sort);
		Page<UserDto_jpa> page = userDao.findAll(pageable);
		m.addAttribute("page", page);
		return "userList_jpa";
	}

	@RequestMapping("userList_jpa_save")
	public String userListInsert(UserDto_jpa user) throws Exception {
		userDao.save(user);
		return "redirect:userList_jpa_page";
	}

	@RequestMapping("userList_jpa_delete")
	public String userListDelete(UserDto_jpa user) throws Exception {
		userDao.delete(user);
		return "redirect:userList_jpa_page";
	}

	@RequestMapping("userList_jpa_update")
	public String userListUpdate(UserDto_jpa user) throws Exception {
		userDao.save(user);
		return "redirect:userList_jpa_page";
	}

	@RequestMapping("userList_jpa_edit")
	public String userListEdit(String usrId, Model m) throws Exception {
		UserDto_jpa user = userDao.getOne(usrId);
		m.addAttribute("user", user);
		return "editUser";
	}

}
