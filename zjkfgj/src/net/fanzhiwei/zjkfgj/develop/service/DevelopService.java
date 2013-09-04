package net.fanzhiwei.zjkfgj.develop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
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
}
