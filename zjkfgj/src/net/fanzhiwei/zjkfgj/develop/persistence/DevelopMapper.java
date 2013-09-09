package net.fanzhiwei.zjkfgj.develop.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Area;
import net.fanzhiwei.zjkfgj.develop.domain.Develop;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO2;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO3;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO4;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO5;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO6;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO7;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO8;
import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO9;

public interface DevelopMapper {
	List<Develop> getDevelopList(Map<String,Object> param);
	void insertDevelop(Develop develop);
	void updateDevelop(Develop develop);
	void deleteDevelop(Map<String,Object> param);
	List<Area> getArea();
	DevelopDTO selectDevelopCount1(Map<String,Object> param);
	List<DevelopDTO2> selectDevelopCount2(Map<String,Object> param);
	List<DevelopDTO3> selectDevelopCount3(Map<String,Object> param);
	List<DevelopDTO4> selectDevelopCount4(Map<String,Object> param);
	List<DevelopDTO5> selectDevelopCount5(Map<String,Object> param);
	List<DevelopDTO6> selectDevelopCount6(Map<String,Object> param);
	List<DevelopDTO7> selectDevelopCount7(Map<String,Object> param);
	List<DevelopDTO8> selectDevelopCount8(Map<String,Object> param);
	List<DevelopDTO9> selectDevelopCount9(Map<String,Object> param);
}
