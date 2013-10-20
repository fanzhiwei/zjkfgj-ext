package net.fanzhiwei.zjkfgj.district.domain;

import java.io.Serializable;
import java.util.Date;

public class DistrictReport2_5 implements Serializable {
	private static final long serialVersionUID = 4355233033460608689L;

	private Long id;
	private Long userId;
	private Date createTime;
	private Date modifyTime;
	private Integer recordYearMonth;
	private String developerName;
	private String projectName;// 项目名称
	private String startTime;
	private String completeTime;
	private String location;
	private Integer houseNumber;
	private Double area;
	private Double totalPrice;
	private Double averagePrice;
	private String category;

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

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
