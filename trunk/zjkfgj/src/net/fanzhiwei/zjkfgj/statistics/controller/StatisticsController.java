package net.fanzhiwei.zjkfgj.statistics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.statistics.dto.UserRecordStatistics;
import net.fanzhiwei.zjkfgj.statistics.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value="/dev1")
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
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordYearMonth",recordYearMonth);
		List<UserRecordStatistics> userRecordList = statisticsService.getDevUserStatistics1(params);
		
		responseMap.put("totalCount", userRecordList.size());
		responseMap.put("rows", userRecordList);
		return responseMap;
	}
	
	@RequestMapping(value="/dis1")
	public @ResponseBody Map<String,Object> getDisUserStatistics1(HttpServletRequest request,   
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
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordYearMonth",recordYearMonth);
		List<UserRecordStatistics> userRecordList = statisticsService.getDisUserStatistics1(params);
		
		responseMap.put("totalCount", userRecordList.size());
		responseMap.put("rows", userRecordList);
		return responseMap;
	}
	
	@RequestMapping(value="/dis2_5")
	public @ResponseBody Map<String,Object> getDisUserStatistics2_5(HttpServletRequest request,   
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
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordYearMonth",recordYearMonth);
		params.put("category",request.getParameter("category"));
		List<UserRecordStatistics> userRecordList = statisticsService.getDisUserStatistics2_5(params);
		
		responseMap.put("totalCount", userRecordList.size());
		responseMap.put("rows", userRecordList);
		return responseMap;
	}
	
	@RequestMapping(value="/dis6")
	public @ResponseBody Map<String,Object> getDisUserStatistics6(HttpServletRequest request,   
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
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordYearMonth",recordYearMonth);
		List<UserRecordStatistics> userRecordList = statisticsService.getDisUserStatistics6(params);
		
		responseMap.put("totalCount", userRecordList.size());
		responseMap.put("rows", userRecordList);
		return responseMap;
	}
	
	@RequestMapping(value="/dis7")
	public @ResponseBody Map<String,Object> getDisUserStatistics7(HttpServletRequest request,   
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
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordYearMonth",recordYearMonth);
		List<UserRecordStatistics> userRecordList = statisticsService.getDisUserStatistics7(params);
		
		responseMap.put("totalCount", userRecordList.size());
		responseMap.put("rows", userRecordList);
		return responseMap;
	}
}
