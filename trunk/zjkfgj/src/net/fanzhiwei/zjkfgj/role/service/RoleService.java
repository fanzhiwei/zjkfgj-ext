package net.fanzhiwei.zjkfgj.role.service;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.role.domain.Role;
import net.fanzhiwei.zjkfgj.role.persistence.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 获取主键id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long getId() {
		return roleMapper.getId();
	}
	
	/**
	 * 获取角色
	 * @return
	 */
	@Transactional(readOnly = true)
	public Role getRole(Map<String,Object> param) {
		return roleMapper.getRole(param);
	}
	
	/**
	 * 获取角色列表
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Role> getRoleList() {
		return roleMapper.getRoleList();
	}
	/**
	 * 获取角色菜单列表
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Role> getRoleMenuList() {
		return roleMapper.getRoleMenuList();
	}
	/**
	 * 新增角色
	 * @param user
	 * @param param
	 */
	public void insertRole(Role role,Map<String,Object> param) {
		//新增角色
		roleMapper.insertRole(role);
		String menuList = (String)param.get("menuList");
		if(!"".equals(menuList)) {
			//新增角色菜单关联
			insertRoleMenu(param);
		}
	}
	/**
	 * 编辑角色
	 * @param user
	 * @param param
	 */
	public void updateRole(Role role,Map<String,Object> param) {
		//编辑角色
		roleMapper.updateRole(role);
		//删除原有的角色菜单关联
		roleMapper.deleteRoleMenu(param);
		//新增角色菜单关联
		insertRoleMenu(param);
	}
	/**
	 * 删除角色
	 * @param param
	 */
	public void deleteRole(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++) {
			param.put("id", idsArray[i]);
			param.put("role_id", idsArray[i]);
			roleMapper.deleteRole(param);
			roleMapper.deleteRoleMenu(param);
		}
	}
	/**
	 * 角色菜单关联
	 * @param param
	 */
	private void insertRoleMenu(Map<String,Object> param) {
		String menuList = (String)param.get("menuList");
		String[] menuArray = menuList.split(",");
		for(int i=0;i<menuArray.length;i++) {
			param.put("menu_id", menuArray[i]);
			roleMapper.insertRoleMenu(param);
		}
	}
}
