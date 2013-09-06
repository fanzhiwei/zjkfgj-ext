package net.fanzhiwei.zjkfgj.develop.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO;

public interface DevelopMapper {
	List<Develop> getDevelopList(Map<String,Object> param);
	void insertDevelop(Develop develop);
	void updateDevelop(Develop develop);
	void deleteDevelop(Map<String,Object> param);
	List<Area> getArea();
	DevelopDTO selectDevelopCount1(Map<String,Object> param);
}
