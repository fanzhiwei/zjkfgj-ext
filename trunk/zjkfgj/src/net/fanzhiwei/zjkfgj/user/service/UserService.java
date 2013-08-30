package net.fanzhiwei.zjkfgj.user.service;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.user.domain.User;
import net.fanzhiwei.zjkfgj.user.persistence.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class UserService{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 获取主键id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long getId() {
		return userMapper.getId();
	}
	/**
	 * 登录验证
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public User login(Map<String,Object> param) {
		return userMapper.login(param);
	}
	/**
	 * 获取某个用户
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public User getUser(Map<String,Object> param) {
		return userMapper.getUser(param);
	}
	/**
	 * 获取用户列表
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<User> getUserList() {
		return userMapper.getUserList();
	}
	/**
	 * 获取用户名列表
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> getUserNameList() {
		return userMapper.getUserNameList();
	}
	/**
	 * 新增用户
	 * @param user
	 * @param param
	 */
	public void insertUser(User user,Map<String,Object> param) {
		//新增用户
		userMapper.insertUser(user);
		String roleList = (String)param.get("roleList");
		if(!"".equals(roleList)) {
			//新增用户角色关联
			insertUserRole(param);
		}
	}
	/**
	 * 编辑用户
	 * @param user
	 * @param param
	 */
	public void updateUser(User user,Map<String,Object> param) {
		//编辑用户
		userMapper.updateUser(user);
		//删除原有的用户角色关联
		userMapper.deleteUserRole(param);
		//新增用户角色关联
		insertUserRole(param);
	}
	/**
	 * 删除用户
	 * @param param
	 */
	public void deleteUser(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++) {
			param.put("id", idsArray[i]);
			param.put("user_id", idsArray[i]);
			userMapper.deleteUserRole(param);
			userMapper.deleteUser(param);
		}
	}
	/**
	 * 用户角色关联
	 * @param param
	 */
	private void insertUserRole(Map<String,Object> param) {
		String roleList = (String)param.get("roleList");
		String[] roleArray = roleList.split(",");
		for(int i=0;i<roleArray.length;i++) {
			param.put("role_id", roleArray[i]);
			userMapper.insertUserRole(param);
		}
	}
	/**
	 * 修改密码
	 * @param param
	 */
	public void changeUserPassword(Map<String,Object> param) {
		userMapper.changeUserPassword(param);
	}
}
