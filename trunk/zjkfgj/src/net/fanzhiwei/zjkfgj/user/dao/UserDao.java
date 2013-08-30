package net.fanzhiwei.zjkfgj.user.dao;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.user.domain.User;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


@Component
public class UserDao extends SqlSessionDaoSupport {
	public Long getId() {
		return (Long)getSqlSession().selectOne("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.getId");
	}
	public User login(Map<String,Object> param) {
		return (User)getSqlSession().selectOne("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.login",param);
	}
	public User getUser(Map<String,Object> param) {
		return (User)getSqlSession().selectOne("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.getUser",param);
	}
	public List<User> getUserList() {
		return getSqlSession().selectList("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.getUserList");
	}
	public void insertUser(User user) {
		getSqlSession().insert("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.insertUser", user);
	}
	public void insertUserRole(Map<String,Object> param) {
		getSqlSession().insert("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.insertUserRole", param);
	}
	public void updateUser(User user) {
		getSqlSession().update("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.updateUser", user);
	}
	public void updateUserRole(Map<String,Object> param) {
		getSqlSession().update("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.updateUserRole", param);
	}
	public void deleteUser(Map<String,Object> param) {
		getSqlSession().delete("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.deleteUser", param);
	}
	public void deleteUserRole(Map<String,Object> param) {
		getSqlSession().delete("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.deleteUserRole", param);
	}
	public void changeUserPassword(Map<String,Object> param) {
		getSqlSession().update("net.fanzhiwei.zjkfgj.user.persistence.UserMapper.changeUserPassword", param);
	}
}
