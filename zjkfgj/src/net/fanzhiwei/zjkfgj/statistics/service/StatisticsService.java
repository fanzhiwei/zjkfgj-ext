package net.fanzhiwei.zjkfgj.statistics.service;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.statistics.dto.UserRecordStatistics;
import net.fanzhiwei.zjkfgj.statistics.persistence.StatisticsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class StatisticsService{
	@Autowired
	private StatisticsMapper statisticsMapper;
	
	@Transactional(readOnly = true)
	public List<UserRecordStatistics> getDevUserStatistics1(Map<String,Object> param) {
		return statisticsMapper.getDevUserStatistics1(param);
	}
	
	@Transactional(readOnly = true)
	public List<UserRecordStatistics> getDisUserStatistics1(Map<String,Object> param) {
		return statisticsMapper.getDisUserStatistics1(param);
	}
	
	@Transactional(readOnly = true)
	public List<UserRecordStatistics> getDisUserStatistics2_5(Map<String,Object> param) {
		return statisticsMapper.getDisUserStatistics2_5(param);
	}
	
	@Transactional(readOnly = true)
	public List<UserRecordStatistics> getDisUserStatistics6(Map<String,Object> param) {
		return statisticsMapper.getDisUserStatistics6(param);
	}
	
	@Transactional(readOnly = true)
	public List<UserRecordStatistics> getDisUserStatistics7(Map<String,Object> param) {
		return statisticsMapper.getDisUserStatistics7(param);
	}
}
