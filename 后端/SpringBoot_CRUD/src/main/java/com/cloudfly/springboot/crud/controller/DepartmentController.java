package com.cloudfly.springboot.crud.controller;

import com.cloudfly.springboot.crud.pojo.Department;
import com.cloudfly.springboot.crud.service.DepartmentService;
import com.cloudfly.springboot.crud.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: CloudFly
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 查询部门列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/departmentList", method = RequestMethod.GET)
	public Result departmentList() {
		List<Department> departmentList = departmentService.departmentList();
		return new Result("查询成功！", departmentList);
	}

}
