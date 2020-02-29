package com.cloudfly.springboot.crud.vo;

import com.cloudfly.springboot.crud.pojo.Department;
import lombok.Data;

/**
 * @author CloudFly
 */
@Data
public class UserVo{
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

	private String userBirthdayStart;
	private String userBirthdayEnd;
	private String createdTimeStart;
	private String createdTimeEnd;
	private String sortColumn;
	private String sortMethod;
}
