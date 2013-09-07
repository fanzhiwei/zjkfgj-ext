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
		dto1.setSubTotal(dto.getInvestHouseSum() + dto.getInvestBusinessSum() + dto.getInvestOfficeSum() + dto.getInvestOtherSum());
		dto1.setCatagory("住宅");
		dto1.setSum(dto.getInvestHouseSum());
		list.add(dto1);
		
		Develop1DTO dto2 = new Develop1DTO();
		dto2.setCatagory("商业营业房");
		dto2.setSum(dto.getInvestBusinessSum());
		list.add(dto2);
		
		Develop1DTO dto3 = new Develop1DTO();
		dto3.setCatagory("办公房");
		dto3.setSum(dto.getInvestOfficeSum());
		list.add(dto3);
		
		Develop1DTO dto4 = new Develop1DTO();
		dto4.setCatagory("其他房");
		dto4.setSum(dto.getInvestOtherSum());
		list.add(dto4);
		
		Develop1DTO dto5 = new Develop1DTO();
		dto5.setRecordMonth(recordMonth);
		dto5.setSubject("资金来源总数（万元）");
		dto5.setSubTotal(dto.getFinancialSourcingInlandSum() + dto.getFinancialSourcingForeignSum() + dto.getFinancialSourcingSelfSum() + dto.getFinancialSourcingOtherSum());
		dto5.setCatagory("国内筹款");
		dto5.setSum(dto.getFinancialSourcingInlandSum());
		list.add(dto5);
		
		Develop1DTO dto6 = new Develop1DTO();
		dto6.setCatagory("利用外资");
		dto6.setSum(dto.getFinancialSourcingForeignSum());
		list.add(dto6);
		
		Develop1DTO dto7 = new Develop1DTO();
		dto7.setCatagory("自筹资金");
		dto7.setSum(dto.getFinancialSourcingSelfSum());
		list.add(dto7);
		
		Develop1DTO dto8 = new Develop1DTO();
		dto8.setCatagory("其他资金");
		dto8.setSum(dto.getFinancialSourcingOtherSum());
		list.add(dto8);
		
		Develop1DTO dto9 = new Develop1DTO();
		dto9.setRecordMonth(recordMonth);
		dto9.setSubject("施工面积(㎡)");
		dto9.setSubTotal(dto.getWorkingAreaHouseSum() + dto.getWorkingAreaBusinessSum() + dto.getWorkingAreaOfficeSum() + dto.getWorkingAreaOtherSum());
		dto9.setCatagory("住宅");
		dto9.setSum(dto.getWorkingAreaHouseSum());
		list.add(dto9);
		
		Develop1DTO dto10 = new Develop1DTO();
		dto10.setCatagory("商业营业房");
		dto10.setSum(dto.getWorkingAreaBusinessSum());
		list.add(dto10);
		
		Develop1DTO dto11 = new Develop1DTO();
		dto11.setCatagory("办公房");
		dto11.setSum(dto.getWorkingAreaOfficeSum());
		list.add(dto11);
		
		Develop1DTO dto12 = new Develop1DTO();
		dto12.setCatagory("其他房");
		dto12.setSum(dto.getWorkingAreaOtherSum());
		list.add(dto12);
		
		Develop1DTO dto13 = new Develop1DTO();
		dto13.setRecordMonth(recordMonth);
		dto13.setSubject("新开工面积(㎡)");
		dto13.setSubTotal(dto.getNewAreaHouseSum() + dto.getNewAreaBusinessSum() + dto.getNewAreaOfficeSum() + dto.getNewAreaOtherSum());
		dto13.setCatagory("住宅");
		dto13.setSum(dto.getNewAreaHouseSum());
		list.add(dto13);
		
		Develop1DTO dto14 = new Develop1DTO();
		dto14.setCatagory("商业营业房");
		dto14.setSum(dto.getNewAreaBusinessSum());
		list.add(dto14);
		
		Develop1DTO dto15 = new Develop1DTO();
		dto15.setCatagory("办公房");
		dto15.setSum(dto.getNewAreaOfficeSum());
		list.add(dto15);
		
		Develop1DTO dto16 = new Develop1DTO();
		dto16.setCatagory("其他房");
		dto16.setSum(dto.getNewAreaOtherSum());
		list.add(dto16);
		
		Develop1DTO dto17 = new Develop1DTO();
		dto17.setRecordMonth(recordMonth);
		dto17.setSubject("竣工面积(㎡)");
		dto17.setSubTotal(dto.getCompleteAreaHouseSum() + dto.getCompleteAreaBusinessSum() + dto.getCompleteAreaOfficeSum() + dto.getCompleteAreaOtherSum());
		dto17.setCatagory("住宅");
		dto17.setSum(dto.getCompleteAreaHouseSum());
		list.add(dto17);
		
		Develop1DTO dto18 = new Develop1DTO();
		dto18.setCatagory("商业营业房");
		dto18.setSum(dto.getCompleteAreaBusinessSum());
		list.add(dto18);
		
		Develop1DTO dto19 = new Develop1DTO();
		dto19.setCatagory("办公房");
		dto19.setSum(dto.getCompleteAreaOfficeSum());
		list.add(dto19);
		
		Develop1DTO dto20 = new Develop1DTO();
		dto20.setCatagory("其他房");
		dto20.setSum(dto.getCompleteAreaOtherSum());
		list.add(dto20);
		
		Develop1DTO dto21 = new Develop1DTO();
		dto21.setRecordMonth(recordMonth);
		dto21.setSubject("销售面积(㎡)");
		dto21.setSubTotal(dto.getSaledAreaHouseSum() + dto.getSaledAreaBusinessSum() + dto.getSaledAreaOfficeSum() + dto.getSaledAreaOtherSum());
		dto21.setCatagory("住宅");
		dto21.setSum(dto.getSaledAreaHouseSum());
		list.add(dto21);
		
		Develop1DTO dto22 = new Develop1DTO();
		dto22.setCatagory("商业营业房");
		dto22.setSum(dto.getSaledAreaBusinessSum());
		list.add(dto22);
		
		Develop1DTO dto23 = new Develop1DTO();
		dto23.setCatagory("办公房");
		dto23.setSum(dto.getSaledAreaOfficeSum());
		list.add(dto23);
		
		Develop1DTO dto24 = new Develop1DTO();
		dto24.setCatagory("其他房");
		dto24.setSum(dto.getSaledAreaOtherSum());
		list.add(dto24);
		
		Develop1DTO dto25 = new Develop1DTO();
		dto25.setRecordMonth(recordMonth);
		dto25.setSubject("销售收入（万元）");
		dto25.setSubTotal(dto.getIncomingHouseSum() + dto.getIncomingBusinessSum() + dto.getIncomingOfficeSum() + dto.getIncomingOtherSum());
		dto25.setCatagory("住宅");
		dto25.setSum(dto.getIncomingHouseSum());
		list.add(dto25);
		
		Develop1DTO dto26 = new Develop1DTO();
		dto26.setCatagory("商业营业房");
		dto26.setSum(dto.getIncomingBusinessSum());
		list.add(dto26);
		
		Develop1DTO dto27 = new Develop1DTO();
		dto27.setCatagory("办公房");
		dto27.setSum(dto.getIncomingOfficeSum());
		list.add(dto27);
		
		Develop1DTO dto28 = new Develop1DTO();
		dto28.setCatagory("其他房");
		dto28.setSum(dto.getIncomingOtherSum());
		list.add(dto28);
		
		Develop1DTO dto29 = new Develop1DTO();
		dto29.setRecordMonth(recordMonth);
		dto29.setSubject("待售面积(㎡)");
		dto29.setSubTotal(dto.getOnsaleAreaHouseSum() + dto.getOnsaleAreaBusinessSum() + dto.getOnsaleAreaOfficeSum() + dto.getOnsaleAreaOtherSum());
		dto29.setCatagory("住宅");
		dto29.setSum(dto.getOnsaleAreaHouseSum());
		list.add(dto29);
		
		Develop1DTO dto30 = new Develop1DTO();
		dto30.setCatagory("商业营业房");
		dto30.setSum(dto.getOnsaleAreaBusinessSum());
		list.add(dto30);
		
		Develop1DTO dto31 = new Develop1DTO();
		dto31.setCatagory("办公房");
		dto31.setSum(dto.getOnsaleAreaOfficeSum());
		list.add(dto31);
		
		Develop1DTO dto32 = new Develop1DTO();
		dto32.setCatagory("其他房");
		dto32.setSum(dto.getOnsaleAreaOtherSum());
		list.add(dto32);
		
		return list;
	}
}
