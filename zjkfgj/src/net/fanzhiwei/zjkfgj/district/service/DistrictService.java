package net.fanzhiwei.zjkfgj.district.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport2_5;
import net.fanzhiwei.zjkfgj.district.persistence.DistrictMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class DistrictService{
	@Autowired
	private DistrictMapper districtMapper;
	/**
	 * 获取某条记录
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DistrictReport1> getDistrictListReport1(Map<String,Object> param) {
		return districtMapper.getDistrictListReport1(param);
	}
	/**
	 * 插入记录
	 * @param user
	 */
	public void insertDistrictReport1(DistrictReport1 report1) {
		districtMapper.insertDistrictReport1(report1);
	}
	/**
	 * 新增记录
	 * @param user
	 */
	public void updateDistrictReport1(DistrictReport1 report1) {
		districtMapper.updateDistrictReport1(report1);
	}
	/**
	 * 删除记录
	 * @param param
	 */
	public void deleteDistrictReport1(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<idsArray.length;i++) {
			map.put("id", idsArray[i]);
			districtMapper.deleteDistrictReport1(map);
		}
	}
/****************************************************************************************/
	/**
	 * 获取某条记录
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DistrictReport2_5> getDistrictListReport2_5(Map<String,Object> param) {
		return districtMapper.getDistrictListReport2_5(param);
	}
	/**
	 * 插入记录
	 * @param user
	 */
	public void insertDistrictReport2_5(DistrictReport2_5 report2_5) {
		districtMapper.insertDistrictReport2_5(report2_5);
	}
	/**
	 * 新增记录
	 * @param user
	 */
	public void updateDistrictReport2_5(DistrictReport2_5 report2_5) {
		districtMapper.updateDistrictReport2_5(report2_5);
	}
	/**
	 * 删除记录
	 * @param param
	 */
	public void deleteDistrictReport2_5(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<idsArray.length;i++) {
			map.put("id", idsArray[i]);
			districtMapper.deleteDistrictReport2_5(map);
		}
	}
}
