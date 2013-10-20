package net.fanzhiwei.zjkfgj.district.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.district.domain.DistrictReport1;
import net.fanzhiwei.zjkfgj.district.domain.DistrictReport2_5;

public interface DistrictMapper {
	List<DistrictReport1> getDistrictListReport1(Map<String,Object> param);
	void insertDistrictReport1(DistrictReport1 report1);
	void updateDistrictReport1(DistrictReport1 report1);
	void deleteDistrictReport1(Map<String,Object> param);
/***********************************************************************************/
	List<DistrictReport2_5> getDistrictListReport2_5(Map<String,Object> param);
	void insertDistrictReport2_5(DistrictReport2_5 report2_5);
	void updateDistrictReport2_5(DistrictReport2_5 report2_5);
	void deleteDistrictReport2_5(Map<String,Object> param);
}
