package net.fanzhiwei.zjkfgj.district.dto;

public class DistrictSumReportDTO2b {
	private Long userId;
	private Integer houseNumberSum;
	private Double areaSum;
	private Double totalPriceSum;
	private Double averagePriceSum;

	public Integer getHouseNumberSum() {
		return houseNumberSum;
	}

	public void setHouseNumberSum(Integer houseNumberSum) {
		this.houseNumberSum = houseNumberSum;
	}

	public Double getAreaSum() {
		return areaSum;
	}

	public void setAreaSum(Double areaSum) {
		this.areaSum = areaSum;
	}

	public Double getTotalPriceSum() {
		return totalPriceSum;
	}

	public void setTotalPriceSum(Double totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}

	public Double getAveragePriceSum() {
		return averagePriceSum;
	}

	public void setAveragePriceSum(Double averagePriceSum) {
		this.averagePriceSum = averagePriceSum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
