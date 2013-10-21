package net.fanzhiwei.zjkfgj.district.domain;

import java.io.Serializable;
import java.util.Date;

public class DistrictReport6 implements Serializable {

	private static final long serialVersionUID = -3009554490700273974L;
	private Long id;
	private Long userId;
	private Date createTime;
	private Date modifyTime;
	private Integer recordYearMonth;
	private Integer firstNumber;
	private Double firstArea;
	private Integer secondNumber;
	private Double secondArea;
	private Integer threeNumber;
	private Double threeArea;
	private Integer fourNumber;
	private Double fourArea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getRecordYearMonth() {
		return recordYearMonth;
	}

	public void setRecordYearMonth(Integer recordYearMonth) {
		this.recordYearMonth = recordYearMonth;
	}

	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Double getFirstArea() {
		return firstArea;
	}

	public void setFirstArea(Double firstArea) {
		this.firstArea = firstArea;
	}

	public Integer getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}

	public Double getSecondArea() {
		return secondArea;
	}

	public void setSecondArea(Double secondArea) {
		this.secondArea = secondArea;
	}

	public Integer getThreeNumber() {
		return threeNumber;
	}

	public void setThreeNumber(Integer threeNumber) {
		this.threeNumber = threeNumber;
	}

	public Double getThreeArea() {
		return threeArea;
	}

	public void setThreeArea(Double threeArea) {
		this.threeArea = threeArea;
	}

	public Integer getFourNumber() {
		return fourNumber;
	}

	public void setFourNumber(Integer fourNumber) {
		this.fourNumber = fourNumber;
	}

	public Double getFourArea() {
		return fourArea;
	}

	public void setFourArea(Double fourArea) {
		this.fourArea = fourArea;
	}

}
