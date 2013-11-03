package net.fanzhiwei.zjkfgj.district.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport2_5;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport6;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport7;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO1;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO2a;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO2b;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO3;
import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO4;
import net.fanzhiwei.zjkfgj.district.persistence.DistrictMapper;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO1;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO2;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO3;
import net.fanzhiwei.zjkfgj.district.vo.DistrictSumReportVO4;
import net.fanzhiwei.zjkfgj.user.domain.User;

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
	/**************************************************************************************/
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
		DistrictSumReportDTO1 dto = null;
		for (int i = 0; i< listDTO.size(); i++) {
			dto = listDTO.get(i);
			vo = new DistrictSumReportVO1();
			vo.setRecordMonth(recordMonth);
			vo.setId(i);
			BeanUtils.copyProperties(dto,vo);
			list.add(vo);
		}
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<DistrictSumReportVO2> selectDistrictCount2(int startMonth,int endMonth) {
		List<DistrictSumReportVO2> list = new ArrayList<DistrictSumReportVO2>();
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
		
		List<DistrictSumReportDTO2a> list2a = districtMapper.selectDistrictCount2a(param);//合计数,一条记录;
		List<User> allUsers =  districtMapper.getDistrictUsers();//所有要统计的用户
		DistrictSumReportVO2 vo = new DistrictSumReportVO2();
		if (list2a != null && list2a.get(0) != null && list2a.size() == 1) {
			BeanUtils.copyProperties(list2a.get(0),vo);
		}
		vo.setDistrict("合计");
		vo.setId(0);
		vo.setRecordMonth(recordMonth);
		
		//计算平均价
		if (vo.getAreaSum1().doubleValue() != 0d) {
			double d = vo.getTotalPriceSum1().doubleValue()*10000/vo.getAreaSum1().doubleValue();
			vo.setAveragePriceSum1(Double.parseDouble(String.format("%.2f", d)));
		} else {
			vo.setAveragePriceSum1(0d);
		}
		if (vo.getAreaSum2().doubleValue() != 0d) {
			double d = vo.getTotalPriceSum2().doubleValue()*10000/vo.getAreaSum2().doubleValue();
			vo.setAveragePriceSum2(Double.parseDouble(String.format("%.2f", d)));
		} else {
			vo.setAveragePriceSum2(0d);
		}
		if (vo.getAreaSum3().doubleValue() != 0d) {
			double d = vo.getTotalPriceSum3().doubleValue()*10000/vo.getAreaSum3().doubleValue();
			vo.setAveragePriceSum3(Double.parseDouble(String.format("%.2f", d)));
		} else {
			vo.setAveragePriceSum3(0d);
		}
		if (vo.getAreaSum4().doubleValue() != 0d) {
			double d = vo.getTotalPriceSum4().doubleValue()*10000/vo.getAreaSum4().doubleValue();
			vo.setAveragePriceSum4(Double.parseDouble(String.format("%.2f", d)));
		} else {
			vo.setAveragePriceSum4(0d);
		}
		
		list.add(vo);
		for (int i= 0; i< allUsers.size(); i++) {
			vo = new DistrictSumReportVO2();
			vo.setRecordMonth(recordMonth);
			vo.setId(i + 1);
			vo.setDistrict(allUsers.get(i).getOtherName());
			vo.setUserId(allUsers.get(i).getId());
			list.add(vo);
		}
		
		param.put("category", "1");
		List<DistrictSumReportDTO2b> list2b1 = districtMapper.selectDistrictCount2b(param);//得出四种，分别循环
		param.put("category", "2");
		List<DistrictSumReportDTO2b> list2b2 = districtMapper.selectDistrictCount2b(param);//得出四种，分别循环
		param.put("category", "3");
		List<DistrictSumReportDTO2b> list2b3 = districtMapper.selectDistrictCount2b(param);//得出四种，分别循环
		param.put("category", "4");
		List<DistrictSumReportDTO2b> list2b4 = districtMapper.selectDistrictCount2b(param);//得出四种，分别循环
		for (int i= 1; i< list.size(); i++) {
			for (DistrictSumReportDTO2b dto : list2b1) {
				if (list.get(i).getUserId().longValue() == dto.getUserId().longValue()) {
					list.get(i).setHouseNumberSum1(dto.getHouseNumberSum());
					list.get(i).setAreaSum1(dto.getAreaSum());
					list.get(i).setTotalPriceSum1(dto.getTotalPriceSum());
					
					if (dto.getAreaSum().doubleValue() != 0d) {
						double d = dto.getTotalPriceSum().doubleValue()*10000/dto.getAreaSum().doubleValue();
						list.get(i).setAveragePriceSum1(Double.parseDouble(String.format("%.2f", d)));
					} else {
						list.get(i).setAveragePriceSum1(0d);
					}
				}
			}
			for (DistrictSumReportDTO2b dto : list2b2) {
				if (list.get(i).getUserId().longValue() == dto.getUserId().longValue()) {
					
					list.get(i).setHouseNumberSum2(dto.getHouseNumberSum());
					list.get(i).setAreaSum2(dto.getAreaSum());
					list.get(i).setTotalPriceSum2(dto.getTotalPriceSum());
					
					if (dto.getAreaSum().doubleValue() != 0d) {
						double d = dto.getTotalPriceSum().doubleValue()*10000/dto.getAreaSum().doubleValue();
						list.get(i).setAveragePriceSum2(Double.parseDouble(String.format("%.2f", d)));
					} else {
						list.get(i).setAveragePriceSum2(0d);
					}
				}
			}
			for (DistrictSumReportDTO2b dto : list2b3) {
				if (list.get(i).getUserId().longValue() == dto.getUserId().longValue()) {
					list.get(i).setHouseNumberSum3(dto.getHouseNumberSum());
					list.get(i).setAreaSum3(dto.getAreaSum());
					list.get(i).setTotalPriceSum3(dto.getTotalPriceSum());
					
					if (dto.getAreaSum().doubleValue() != 0d) {
						double d = dto.getTotalPriceSum().doubleValue()*10000/dto.getAreaSum().doubleValue();
						list.get(i).setAveragePriceSum3(Double.parseDouble(String.format("%.2f", d)));
					} else {
						list.get(i).setAveragePriceSum3(0d);
					}
				}
			}
			for (DistrictSumReportDTO2b dto : list2b4) {
				if (list.get(i).getUserId().longValue() == dto.getUserId().longValue()) {
					list.get(i).setHouseNumberSum4(dto.getHouseNumberSum());
					list.get(i).setAreaSum4(dto.getAreaSum());
					list.get(i).setTotalPriceSum4(dto.getTotalPriceSum());
					
					if (dto.getAreaSum().doubleValue() != 0d) {
						double d = dto.getTotalPriceSum().doubleValue()*10000/dto.getAreaSum().doubleValue();
						list.get(i).setAveragePriceSum4(Double.parseDouble(String.format("%.2f", d)));
					} else {
						list.get(i).setAveragePriceSum4(0d);
					}
				}
			}
		}
		return list;
	}
	
	/**************************************************************************************/
	@Transactional(readOnly = true)
	public List<DistrictSumReportVO3> selectDistrictCount3(int startMonth,int endMonth) {
		List<DistrictSumReportVO3> list = new ArrayList<DistrictSumReportVO3>();
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
		List<DistrictSumReportDTO3> listDTO = districtMapper.selectDistrictCount3(param);
		if (listDTO.size() == 0 || listDTO.get(0).getFirstAreaSum() == null) {
			return list;
		}
		DistrictSumReportVO3 vo = null;
		DistrictSumReportDTO3 dto = null;
		for (int i = 0; i< listDTO.size(); i++) {
			dto = listDTO.get(i);
			vo = new DistrictSumReportVO3();
			vo.setRecordMonth(recordMonth);
			vo.setId(i);
			BeanUtils.copyProperties(dto,vo);
			list.add(vo);
		}
		return list;
	}	
	/**************************************************************************************/
	@Transactional(readOnly = true)
	public List<DistrictSumReportVO4> selectDistrictCount4(int startMonth,int endMonth) {
		List<DistrictSumReportVO4> list = new ArrayList<DistrictSumReportVO4>();
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
		List<DistrictSumReportDTO4> listDTO = districtMapper.selectDistrictCount4(param);
		if (listDTO.size() == 0 || listDTO.get(0).getDealAreaSum() == null) {
			return list;
		}
		DistrictSumReportVO4 vo = null;
		DistrictSumReportDTO4 dto = null;
		for (int i = 0; i< listDTO.size(); i++) {
			dto = listDTO.get(i);
			vo = new DistrictSumReportVO4();
			vo.setRecordMonth(recordMonth);
			vo.setId(i);
			BeanUtils.copyProperties(dto,vo);
			
			if (dto.getDealAreaSum().doubleValue() != 0d) {
				double d = dto.getTotalPriceSum().doubleValue()*10000/dto.getDealAreaSum().doubleValue();
				vo.setAveragePriceSum(Double.parseDouble(String.format("%.2f", d)));
			} else {
				vo.setAveragePriceSum(0d);
			}
			
			list.add(vo);
		}
		return list;
	}	
}
