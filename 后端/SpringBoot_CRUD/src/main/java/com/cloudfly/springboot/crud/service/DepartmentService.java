package com.cloudfly.springboot.crud.service;

import com.cloudfly.springboot.crud.pojo.Department;

import java.util.List;

/**
 * @author CloudFly
 */
public interface DepartmentService {
	/**
	 * 查询部门列表
	 *
	 * @return
	 */
	List<Department> departmentList();
}
