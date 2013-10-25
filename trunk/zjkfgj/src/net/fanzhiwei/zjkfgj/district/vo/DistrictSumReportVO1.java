package net.fanzhiwei.zjkfgj.district.vo;

import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO1;


public class DistrictSumReportVO1 extends DistrictSumReportDTO1 {
	private int id;
	private String recordMonth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(String recordMonth) {
		this.recordMonth = recordMonth;
	}
}
