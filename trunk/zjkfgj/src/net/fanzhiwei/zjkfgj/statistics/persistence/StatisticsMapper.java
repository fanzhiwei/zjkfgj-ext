package net.fanzhiwei.zjkfgj.statistics.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.statistics.dto.UserRecordStatistics;

public interface StatisticsMapper {
	List<UserRecordStatistics> getDevUserStatistics1(Map<String,Object> param);
	List<UserRecordStatistics> getDisUserStatistics1(Map<String,Object> param);
	List<UserRecordStatistics> getDisUserStatistics2_5(Map<String,Object> param);
	List<UserRecordStatistics> getDisUserStatistics6(Map<String,Object> param);
	List<UserRecordStatistics> getDisUserStatistics7(Map<String,Object> param);
}
