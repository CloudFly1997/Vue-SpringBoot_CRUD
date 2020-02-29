package com.cloudfly.springboot.crud.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体类
 *
 * @author CloudFly
 */
@Data
public class Department implements Serializable {

	private Integer id;
	private String name;
}
