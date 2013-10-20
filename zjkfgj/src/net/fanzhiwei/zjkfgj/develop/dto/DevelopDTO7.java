package net.fanzhiwei.zjkfgj.develop.dto;

public class DevelopDTO7 {
	private Integer id;
	private String district;
	private Double sumCount = 0d;
	private Double saledAreaHouseSum = 0d;
	private Double saledAreaBusinessSum = 0d;
	private Double saledAreaOfficeSum = 0d;
	private Double saledAreaOtherSum = 0d;

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

	public Double getSaledAreaHouseSum() {
		return saledAreaHouseSum;
	}

	public void setSaledAreaHouseSum(Double saledAreaHouseSum) {
		this.saledAreaHouseSum = saledAreaHouseSum;
	}

	public Double getSaledAreaBusinessSum() {
		return saledAreaBusinessSum;
	}

	public void setSaledAreaBusinessSum(Double saledAreaBusinessSum) {
		this.saledAreaBusinessSum = saledAreaBusinessSum;
	}

	public Double getSaledAreaOfficeSum() {
		return saledAreaOfficeSum;
	}

	public void setSaledAreaOfficeSum(Double saledAreaOfficeSum) {
		this.saledAreaOfficeSum = saledAreaOfficeSum;
	}

	public Double getSaledAreaOtherSum() {
		return saledAreaOtherSum;
	}

	public void setSaledAreaOtherSum(Double saledAreaOtherSum) {
		this.saledAreaOtherSum = saledAreaOtherSum;
	}
}
