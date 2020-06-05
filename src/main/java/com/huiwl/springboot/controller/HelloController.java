package com.huiwl.springboot.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() throws Exception {
		return DateFormat.getDateTimeInstance().format(new Date());
	}
}
