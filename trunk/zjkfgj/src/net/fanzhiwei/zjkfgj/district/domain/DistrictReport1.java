package net.fanzhiwei.zjkfgj.district.domain;

import java.io.Serializable;
import java.util.Date;

public class DistrictReport1 implements Serializable {

	private static final long serialVersionUID = -969698360131814872L;
	private Long id;
	private Long userId;
	private Date createTime;
	private Date modifyTime;
	private Integer recordYearMonth;
	private String developerName;
	private String licenceNo;// 预售许可证编号
	private Date licenceDate;// 预售许可证颁发时间
	private String projectName;// 项目名称
	private String location;// 房屋坐落地
	private Integer houseNumber;
	private Double houseArea;
	private Double business;
	private Double office;
	private Double other;

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

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public Double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}

	public Double getBusiness() {
		return business;
	}

	public void setBusiness(Double business) {
		this.business = business;
	}

	public Double getOffice() {
		return office;
	}

	public void setOffice(Double office) {
		this.office = office;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}
}
