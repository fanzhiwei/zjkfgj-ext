package net.fanzhiwei.zjkfgj.develop.dto;

public class DevelopDTO4 {
	private Integer id;
	private String district;
	private Double sumCount = 0d;
	private Double workingAreaHouseSum = 0d;
	private Double workingAreaBusinessSum = 0d;
	private Double workingAreaOfficeSum = 0d;
	private Double workingAreaOtherSum = 0d;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Double getSumCount() {
		return sumCount;
	}

	public void setSumCount(Double sumCount) {
		this.sumCount = sumCount;
	}

	public Double getWorkingAreaHouseSum() {
		return workingAreaHouseSum;
	}

	public void setWorkingAreaHouseSum(Double workingAreaHouseSum) {
		this.workingAreaHouseSum = workingAreaHouseSum;
	}

	public Double getWorkingAreaBusinessSum() {
		return workingAreaBusinessSum;
	}

	public void setWorkingAreaBusinessSum(Double workingAreaBusinessSum) {
		this.workingAreaBusinessSum = workingAreaBusinessSum;
	}

	public Double getWorkingAreaOfficeSum() {
		return workingAreaOfficeSum;
	}

	public void setWorkingAreaOfficeSum(Double workingAreaOfficeSum) {
		this.workingAreaOfficeSum = workingAreaOfficeSum;
	}

	public Double getWorkingAreaOtherSum() {
		return workingAreaOtherSum;
	}

	public void setWorkingAreaOtherSum(Double workingAreaOtherSum) {
		this.workingAreaOtherSum = workingAreaOtherSum;
	}
}
