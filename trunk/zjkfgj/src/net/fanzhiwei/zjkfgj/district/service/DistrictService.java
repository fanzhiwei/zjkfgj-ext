package net.fanzhiwei.zjkfgj.district.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO2;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO2;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport2_5;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport6;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport7;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO1;
import net.fanzhiwei.zjkfgj.district.persistence.DistrictMapper;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO1;

import org.springframework.beans.BeanUtils;
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
	/****************************************************************************************/
	/**
	 * 获取某条记录
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DistrictReport6> getDistrictListReport6(Map<String,Object> param) {
		return districtMapper.getDistrictListReport6(param);
	}
	/**
	 * 插入记录
	 * @param user
	 */
	public void insertDistrictReport6(DistrictReport6 report6) {
		districtMapper.insertDistrictReport6(report6);
	}
	/**
	 * 新增记录
	 * @param user
	 */
	public void updateDistrictReport6(DistrictReport6 report6) {
		districtMapper.updateDistrictReport6(report6);
	}
	/**
	 * 删除记录
	 * @param param
	 */
	public void deleteDistrictReport6(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<idsArray.length;i++) {
			map.put("id", idsArray[i]);
			districtMapper.deleteDistrictReport6(map);
		}
	}
	/****************************************************************************************/
	/**
	 * 获取某条记录
	 * @param param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<DistrictReport7> getDistrictListReport7(Map<String,Object> param) {
		return districtMapper.getDistrictListReport7(param);
	}
	/**
	 * 插入记录
	 * @param user
	 */
	public void insertDistrictReport7(DistrictReport7 report7) {
		districtMapper.insertDistrictReport7(report7);
	}
	/**
	 * 新增记录
	 * @param user
	 */
	public void updateDistrictReport7(DistrictReport7 report7) {
		districtMapper.updateDistrictReport7(report7);
	}
	/**
	 * 删除记录
	 * @param param
	 */
	public void deleteDistrictReport7(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<idsArray.length;i++) {
			map.put("id", idsArray[i]);
			districtMapper.deleteDistrictReport7(map);
		}
	}
	
/****************************************统计**********************************************/
	@Transactional(readOnly = true)
	public List<DistrictSumReportVO1> selectDistrictCount1(int startMonth,int endMonth) {
		List<DistrictSumReportVO1> list = new ArrayList<DistrictSumReportVO1>();
		String recordMonth = "";
		if (startMonth > endMonth) {
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
		List<DistrictSumReportDTO1> listDTO = districtMapper.selectDistrictCount1(param);
		if (listDTO.size() == 0 || listDTO.get(0).getHouseAreaSum() == null) {
			return list;
		}
		DistrictSumReportVO1 vo = null;
		for (DistrictSumReportDTO1 dto : listDTO) {
			vo = new DistrictSumReportVO1();
			vo.setRecordMonth(recordMonth);
			BeanUtils.copyProperties(dto,vo);
			list.add(vo);
		}
		return list;
	}
}
