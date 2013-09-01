package net.fanzhiwei.zjkfgj.user.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.user.domain.User;


public interface UserMapper {
	Long getId();
	User login(Map<String,Object> param);
	User getUser(Map<String,Object> param);
	User getIsExistUser(Map<String,Object> param);
	List<User> getUserList();
	List<Map<String,Object>> getUserNameList();
	void insertUser(User user);
	void insertUserRole(Map<String,Object> param);
	void updateUser(User user);
	void updateUserRole(Map<String,Object> param);
	void deleteUser(Map<String,Object> param);
	void deleteUserRole(Map<String,Object> param);
	void changeUserPassword(Map<String,Object> param);
}
