package net.fanzhiwei.zjkfgj.district.domain;

import java.io.Serializable;
import java.util.Date;

public class DistrictReport7 implements Serializable {
	private static final long serialVersionUID = 8509142486248075874L;
	private Long id;
	private Long userId;
	private Date createTime;
	private Date modifyTime;
	private Integer recordYearMonth;
	private Integer dealNumber;
	private Double dealArea;
	private Double totalPrice;
	private Double averagePrice;

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

	public Integer getDealNumber() {
		return dealNumber;
	}

	public void setDealNumber(Integer dealNumber) {
		this.dealNumber = dealNumber;
	}

	public Double getDealArea() {
		return dealArea;
	}

	public void setDealArea(Double dealArea) {
		this.dealArea = dealArea;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
}
