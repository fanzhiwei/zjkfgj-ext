package net.fanzhiwei.zjkfgj.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.fanzhiwei.zjkfgj.menu.domain.Menu;
import net.fanzhiwei.zjkfgj.menu.service.MenuService;
import net.fanzhiwei.zjkfgj.user.domain.User;
import net.fanzhiwei.zjkfgj.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> loginCheck(HttpServletRequest request,   
            HttpServletResponse response){
		//spring会利用jackson自动将返回值封装成JSON对象
		Map<String,String> responseMap = new HashMap<String,String>();
		String captcha = request.getParameter("captcha");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String vcode = (String)request.getSession().getAttribute("vcode");
		if(vcode==null || !captcha.equals(vcode)) {
			responseMap.put("success", "false");
			responseMap.put("info", "验证码错误！");
			return responseMap;
		}
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("name", name);
			param.put("password", password);
			User user = userService.login(param);
			if(user!=null) {
				responseMap.put("success", "true");
				responseMap.put("info", "登录成功！");
				request.getSession().setAttribute("user", user); 
				String welcomeName = user.getOtherName() == null ? user.getName() : user.getOtherName();
				request.getSession().setAttribute("loginUserName", welcomeName); 
				return responseMap;
			}else {
				responseMap.put("success", "false");
				responseMap.put("info", "用户名或密码错误！");
				return responseMap;
			}
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	
	/**
	 * 获取所有菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/menus",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getMenus(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute("user") == null) {
			responseMap.put("success", "false");
			responseMap.put("info", "会话过期，请重新登录！");
			return responseMap;
		}
		User user = (User)request.getSession().getAttribute("user");
		List<Menu> list = menuService.getMenuListByUserId(user.getId());
		responseMap.put("success", "true");
		responseMap.put("data", list);
		return responseMap;
	}
	
	/**
	 * 获取用户列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getUsers(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		List<User> userList = userService.getUserList();
		responseMap.put("totalCount", userList.size());
		responseMap.put("rows", userList);
		return responseMap;
	}
	
	/**
	 * 获取用户名列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/userNames",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getUserNames(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		List<Map<String,Object>> userNameList = userService.getUserNameList();
		responseMap.put("totalCount", userNameList.size());
		responseMap.put("rows", userNameList);
		return responseMap;
	}
	
	/**
	 * 保存用户信息（新增用户or编辑用户）
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
		String name = request.getParameter("name").trim();
		String otherName = request.getParameter("otherName").trim();
		String userType = request.getParameter("userType").trim();
		String password = request.getParameter("password");
		String roleList = request.getParameter("roleList");
		try {
			//先判断用户名是否存在
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("id",id);
			paramMap.put("name",name);
			paramMap.put("otherName",otherName);
			paramMap.put("userType",userType);
			User isExistUser = userService.getIsExistUser(paramMap);
			if(isExistUser != null) {
				responseMap.put("info", "帐号或用户名称已存在！"); 
				return responseMap;
			}
			
			//编辑用户信息
			if(!"".equals(id)) {
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("id", id);
				User user = userService.getUser(param);
				user.setName(name);
				user.setOtherName(otherName);
				//表示修改了密码
				if(!"".equals(password)) {
					user.setPassword(password);
				}
				param.put("user_id", id);
				param.put("roleList", roleList);
				userService.updateUser(user, param);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增用户信息
			else {
				User user = new User();
				Long newId = userService.getId();
				if(newId==null) {
					newId = 1l;
				}else {
					newId = newId+1;
				}
				user.setId(newId);
				user.setCreateDate(new Date());
				user.setName(name);
				user.setOtherName(otherName);
				user.setUserType(Integer.parseInt(userType));
				user.setPassword(password);
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("user_id", newId);
				param.put("roleList", roleList);
				userService.insertUser(user, param);
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
	 * 删除用户
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
			userService.deleteUser(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> changePassword(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute("user") == null) {
			responseMap.put("success", "false");
			responseMap.put("info", "会话过期，请重新登录！");
			return responseMap;
		}
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		User user =(User)request.getSession().getAttribute("user");
		try {
			//验证通过，允许修改密码
			if(oldPassword.equals(user.getPassword())) {
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("id", user.getId());
				param.put("newPassword", newPassword);
				userService.changeUserPassword(param);
				user.setPassword(newPassword);
				//更新session中的user密码信息
				request.getSession().setAttribute("user", user);
				responseMap.put("success", "true");
				responseMap.put("info", "修改密码成功！");
			}else {
				responseMap.put("success", "false");
				responseMap.put("info", "原密码错误！");
			}
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
}
