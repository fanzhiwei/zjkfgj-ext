package net.fanzhiwei.zjkfgj.develop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.Develop1DTO;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO;
import net.fanzhiwei.zjkfgj.develop.persistence.DevelopMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class DevelopService{
	@Autowired
	private DevelopMapper developMapper;
	/**
	 * 获取某条记录
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Develop> getDevelopList(Map<String,Object> param) {
		return developMapper.getDevelopList(param);
	}
	/**
	 * 插入记录
	 * @param user
	 */
	public void insertDevelop(Develop develop) {
		developMapper.insertDevelop(develop);
	}
	/**
	 * 新增记录
	 * @param user
	 */
	public void updateDevelop(Develop develop) {
		developMapper.updateDevelop(develop);
	}
	/**
	 * 删除记录
	 * @param param
	 */
	public void deleteUser(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<idsArray.length;i++) {
			map.put("id", idsArray[i]);
			developMapper.deleteDevelop(map);
		}
	}
	
	@Transactional(readOnly = true)
	public List<Area> getArea() {
		List<Area> areaList = developMapper.getArea();
		return areaList;
	}
	
	@Transactional(readOnly = true)
	public List<Develop1DTO> selectDevelopCount1(int startMonth,int endMonth) {
		List<Develop1DTO> list = new ArrayList<Develop1DTO>();
		String recordMonth = "";
		if (startMonth < endMonth) {
			return list;
		}
		if (startMonth == endMonth) {
			recordMonth = String.valueOf(startMonth);
		} else {
			recordMonth = String.valueOf(startMonth) + "~" + String.valueOf(endMonth);
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("startMonth", startMonth);
		param.put("endMonth", endMonth);
		DevelopDTO dto = developMapper.selectDevelopCount1(param);
		if (dto.getInvestHouseSum() == null) {
			return list;
		}
		Develop1DTO dto1 = new Develop1DTO();
		dto1.setRecordMonth(recordMonth);
		dto1.setSubject("完成投资（万元）");
		dto1.setCatagory("住宅");
		dto1.setCount(dto.getInvestHouseSum());
	}
}
