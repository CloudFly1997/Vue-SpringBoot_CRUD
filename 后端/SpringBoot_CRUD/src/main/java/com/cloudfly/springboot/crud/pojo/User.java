package com.cloudfly.springboot.crud.pojo;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author CloudFly
 */
@Data
public class User {

	private String userId;
	private String userName;
	private Integer userSex;
	private Integer userAge;
	private String userBirthday;
	private Integer userDepartment;
	private String createdTime;
	private String createdBy;
	private String updateTime;
	private String updateBy;
	private Integer version;
	private Integer deleted;

	private Department department;
}
