package net.fanzhiwei.zjkfgj.district.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO1;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO2;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO3;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO4;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO5;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO6;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO7;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO8;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO9;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.service.DistrictService;
import net.fanzhiwei.zjkfgj.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/district")
public class DistrictController {
	@Autowired
	private DistrictService districtService;
	/**
	 * 获取列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/listReport1")
	public @ResponseBody Map<String,Object> getDevelopList(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute("user") == null) {
			responseMap.put("success", "false");
			responseMap.put("info", "会话过期，请重新登录！");
			return responseMap;
		}
		String recordYearMonth = request.getParameter("recordYearMonth");
		if (recordYearMonth == null || "".equals(recordYearMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			recordYearMonth = sd.format(new Date());
		}
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId",user.getId());
		params.put("recordYearMonth",recordYearMonth);
//		params.put("recordYearMonth",201308);
		List<DistrictReport1> developList = districtService.getDistrictListReport1(params);
		
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
	
	/**
	 * 保存或更新记录
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/saveReport1",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdate(DistrictReport1 vo,HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute("user") == null) {
			responseMap.put("success", "false");
			responseMap.put("info", "会话过期，请重新登录！");
			return responseMap;
		}
		Map<String,Object> params = null;
		User user = (User)request.getSession().getAttribute("user");
		vo.setUserId(user.getId());
		//在新增记录时，同一区县，同一用户，同一年月，不得重复添加
//		if(vo.getId() == null || "".equals(vo.getId())) {
//			params = new HashMap<String,Object>();
//			params.put("userId",user.getId());
//			params.put("recordYearMonth",vo.getRecordYearMonth());
//			List<DistrictReport1> currList = districtService.getDistrictListReport1(params);
//			if (currList.size() > 0) {
//				responseMap.put("info", "您已填写过该地区该年月数据，请不要重复添加，或请修改原记录！");
//				return responseMap;
//			}
//		}
		
		try {
			//编辑用户信息
			if(vo.getId() != null && !"".equals(vo.getId())) {
				districtService.updateDistrictReport1(vo);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增用户信息
			else {
				districtService.insertDistrictReport1(vo);
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
	 * 删除记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/removeReport1",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> remove(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			districtService.deleteDistrictReport1(param);
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
