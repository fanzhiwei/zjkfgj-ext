package net.fanzhiwei.zjkfgj.develop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.service.DevelopService;
import net.fanzhiwei.zjkfgj.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/develop")
public class DevelopController {
	@Autowired
	private DevelopService developService;
	/**
	 * 获取用户列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/lists",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getUsers(HttpServletRequest request,   
            HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId",user.getId());
//		params.put("recordYearMonth",request.getParameter("recordYearMonth"));
		params.put("recordYearMonth",201308);
		List<Develop> developList = developService.getDevelopList(params);
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
//	/**
//	 * 获取用户名列表
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value="/userNames",method=RequestMethod.GET)
//	public @ResponseBody Map<String,Object> getUserNames(HttpServletRequest request,   
//            HttpServletResponse response){
//		Map<String,Object> responseMap = new HashMap<String,Object>();
//		List<Map<String,Object>> userNameList = userService.getUserNameList();
//		responseMap.put("totalCount", userNameList.size());
//		responseMap.put("rows", userNameList);
//		return responseMap;
//	}
//	
//	/**
//	 * 保存用户信息（新增用户or编辑用户）
//	 * @param request
//	 * @param response
//	 * @param user
//	 * @return
//	 */
//	@RequestMapping(value="/save",method=RequestMethod.POST)
//	public @ResponseBody Map<String,Object> saveOrUpdate(HttpServletRequest request,   
//            HttpServletResponse response){
//		Map<String,Object> responseMap = new HashMap<String,Object>();
//		String id = request.getParameter("id");
//		String name = request.getParameter("name").trim();
//		String password = request.getParameter("password");
//		String roleList = request.getParameter("roleList");
//		try {
//			//先判断用户名是否存在
//			Map<String,Object> paramMap = new HashMap<String,Object>();
//			paramMap.put("id",id);
//			paramMap.put("name",name);
//			User isExistUser = userService.getIsExistUser(paramMap);
//			if(isExistUser != null) {
//				responseMap.put("info", "用户名已存在！"); 
//				return responseMap;
//			}
//			
//			//编辑用户信息
//			if(!"".equals(id)) {
//				Map<String,Object> param = new HashMap<String,Object>();
//				param.put("id", id);
//				User user = userService.getUser(param);
//				user.setName(name);
//				//表示修改了密码
//				if(!"".equals(password)) {
//					user.setPassword(password);
//				}
//				param.put("user_id", id);
//				param.put("roleList", roleList);
//				userService.updateUser(user, param);
//				responseMap.put("success", "true");
//				responseMap.put("info", "编辑成功！");
//			}
//			//新增用户信息
//			else {
//				User user = new User();
//				Long newId = userService.getId();
//				if(newId==null) {
//					newId = 1l;
//				}else {
//					newId = newId+1;
//				}
//				user.setId(newId);
//				user.setCreateDate(new Date());
//				user.setName(name);
//				user.setPassword(password);
//				Map<String,Object> param = new HashMap<String,Object>();
//				param.put("user_id", newId);
//				param.put("roleList", roleList);
//				userService.insertUser(user, param);
//				responseMap.put("method", "Create");
//				responseMap.put("success", "true");
//				responseMap.put("info", "新增成功！");
//			}
//			return responseMap;
//		}catch(Exception e) {
//			e.printStackTrace();
//			responseMap.put("info", e.getClass()+":"+e.getMessage());
//			return responseMap;
//		}
//	}
//	/**
//	 * 删除用户
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value="/remove",method=RequestMethod.POST)
//	public @ResponseBody Map<String,Object> remove(HttpServletRequest request,   
//            HttpServletResponse response){
//		Map<String,Object> responseMap = new HashMap<String,Object>();
//		String ids = request.getParameter("ids");
//		Map<String,Object> param = new HashMap<String,Object>();
//		param.put("ids", ids);
//		try {
//			userService.deleteUser(param);
//			responseMap.put("success", "true");
//			responseMap.put("info", "删除成功！");
//			return responseMap;
//		}catch(Exception e) {
//			e.printStackTrace();
//			responseMap.put("info", e.getClass()+":"+e.getMessage());
//			return responseMap;
//		}
//	}
}
