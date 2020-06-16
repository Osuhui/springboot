package com.huiwl.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class UserDto_mybatis {

	private String usrId;

	private String usrName;

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	@Override
	public String toString() {
		return "UserDto_mybatis [usrId=" + usrId + ", usrName=" + usrName + "]";
	}

}
