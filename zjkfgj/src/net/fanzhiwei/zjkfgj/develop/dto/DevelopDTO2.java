package net.fanzhiwei.zjkfgj.develop.dto;

public class DevelopDTO2 {
	private Integer id;
	private String district;
	private Double sumCount = 0d;
	private Double investHouseSum = 0d;
	private Double investBusinessSum = 0d;
	private Double investOfficeSum = 0d;
	private Double investOtherSum = 0d;

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

	public Double getInvestHouseSum() {
		return investHouseSum;
	}

	public void setInvestHouseSum(Double investHouseSum) {
		this.investHouseSum = investHouseSum;
	}

	public Double getInvestBusinessSum() {
		return investBusinessSum;
	}

	public void setInvestBusinessSum(Double investBusinessSum) {
		this.investBusinessSum = investBusinessSum;
	}

	public Double getInvestOfficeSum() {
		return investOfficeSum;
	}

	public void setInvestOfficeSum(Double investOfficeSum) {
		this.investOfficeSum = investOfficeSum;
	}

	public Double getInvestOtherSum() {
		return investOtherSum;
	}

	public void setInvestOtherSum(Double investOtherSum) {
		this.investOtherSum = investOtherSum;
	}
}
