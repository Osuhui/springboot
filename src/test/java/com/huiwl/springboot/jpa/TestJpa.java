package com.huiwl.springboot.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huiwl.springboot.Application;
import com.huiwl.springboot.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJpa {

	static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	@Autowired
	private UserDao userDao;

	@Test
	public void test01() {
		LOG.info("--------------------test01-Start--------------------");
		System.out.println(userDao.count());
		System.out.println(userDao.findByusrId("Y99999"));
		LOG.info("--------------------test01-End----------------------");
	}
}
