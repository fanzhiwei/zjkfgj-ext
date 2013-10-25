package net.fanzhiwei.zjkfgj.district.dto;

public class DistrictSumReportDTO1 {
	private String district;
	private Integer licenceSum = 0;
	private Integer houseNumberSum = 0;
	private Double houseAreaSum = 0d;
	private Double businessSum = 0d;
	private Double officeSum = 0d;
	private Double otherSum = 0d;
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getLicenceSum() {
		return licenceSum;
	}
	public void setLicenceSum(Integer licenceSum) {
		this.licenceSum = licenceSum;
	}
	public Integer getHouseNumberSum() {
		return houseNumberSum;
	}
	public void setHouseNumberSum(Integer houseNumberSum) {
		this.houseNumberSum = houseNumberSum;
	}
	public Double getHouseAreaSum() {
		return houseAreaSum;
	}
	public void setHouseAreaSum(Double houseAreaSum) {
		this.houseAreaSum = houseAreaSum;
	}
	public Double getBusinessSum() {
		return businessSum;
	}
	public void setBusinessSum(Double businessSum) {
		this.businessSum = businessSum;
	}
	public Double getOfficeSum() {
		return officeSum;
	}
	public void setOfficeSum(Double officeSum) {
		this.officeSum = officeSum;
	}
	public Double getOtherSum() {
		return otherSum;
	}
	public void setOtherSum(Double otherSum) {
		this.otherSum = otherSum;
	}
}
