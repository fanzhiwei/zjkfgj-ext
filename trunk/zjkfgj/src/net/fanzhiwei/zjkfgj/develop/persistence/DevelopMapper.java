package net.fanzhiwei.zjkfgj.develop.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.domain.Develop;

public interface DevelopMapper {
	List<Develop> getDevelopList(Map<String,Object> param);
	void insertDevelop(Develop develop);
	void updateDevelop(Develop develop);
	void deleteDevelop(Map<String,Object> param);
}
