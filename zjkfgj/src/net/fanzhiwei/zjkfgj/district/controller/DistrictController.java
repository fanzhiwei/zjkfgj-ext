package net.fanzhiwei.zjkfgj.district.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport2_5;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport6;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport7;
import net.fanzhiwei.zjkfgj.district.service.DistrictService;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO1;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO2;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO3;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO4;
import net.fanzhiwei.zjkfgj.user.domain.User;
import net.sf.excelutils.ExcelException;
import net.sf.excelutils.ExcelUtils;

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
	public @ResponseBody Map<String,Object> getDevelopListReport1(HttpServletRequest request,   
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
	 * @return
	 */
	@RequestMapping(value="/saveReport1",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdateReport1(DistrictReport1 vo,HttpServletRequest request,   
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
	public @ResponseBody Map<String,Object> removeReport1(HttpServletRequest request,   
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
	
/*********************************************************************************************/
	
	/**
	 * 获取列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/listReport2_5")
	public @ResponseBody Map<String,Object> getDevelopListReport2_5(HttpServletRequest request,   
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
		params.put("category",request.getParameter("category"));
		List<DistrictReport2_5> developList = districtService.getDistrictListReport2_5(params);
		
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
	
	/**
	 * 保存或更新记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveReport2_5",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdateReport2_5(DistrictReport2_5 vo,HttpServletRequest request,   
			HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		if (request.getSession().getAttribute("user") == null) {
			responseMap.put("success", "false");
			responseMap.put("info", "会话过期，请重新登录！");
			return responseMap;
		}
		User user = (User)request.getSession().getAttribute("user");
		vo.setUserId(user.getId());
		
		//用户要添加记录，以记录该月已报送，但套数为0
		if (vo.getCategory() != null && !"1".equals(vo.getCategory())) {
			if (vo.getTotalPrice().doubleValue() == 0d && vo.getArea().doubleValue() == 0d) {
				vo.setHouseNumber(0);
			}
		}
		
		try {
			if(vo.getId() != null && !"".equals(vo.getId())) {
				districtService.updateDistrictReport2_5(vo);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			else {
				districtService.insertDistrictReport2_5(vo);
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
	@RequestMapping(value="/removeReport2_5",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> removeReport2_5(HttpServletRequest request,   
			HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			districtService.deleteDistrictReport2_5(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	/*********************************************************************************************/
	
	/**
	 * 获取列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/listReport6")
	public @ResponseBody Map<String,Object> getDevelopListReport6(HttpServletRequest request,   
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
		params.put("category",request.getParameter("category"));
		List<DistrictReport6> developList = districtService.getDistrictListReport6(params);
		
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
	
	/**
	 * 保存或更新记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveReport6",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdateReport6(DistrictReport6 vo,HttpServletRequest request,   
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
		//在新增记录时，同一用户，同一年月，不得重复添加
		if(vo.getId() == null || "".equals(vo.getId())) {
			params = new HashMap<String,Object>();
			params.put("userId",user.getId());
			params.put("recordYearMonth",vo.getRecordYearMonth());
			List<DistrictReport6> currList = districtService.getDistrictListReport6(params);
			if (currList.size() > 0) {
				responseMap.put("info", "您已填写过该年月数据，请不要重复添加，或请修改原记录！");
				return responseMap;
			}
		}
		
		try {
			//编辑信息
			if(vo.getId() != null && !"".equals(vo.getId())) {
				districtService.updateDistrictReport6(vo);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增信息
			else {
				districtService.insertDistrictReport6(vo);
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
	@RequestMapping(value="/removeReport6",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> removeReport6(HttpServletRequest request,   
			HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			districtService.deleteDistrictReport6(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	/*********************************************************************************************/
	
	/**
	 * 获取列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/listReport7")
	public @ResponseBody Map<String,Object> getDevelopListReport7(HttpServletRequest request,   
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
		params.put("category",request.getParameter("category"));
		List<DistrictReport7> developList = districtService.getDistrictListReport7(params);
		
		responseMap.put("totalCount", developList.size());
		responseMap.put("rows", developList);
		return responseMap;
	}
	
	
	/**
	 * 保存或更新记录
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/saveReport7",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrUpdateReport7(DistrictReport7 vo,HttpServletRequest request,   
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
		//在新增记录时，同一用户，同一年月，不得重复添加
		if(vo.getId() == null || "".equals(vo.getId())) {
			params = new HashMap<String,Object>();
			params.put("userId",user.getId());
			params.put("recordYearMonth",vo.getRecordYearMonth());
			List<DistrictReport7> currList = districtService.getDistrictListReport7(params);
			if (currList.size() > 0) {
				responseMap.put("info", "您已填写过该年月数据，请不要重复添加，或请修改原记录！");
				return responseMap;
			}
		}
		
		try {
			//编辑信息
			if(vo.getId() != null && !"".equals(vo.getId())) {
				districtService.updateDistrictReport7(vo);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增信息
			else {
				districtService.insertDistrictReport7(vo);
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
	@RequestMapping(value="/removeReport7",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> removeReport7(HttpServletRequest request,   
			HttpServletResponse response){
		Map<String,Object> responseMap = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", ids);
		try {
			districtService.deleteDistrictReport7(param);
			responseMap.put("success", "true");
			responseMap.put("info", "删除成功！");
			return responseMap;
		}catch(Exception e) {
			e.printStackTrace();
			responseMap.put("info", e.getClass()+":"+e.getMessage());
			return responseMap;
		}
	}
	
/**************************************************统计**********************************************************/
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count1")
	public @ResponseBody Map<String,Object> selectDistrictCount1(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO1>  list = districtService.selectDistrictCount1(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count2")
	public @ResponseBody Map<String,Object> selectDistrictCount2(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO2>  list = districtService.selectDistrictCount2(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count3")
	public @ResponseBody Map<String,Object> selectDistrictCount3(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO3>  list = districtService.selectDistrictCount3(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/count4")
	public @ResponseBody Map<String,Object> selectDistrictCount4(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO4>  list = districtService.selectDistrictCount4(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		
		Map<String,Object> responseMap = new HashMap<String,Object>();
		responseMap.put("totalCount", list.size());
		responseMap.put("rows", list);
		return responseMap;
	}
	
	/**********************************************导出excel***************************************************/
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/exportShangPinXiaoShou")
	public String exportDistrictCount2(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO2>  list = districtService.selectDistrictCount2(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		ExcelUtils.addValue("list", list);

		String config = "/WEB-INF/xls/shangpinfangxiaohuizongbiao.xls";
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		try {
			ExcelUtils.export(request.getSession().getServletContext(), config,
					response.getOutputStream());
		} catch (ExcelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/exportDengJiZaiCe")
	public String exportDistrictCount3(HttpServletRequest request,   
			HttpServletResponse response){
		String startMonth = request.getParameter("startMonth");
		String endMonth = request.getParameter("endMonth");
		if (startMonth == null || "".equals(startMonth)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			startMonth = sd.format(new Date());
			endMonth = startMonth;
		}
		List<DistrictSumReportVO3>  list = districtService.selectDistrictCount3(Integer.parseInt(startMonth),Integer.parseInt(endMonth));
		ExcelUtils.addValue("list", list);

		String config = "/WEB-INF/xls/dengjizaicehuizongbiao.xls";
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		try {
			ExcelUtils.export(request.getSession().getServletContext(), config,
					response.getOutputStream());
		} catch (ExcelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}	
}
