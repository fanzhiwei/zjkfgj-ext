package net.fanzhiwei.zjkfgj.role.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.role.domain.Role;


public interface RoleMapper {
	Long getId();
	Role getRole(Map<String,Object> param);
	List<Role> getRoleList();
	List<Role> getRoleMenuList();
	void insertRole(Role role);
	void insertRoleMenu(Map<String,Object> param);
	void updateRole(Role role);
	void updateRoleMenu(Map<String,Object> param);
	void deleteRole(Map<String,Object> param);
	void deleteRoleMenu(Map<String,Object> param);
}
