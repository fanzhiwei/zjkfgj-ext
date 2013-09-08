package net.fanzhiwei.zjkfgj.develop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO1;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO2;
import net.fanzhiwei.zjkfgj.develop.persistence.DevelopMapper;
import net.fanzhiwei.zjkfgj.develop.vo.DevelopVO2;

import org.springframework.beans.BeanUtils;
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
	public List<DevelopDTO1> selectDevelopCount1(int startMonth,int endMonth) {
		int i = 0;
		List<DevelopDTO1> list = new ArrayList<DevelopDTO1>();
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
		DevelopDTO dto = developMapper.selectDevelopCount1(param);
		if (dto == null || dto.getInvestHouseSum() == null) {
			return list;
		}
		DevelopDTO1 dto1 = new DevelopDTO1();
		dto1.setId(i++);
		dto1.setRecordMonth(recordMonth);
		dto1.setSubject("完成投资（万元）");
		dto1.setSubTotal(dto.getInvestHouseSum() + dto.getInvestBusinessSum() + dto.getInvestOfficeSum() + dto.getInvestOtherSum());
		dto1.setCatagory("住宅");
		dto1.setSum(dto.getInvestHouseSum());
		list.add(dto1);
		
		DevelopDTO1 dto2 = new DevelopDTO1();
		dto2.setId(i++);
		dto2.setCatagory("商业营业房");
		dto2.setSum(dto.getInvestBusinessSum());
		list.add(dto2);
		
		DevelopDTO1 dto3 = new DevelopDTO1();
		dto3.setId(i++);
		dto3.setCatagory("办公房");
		dto3.setSum(dto.getInvestOfficeSum());
		list.add(dto3);
		
		DevelopDTO1 dto4 = new DevelopDTO1();
		dto4.setId(i++);
		dto4.setCatagory("其他房");
		dto4.setSum(dto.getInvestOtherSum());
		list.add(dto4);
		
		DevelopDTO1 dto5 = new DevelopDTO1();
		dto5.setId(i++);
		dto5.setRecordMonth(recordMonth);
		dto5.setSubject("资金来源总数（万元）");
		dto5.setSubTotal(dto.getFinancialSourcingInlandSum() + dto.getFinancialSourcingForeignSum() + dto.getFinancialSourcingSelfSum() + dto.getFinancialSourcingOtherSum());
		dto5.setCatagory("国内筹款");
		dto5.setSum(dto.getFinancialSourcingInlandSum());
		list.add(dto5);
		
		DevelopDTO1 dto6 = new DevelopDTO1();
		dto6.setId(i++);
		dto6.setCatagory("利用外资");
		dto6.setSum(dto.getFinancialSourcingForeignSum());
		list.add(dto6);
		
		DevelopDTO1 dto7 = new DevelopDTO1();
		dto7.setId(i++);
		dto7.setCatagory("自筹资金");
		dto7.setSum(dto.getFinancialSourcingSelfSum());
		list.add(dto7);
		
		DevelopDTO1 dto8 = new DevelopDTO1();
		dto8.setId(i++);
		dto8.setCatagory("其他资金");
		dto8.setSum(dto.getFinancialSourcingOtherSum());
		list.add(dto8);
		if (startMonth == endMonth) {
			DevelopDTO1 dto9 = new DevelopDTO1();
			dto9.setId(i++);
			dto9.setRecordMonth(recordMonth);
			dto9.setSubject("施工面积(㎡)");
			dto9.setSubTotal(dto.getWorkingAreaHouseSum() + dto.getWorkingAreaBusinessSum() + dto.getWorkingAreaOfficeSum() + dto.getWorkingAreaOtherSum());
			dto9.setCatagory("住宅");
			dto9.setSum(dto.getWorkingAreaHouseSum());
			list.add(dto9);
			
			DevelopDTO1 dto10 = new DevelopDTO1();
			dto10.setId(i++);
			dto10.setCatagory("商业营业房");
			dto10.setSum(dto.getWorkingAreaBusinessSum());
			list.add(dto10);
			
			DevelopDTO1 dto11 = new DevelopDTO1();
			dto11.setId(i++);
			dto11.setCatagory("办公房");
			dto11.setSum(dto.getWorkingAreaOfficeSum());
			list.add(dto11);
			
			DevelopDTO1 dto12 = new DevelopDTO1();
			dto12.setId(i++);
			dto12.setCatagory("其他房");
			dto12.setSum(dto.getWorkingAreaOtherSum());
			list.add(dto12);
		}		
		
		DevelopDTO1 dto13 = new DevelopDTO1();
		dto13.setId(i++);
		dto13.setRecordMonth(recordMonth);
		dto13.setSubject("新开工面积(㎡)");
		dto13.setSubTotal(dto.getNewAreaHouseSum() + dto.getNewAreaBusinessSum() + dto.getNewAreaOfficeSum() + dto.getNewAreaOtherSum());
		dto13.setCatagory("住宅");
		dto13.setSum(dto.getNewAreaHouseSum());
		list.add(dto13);
		
		DevelopDTO1 dto14 = new DevelopDTO1();
		dto14.setId(i++);
		dto14.setCatagory("商业营业房");
		dto14.setSum(dto.getNewAreaBusinessSum());
		list.add(dto14);
		
		DevelopDTO1 dto15 = new DevelopDTO1();
		dto15.setId(i++);
		dto15.setCatagory("办公房");
		dto15.setSum(dto.getNewAreaOfficeSum());
		list.add(dto15);
		
		DevelopDTO1 dto16 = new DevelopDTO1();
		dto16.setId(i++);
		dto16.setCatagory("其他房");
		dto16.setSum(dto.getNewAreaOtherSum());
		list.add(dto16);
		
		DevelopDTO1 dto17 = new DevelopDTO1();
		dto17.setId(i++);
		dto17.setRecordMonth(recordMonth);
		dto17.setSubject("竣工面积(㎡)");
		dto17.setSubTotal(dto.getCompleteAreaHouseSum() + dto.getCompleteAreaBusinessSum() + dto.getCompleteAreaOfficeSum() + dto.getCompleteAreaOtherSum());
		dto17.setCatagory("住宅");
		dto17.setSum(dto.getCompleteAreaHouseSum());
		list.add(dto17);
		
		DevelopDTO1 dto18 = new DevelopDTO1();
		dto18.setId(i++);
		dto18.setCatagory("商业营业房");
		dto18.setSum(dto.getCompleteAreaBusinessSum());
		list.add(dto18);
		
		DevelopDTO1 dto19 = new DevelopDTO1();
		dto19.setId(i++);
		dto19.setCatagory("办公房");
		dto19.setSum(dto.getCompleteAreaOfficeSum());
		list.add(dto19);
		
		DevelopDTO1 dto20 = new DevelopDTO1();
		dto20.setId(i++);
		dto20.setCatagory("其他房");
		dto20.setSum(dto.getCompleteAreaOtherSum());
		list.add(dto20);
		
		DevelopDTO1 dto21 = new DevelopDTO1();
		dto21.setId(i++);
		dto21.setRecordMonth(recordMonth);
		dto21.setSubject("销售面积(㎡)");
		dto21.setSubTotal(dto.getSaledAreaHouseSum() + dto.getSaledAreaBusinessSum() + dto.getSaledAreaOfficeSum() + dto.getSaledAreaOtherSum());
		dto21.setCatagory("住宅");
		dto21.setSum(dto.getSaledAreaHouseSum());
		list.add(dto21);
		
		DevelopDTO1 dto22 = new DevelopDTO1();
		dto22.setId(i++);
		dto22.setCatagory("商业营业房");
		dto22.setSum(dto.getSaledAreaBusinessSum());
		list.add(dto22);
		
		DevelopDTO1 dto23 = new DevelopDTO1();
		dto23.setId(i++);
		dto23.setCatagory("办公房");
		dto23.setSum(dto.getSaledAreaOfficeSum());
		list.add(dto23);
		
		DevelopDTO1 dto24 = new DevelopDTO1();
		dto24.setId(i++);
		dto24.setCatagory("其他房");
		dto24.setSum(dto.getSaledAreaOtherSum());
		list.add(dto24);
		
		DevelopDTO1 dto25 = new DevelopDTO1();
		dto25.setId(i++);
		dto25.setRecordMonth(recordMonth);
		dto25.setSubject("销售收入（万元）");
		dto25.setSubTotal(dto.getIncomingHouseSum() + dto.getIncomingBusinessSum() + dto.getIncomingOfficeSum() + dto.getIncomingOtherSum());
		dto25.setCatagory("住宅");
		dto25.setSum(dto.getIncomingHouseSum());
		list.add(dto25);
		
		DevelopDTO1 dto26 = new DevelopDTO1();
		dto26.setId(i++);
		dto26.setCatagory("商业营业房");
		dto26.setSum(dto.getIncomingBusinessSum());
		list.add(dto26);
		
		DevelopDTO1 dto27 = new DevelopDTO1();
		dto27.setId(i++);
		dto27.setCatagory("办公房");
		dto27.setSum(dto.getIncomingOfficeSum());
		list.add(dto27);
		
		DevelopDTO1 dto28 = new DevelopDTO1();
		dto28.setId(i++);
		dto28.setCatagory("其他房");
		dto28.setSum(dto.getIncomingOtherSum());
		list.add(dto28);
		
		if (startMonth == endMonth) {
			DevelopDTO1 dto29 = new DevelopDTO1();
			dto29.setId(i++);
			dto29.setRecordMonth(recordMonth);
			dto29.setSubject("待售面积(㎡)");
			dto29.setSubTotal(dto.getOnsaleAreaHouseSum() + dto.getOnsaleAreaBusinessSum() + dto.getOnsaleAreaOfficeSum() + dto.getOnsaleAreaOtherSum());
			dto29.setCatagory("住宅");
			dto29.setSum(dto.getOnsaleAreaHouseSum());
			list.add(dto29);
			
			DevelopDTO1 dto30 = new DevelopDTO1();
			dto30.setId(i++);
			dto30.setCatagory("商业营业房");
			dto30.setSum(dto.getOnsaleAreaBusinessSum());
			list.add(dto30);
			
			DevelopDTO1 dto31 = new DevelopDTO1();
			dto31.setId(i++);
			dto31.setCatagory("办公房");
			dto31.setSum(dto.getOnsaleAreaOfficeSum());
			list.add(dto31);
			
			DevelopDTO1 dto32 = new DevelopDTO1();
			dto32.setId(i++);
			dto32.setCatagory("其他房");
			dto32.setSum(dto.getOnsaleAreaOtherSum());
			list.add(dto32);
		}		
		
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<DevelopVO2> selectDevelopCount2(int startMonth,int endMonth) {
		List<DevelopVO2> list = new ArrayList<DevelopVO2>();
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
		List<DevelopDTO2> listDTO = developMapper.selectDevelopCount2(param);
		if (listDTO.size() == 0 || listDTO.get(0).getInvestHouseSum() == null) {
			return list;
		}
		DevelopVO2 vo = null;
		for (DevelopDTO2 dto : listDTO) {
			vo = new DevelopVO2();
			vo.setRecordMonth(recordMonth);
			BeanUtils.copyProperties(dto,vo);
			list.add(vo);
		}
		return list;
	}
}
