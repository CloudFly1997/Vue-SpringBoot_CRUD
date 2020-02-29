package com.cloudfly.springboot.crud.controller;

import com.cloudfly.springboot.crud.pojo.User;
import com.cloudfly.springboot.crud.service.UserService;
import com.cloudfly.springboot.crud.utils.Result;
import com.cloudfly.springboot.crud.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: CloudFly
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 根据id获取用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Result get(@PathVariable String id) {
		User user = userService.getById(id);
		return new Result(user);
	}

	/**
	 * 保存用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(400, "保存失败！");
		}
		return new Result("保存成功！");
	}

	/**
	 * 根据id删除
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		userService.deleteById(id);
		return new Result("删除成功！");
	}

	/**
	 * 更新
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Result update(@RequestBody User user) {
		try {
			userService.updateById(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(400, "更新失败！");
		}
		return new Result("更新成功！");
	}

	/**
	 * 分页查询
	 *
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public Result getByPage(@RequestBody UserVo userVo, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
		//PageHelper
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userService.getAll(userVo);
		PageInfo<User> userPageInfo = new PageInfo<>(userList, 2);
		return new Result(userPageInfo);
	}
}
