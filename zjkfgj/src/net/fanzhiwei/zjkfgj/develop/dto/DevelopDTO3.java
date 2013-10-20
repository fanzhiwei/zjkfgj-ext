package net.fanzhiwei.zjkfgj.develop.dto;

public class DevelopDTO3 {
	private Integer id;
	private String district;
	private Double sumCount = 0d;
	private Double financialSourcingInlandSum = 0d;
	private Double financialSourcingForeignSum = 0d;
	private Double financialSourcingSelfSum = 0d;
	private Double financialSourcingOtherSum = 0d;

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

	public Double getFinancialSourcingInlandSum() {
		return financialSourcingInlandSum;
	}

	public void setFinancialSourcingInlandSum(Double financialSourcingInlandSum) {
		this.financialSourcingInlandSum = financialSourcingInlandSum;
	}

	public Double getFinancialSourcingForeignSum() {
		return financialSourcingForeignSum;
	}

	public void setFinancialSourcingForeignSum(
			Double financialSourcingForeignSum) {
		this.financialSourcingForeignSum = financialSourcingForeignSum;
	}

	public Double getFinancialSourcingSelfSum() {
		return financialSourcingSelfSum;
	}

	public void setFinancialSourcingSelfSum(Double financialSourcingSelfSum) {
		this.financialSourcingSelfSum = financialSourcingSelfSum;
	}

	public Double getFinancialSourcingOtherSum() {
		return financialSourcingOtherSum;
	}

	public void setFinancialSourcingOtherSum(Double financialSourcingOtherSum) {
		this.financialSourcingOtherSum = financialSourcingOtherSum;
	}
}
