package com.huiwl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huiwl.springboot.dto.UserDto_jpa;

public interface UserDao extends JpaRepository<UserDto_jpa, String> {

	UserDto_jpa findByusrId(String usrId);

	UserDto_jpa findByusrName(String usrName);
}
