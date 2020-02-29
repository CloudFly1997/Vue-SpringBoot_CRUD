package com.cloudfly.springboot.crud.service.impl;

import com.cloudfly.springboot.crud.mapper.UserMapper;
import com.cloudfly.springboot.crud.pojo.User;
import com.cloudfly.springboot.crud.service.UserService;
import com.cloudfly.springboot.crud.utils.IdWorker;
import com.cloudfly.springboot.crud.utils.StringUtils;
import com.cloudfly.springboot.crud.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author CloudFly
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IdWorker idWorker;

	/**
	 * 根据 id 查询
	 *
	 * @param id
	 * @return
	 */
	@Override
	public User getById(String id) {
		return userMapper.getById(id);
	}

	/**
	 * 保存
	 *
	 * @param user
	 */
	@Override
	public void save(User user) {
		user.setUserId(idWorker.nextId() + "");
		user.setCreatedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		userMapper.save(user);
	}

	/**
	 * 根据 id 删除
	 *
	 * @param id
	 */
	@Override
	public void deleteById(String id) {
		userMapper.deleteById(id);
	}

	/**
	 * 根据 id 更新
	 *
	 * @param user
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateById(User user) {
		User u = userMapper.getById(user.getUserId());
		user.setVersion(u.getVersion());
		user.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		userMapper.updateById(user);
	}

	/**
	 * 分页查询
	 *
	 * @param userVo
	 * @return
	 */
	@Override
	public List<User> getAll(UserVo userVo) {
		// 处理排序方式
		String sortMethod = userVo.getSortMethod();
		if (sortMethod != null && !"".equals(sortMethod)) {
			if (sortMethod.toLowerCase().contains("desc")) {
				sortMethod = "desc";
			}else {
				sortMethod = "asc";
			}
		}
		userVo.setSortMethod(sortMethod);

		String sortColumn = userVo.getSortColumn();
		if (sortColumn != null && !"".equals(sortColumn)) {
			sortColumn = StringUtils.upperCharToUnderLine(sortColumn);
			userVo.setSortColumn(sortColumn);
		}

		return userMapper.getAll(userVo);
	}
}
