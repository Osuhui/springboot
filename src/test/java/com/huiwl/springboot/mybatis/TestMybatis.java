package com.huiwl.springboot.mybatis;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiwl.springboot.Application;
import com.huiwl.springboot.dto.UserDto_mybatis;
import com.huiwl.springboot.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMybatis {

	static final Logger LOG = LoggerFactory.getLogger(TestMybatis.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test01() {
		LOG.info("--------------------test01-Start--------------------");
		PageHelper.startPage(2, 10, true);
		List<UserDto_mybatis> userList = userMapper.findAll();
		PageInfo<UserDto_mybatis> page = new PageInfo<>(userList);
		Iterator<UserDto_mybatis> iterator = page.getList().iterator();
		while (iterator.hasNext()) {
			LOG.info(iterator.next().getUsrId());
		}

		LOG.info("--------------------test01-End----------------------");
	}

	@Test
	public void test02() {
		LOG.info("--------------------test02-Start--------------------");

		System.out.println(userMapper.getCount());
		System.out.println(userMapper.findOne("Y99999"));
		List<UserDto_mybatis> userList = userMapper.getPage(11, 20);
		if (!userList.isEmpty() && userList.size() > 0) {
			for (UserDto_mybatis user : userList) {
				System.out.println(user.getUsrId());
			}
		}
		LOG.trace("Hello World!");
		LOG.debug("How are you today?");
		LOG.info("I am fine.");
		LOG.warn("I love programming.");
		LOG.error("I am programming.");
		LOG.info("--------------------test02-End----------------------");
	}

}
