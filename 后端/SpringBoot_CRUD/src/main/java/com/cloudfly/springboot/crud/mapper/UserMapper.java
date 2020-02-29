package com.cloudfly.springboot.crud.mapper;

import com.cloudfly.springboot.crud.pojo.User;
import com.cloudfly.springboot.crud.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author CloudFly
 */
@Mapper
@Component
public interface UserMapper {
	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return
	 */
	User getById(String id);

	/**
	 * 保存用户
	 *
	 * @param user
	 */
	void save(User user);

	/**
	 * 根据id删除
	 *
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 根据id更新
	 *
	 * @param user
	 */
	void updateById(User user);

	/**
	 * 分页查询
	 *
	 * @param userVo
	 * @return
	 */
	List<User> getAll(UserVo userVo);
}
