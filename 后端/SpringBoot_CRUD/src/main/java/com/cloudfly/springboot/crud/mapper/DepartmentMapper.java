package com.cloudfly.springboot.crud.mapper;

import com.cloudfly.springboot.crud.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author CloudFly
 */
@Mapper
@Component
public interface DepartmentMapper {
	/**
	 * 查询部门列表
	 *
	 * @return
	 */
	List<Department> departmentList();
}
