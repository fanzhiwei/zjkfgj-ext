package net.fanzhiwei.zjkfgj.money.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fanzhiwei.zjkfgj.money.domain.Money;
import net.fanzhiwei.zjkfgj.money.domain.MoneyList;
import net.fanzhiwei.zjkfgj.money.service.MoneyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/money")
public class MoneyController {
	@Autowired
	private MoneyService moneyService;
	
	/**
	 * 获取所有消费记录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/moneys",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getMoneys(HttpServletRequest request,   
            HttpServletResponse response){
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		Map<String,Object> responseMap = new HashMap<String,Object>();
		int moneyListCount = moneyService.getMoneyListCount();
		responseMap.put("totalCount", moneyListCount);
		Map<String,Integer> pageParam = new HashMap<String,Integer>();
		pageParam.put("start", Integer.valueOf(start));
		pageParam.put("limit", Integer.valueOf(limit));
		List<Money> moneyList = moneyService.getMoneyList(pageParam);
		responseMap.put("rows", moneyList);
		return responseMap;
	}
	
	/**
	 * 保存消费信息（新增消费记录or编辑消费记录）
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
		String subListSize = request.getParameter("subListSize");
		try {
			//编辑消费信息
			if(!"".equals(id)) {
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("money_id", id);
				param.put("id", id);
				Money money = new Money();
				money.setId(Long.valueOf(id));
				money.setCreateTime(Date.valueOf(request.getParameter("createTime")));
				money.setOperator(request.getParameter("operator"));
				money.setTotal(Double.valueOf(request.getParameter("total")));
				List<MoneyList> moneyListList = new ArrayList<MoneyList>();
				//构造消费清单List
				for(int i=0;i<Integer.valueOf(subListSize).intValue();i++) {
					MoneyList moneyList = new MoneyList();
					moneyList.setMoneyId(Long.valueOf(id));
					moneyList.setName(request.getParameter("sub_name_"+i));
					moneyList.setPrice(Double.valueOf(request.getParameter("sub_price_"+i)));
					moneyListList.add(moneyList);
				}
				moneyService.updateMoneyAndMoneyList(money, moneyListList, param);
				responseMap.put("success", "true");
				responseMap.put("info", "编辑成功！");
			}
			//新增消费信息
			else {
				Long newId = moneyService.getMoneyId();
				if(newId==null) {
					newId = 1l;
				}else {
					newId = newId+1;
				}
				List<MoneyList> moneyListList = new ArrayList<MoneyList>();
				//构造消费清单List
				for(int i=0;i<Integer.valueOf(subListSize).intValue();i++) {
					MoneyList moneyList = new MoneyList();
					moneyList.setMoneyId(newId);
					moneyList.setName(request.getParameter("sub_name_"+i));
					moneyList.setPrice(Double.valueOf(request.getParameter("sub_price_"+i)));
					moneyListList.add(moneyList);
				}
				Money money = new Money();
				money.setId(newId);
				money.setCreateTime(Date.valueOf(request.getParameter("createTime")));
				money.setOperator(request.getParameter("operator"));
				money.setTotal(Double.valueOf(request.getParameter("total")));
				moneyService.insertMoneyAndMoneyList(money, moneyListList);
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
	 * 删除消费信息
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
			moneyService.deleteMoneyAndMoneyList(param);
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
