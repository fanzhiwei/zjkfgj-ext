package net.fanzhiwei.zjkfgj.district.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.develop.dto.DevelopDTO;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;

public interface DistrictMapper {
	List<DistrictReport1> getDistrictListReport1(Map<String,Object> param);
	void insertDistrictReport1(DistrictReport1 report1);
	void updateDistrictReport1(DistrictReport1 report1);
	void deleteDistrictReport1(Map<String,Object> param);
}
