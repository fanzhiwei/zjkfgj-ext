package net.fanzhiwei.zjkfgj.district.vo;

import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO3;


public class DistrictSumReportVO3 extends DistrictSumReportDTO3 {
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
