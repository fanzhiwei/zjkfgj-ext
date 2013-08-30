package net.fanzhiwei.zjkfgj.role.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.role.domain.Role;
import net.fanzhiwei.zjkfgj.role.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/roleList",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getRoleList(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		List<Role> roleList = roleService.getRoleList();
		responseMap.put("totalCount", roleList.size());
		responseMap.put("rows", roleList);
		return responseMap;
	}
	/**
	 * 获取角色菜单关联列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/roles",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getRoleMenuList(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		List<Role> roleMenuList = roleService.getRoleMenuList();
		responseMap.put("totalCount", roleMenuList.size());
		responseMap.put("rows", roleMenuList);
		return responseMap;
	}
	/**
	 * 保存角色信息（新增角色or编辑角色）
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdate(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String menuList = request.getParameter("menuList");
		try {
			//编辑角色信息
			if(!"".equals(id)) {
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("id", id);
				Role role = roleService.getRole(param);
				role.setName(name);
				role.setDescription(description);
				param.put("role_id", id);
				param.put("menuList", menuList);
				roleService.updateRole(role, param);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增角色信息
			else {
				Role role = new Role();
				Long newId = roleService.getId();
				if(newId==null) {
					newId = 1l;
				}else {
					newId = newId+1;
				}
				role.setId(newId);
				role.setName(name);
				role.setDescription(description);
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("role_id", newId);
				param.put("menuList", menuList);
				roleService.insertRole(role, param);
				responseMap.put("method", "Create");
				responseMap.put("success", "true");
				responseMap.put("info", "新增成功！");
			}
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	/**
	 * 删除角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> remove(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			roleService.deleteRole(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
}
