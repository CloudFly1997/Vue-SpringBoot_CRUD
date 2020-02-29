package com.cloudfly.springboot.crud.service.impl;

import com.cloudfly.springboot.crud.mapper.DepartmentMapper;
import com.cloudfly.springboot.crud.pojo.Department;
import com.cloudfly.springboot.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CloudFly
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	/**
	 * 查询部门列表
	 *
	 * @return
	 */
	@Override
	public List<Department> departmentList() {
		return departmentMapper.departmentList();
	}
}
