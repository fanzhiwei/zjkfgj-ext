package net.fanzhiwei.zjkfgj.develop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO1;
import net.fanzhiwei.zjkfgj.develop.service.DevelopService;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO2;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO3;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO4;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO5;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO6;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO7;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO8;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO9;
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
	 * 获取条件开发情况列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/lists")
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
		List<Develop> developList = developService.getDevelopList(params);
		
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
	/**
	 * 获取区县下拉菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/area",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getArea(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		List<Area> areaList = developService.getArea();
		responseMap.put("totalCount", areaList.size());
		responseMap.put("rows", areaList);
		return responseMap;
	}
	
	/**
	 * 保存或更新记录
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdate(DevelopVO vo,HttpServletRequest request,   
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
		if(vo.getId() == null || "".equals(vo.getId())) {
			params = new HashMap<String,Object>();
			params.put("userId",user.getId());
			params.put("areaId",vo.getAreaId());
			params.put("recordYearMonth",vo.getRecordYearMonth());
			List<Develop> currList = developService.getDevelopList(params);
			if (currList.size() > 0) {
				responseMap.put("info", "您已填写过该地区该年月数据，请不要重复添加，或请修改原记录！");
				return responseMap;
			}
		}
		
		//取消限制条件
//		params = new HashMap<String,Object>();
//		params.put("userId",user.getId());
//		params.put("areaId",vo.getAreaId());
//		params.put("recordYearMonth",getLastMonth(vo.getRecordYearMonth()));
//		List<Develop> developList = developService.getDevelopList(params);
//		if (developList.size() != 0) {
//			Develop lastDevelop = developList.get(0);
//			if (vo.getWorkingAreaHouse() - lastDevelop.getWorkingAreaHouse() != vo.getNewAreaHouse() - vo.getCompleteAreaHouse()) {
//				responseMap.put("info", "住宅不满足条件：本月施工面积 = 上个月施工面积 +本月新开工面积 - 本月竣工面积");
//				return responseMap;
//			}
//			if (vo.getWorkingAreaBusiness() - lastDevelop.getWorkingAreaBusiness() != vo.getNewAreaBusiness() - vo.getCompleteAreaBusiness()) {
//				responseMap.put("info", "商业房不满足条件：本月施工面积 = 上个月施工面积 +本月新开工面积 - 本月竣工面积");
//				return responseMap;
//			}
//			if (vo.getWorkingAreaOffice() - lastDevelop.getWorkingAreaOffice() != vo.getNewAreaOffice() - vo.getCompleteAreaOffice()) {
//				responseMap.put("info", "办公房不满足条件：本月施工面积 = 上个月施工面积 +本月新开工面积 - 本月竣工面积");
//				return responseMap;
//			}
//			if (vo.getWorkingAreaOther() - lastDevelop.getWorkingAreaOther() != vo.getNewAreaOther() - vo.getCompleteAreaOther()) {
//				responseMap.put("info", "其它房不满足条件：本月施工面积 = 上个月施工面积 +本月新开工面积 - 本月竣工面积");
//				return responseMap;
//			}
//		}
		
		try {
			//编辑用户信息
			if(vo.getId() != null && !"".equals(vo.getId())) {
				developService.updateDevelop(vo);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增用户信息
			else {
				developService.insertDevelop(vo);
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
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> remove(HttpServletRequest request,   
            HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			developService.deleteUser(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}

	private Integer getLastMonth(Integer recordYearMonth) {
		String str = recordYearMonth.toString();
		if (str.endsWith("01")) {
			str = str.substring(0, 4);
			int i = Integer.parseInt(str) - 1;
			str = i + "12";
			return Integer.parseInt(str);
		} else {
			return recordYearMonth.intValue() - 1;
		}
	}
	
	/**
	 * 汇总表1列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count1")
	public @ResponseBody Map<String,Object> getDevelopCount1(HttpServletRequest request,   
            HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopDTO1>  list = developService.selectDevelopCount1(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表2列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count2")
	public @ResponseBody Map<String,Object> getDevelopCount2(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO2>  list = developService.selectDevelopCount2(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表3列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count3")
	public @ResponseBody Map<String,Object> getDevelopCount3(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO3>  list = developService.selectDevelopCount3(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表4列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count4")
	public @ResponseBody Map<String,Object> getDevelopCount4(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO4>  list = developService.selectDevelopCount4(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表5列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count5")
	public @ResponseBody Map<String,Object> getDevelopCount5(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO5>  list = developService.selectDevelopCount5(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表6列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count6")
	public @ResponseBody Map<String,Object> getDevelopCount6(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO6>  list = developService.selectDevelopCount6(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表7列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count7")
	public @ResponseBody Map<String,Object> getDevelopCount7(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO7>  list = developService.selectDevelopCount7(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表8列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count8")
	public @ResponseBody Map<String,Object> getDevelopCount8(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO8>  list = developService.selectDevelopCount8(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * 汇总表9列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count9")
	public @ResponseBody Map<String,Object> getDevelopCount9(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DevelopVO9>  list = developService.selectDevelopCount9(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
}
