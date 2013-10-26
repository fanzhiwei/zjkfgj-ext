package net.fanzhiwei.zjkfgj.district.vo;

import net.fanzhiwei.zjkfgj.district.dto.DistrictSumReportDTO2a;


public class DistrictSumReportVO2 extends DistrictSumReportDTO2a {
	private int id;
	private Long userId;
	private String recordMonth;
	private String district;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(String recordMonth) {
		this.recordMonth = recordMonth;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
