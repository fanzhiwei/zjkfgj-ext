package net.fanzhiwei.zjkfgj.develop.dto;

public class DevelopDTO6 {
	private Integer id;
	private String district;
	private Double sumCount = 0d;
	private Double completeAreaHouseSum = 0d;
	private Double completeAreaBusinessSum = 0d;
	private Double completeAreaOfficeSum = 0d;
	private Double completeAreaOtherSum = 0d;

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

	public Double getCompleteAreaHouseSum() {
		return completeAreaHouseSum;
	}

	public void setCompleteAreaHouseSum(Double completeAreaHouseSum) {
		this.completeAreaHouseSum = completeAreaHouseSum;
	}

	public Double getCompleteAreaBusinessSum() {
		return completeAreaBusinessSum;
	}

	public void setCompleteAreaBusinessSum(Double completeAreaBusinessSum) {
		this.completeAreaBusinessSum = completeAreaBusinessSum;
	}

	public Double getCompleteAreaOfficeSum() {
		return completeAreaOfficeSum;
	}

	public void setCompleteAreaOfficeSum(Double completeAreaOfficeSum) {
		this.completeAreaOfficeSum = completeAreaOfficeSum;
	}

	public Double getCompleteAreaOtherSum() {
		return completeAreaOtherSum;
	}

	public void setCompleteAreaOtherSum(Double completeAreaOtherSum) {
		this.completeAreaOtherSum = completeAreaOtherSum;
	}
}
