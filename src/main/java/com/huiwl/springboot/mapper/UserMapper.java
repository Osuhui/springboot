package com.huiwl.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.huiwl.springboot.dto.UserDto_mybatis;

@Mapper
public interface UserMapper {

//	@Select("select USR_ID as usrId,USR_NAME as usrName from J_USR where rownum < 10")
	public List<UserDto_mybatis> findAll();

	public UserDto_mybatis findOne(String usrId);

	public int getCount();

	public List<UserDto_mybatis> getPage(@Param("startRow") int startRow, @Param("endRow") int endRow,
			@Param("total") int total);

	public List<UserDto_mybatis> getPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

	public int updateUser(@Param("user") UserDto_mybatis user);
}
