package net.fanzhiwei.zjkfgj.district.dto;

public class DistrictSumReportDTO4 {
	private String district;
	private Integer dealNumberSum = 0;
	private Double dealAreaSum = 0d;
	private Double totalPriceSum = 0d;
	private Double averagePriceSum = 0d;
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getDealNumberSum() {
		return dealNumberSum;
	}
	public void setDealNumberSum(Integer dealNumberSum) {
		this.dealNumberSum = dealNumberSum;
	}
	public Double getDealAreaSum() {
		return dealAreaSum;
	}
	public void setDealAreaSum(Double dealAreaSum) {
		this.dealAreaSum = dealAreaSum;
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
}
