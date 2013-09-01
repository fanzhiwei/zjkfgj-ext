package net.fanzhiwei.zjkfgj.develop.domain;

import java.io.Serializable;
import java.util.Date;

public class Develop implements Serializable {

	private static final long serialVersionUID = -5098447485334782884L;

	private Long id;
	private Integer areaId;
	private String areaName;//area表列，方便起见
	private Long userId;
	private Date createTime;
	private Date modifyTime;
	private Integer recordYearMonth;
	private Double investHouse;
	private Double investBusiness;
	private Double investOffice;
	private Double investOther;
	private Double financialSourcingInland;
	private Double financialSourcingForeign;
	private Double financialSourcingSelf;
	private Double financialSourcingOther;
	private Double workingAreaHouse;
	private Double workingAreaBusiness;
	private Double workingAreaOffice;
	private Double workingAreaOther;
	private Double newAreaHouse;
	private Double newAreaBusiness;
	private Double newAreaOffice;
	private Double newAreaOther;
	private Double completeAreaHouse;
	private Double completeAreaBusiness;
	private Double completeAreaOffice;
	private Double completeAreaOther;
	private Double saledAreaHouse;
	private Double saledAreaBusiness;
	private Double saledAreaOffice;
	private Double saledAreaOther;
	private Double incomingHouse;
	private Double incomingBusiness;
	private Double incomingOffice;
	private Double incomingOther;
	private Double onsaleAreaHouse;
	private Double onsaleAreaBusiness;
	private Double onsaleAreaOffice;
	private Double onsaleAreaOther;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public Double getInvestHouse() {
		return investHouse;
	}

	public void setInvestHouse(Double investHouse) {
		this.investHouse = investHouse;
	}

	public Double getInvestBusiness() {
		return investBusiness;
	}

	public void setInvestBusiness(Double investBusiness) {
		this.investBusiness = investBusiness;
	}

	public Double getInvestOffice() {
		return investOffice;
	}

	public void setInvestOffice(Double investOffice) {
		this.investOffice = investOffice;
	}

	public Double getInvestOther() {
		return investOther;
	}

	public void setInvestOther(Double investOther) {
		this.investOther = investOther;
	}

	public Double getFinancialSourcingInland() {
		return financialSourcingInland;
	}

	public void setFinancialSourcingInland(Double financialSourcingInland) {
		this.financialSourcingInland = financialSourcingInland;
	}

	public Double getFinancialSourcingForeign() {
		return financialSourcingForeign;
	}

	public void setFinancialSourcingForeign(Double financialSourcingForeign) {
		this.financialSourcingForeign = financialSourcingForeign;
	}

	public Double getFinancialSourcingSelf() {
		return financialSourcingSelf;
	}

	public void setFinancialSourcingSelf(Double financialSourcingSelf) {
		this.financialSourcingSelf = financialSourcingSelf;
	}

	public Double getFinancialSourcingOther() {
		return financialSourcingOther;
	}

	public void setFinancialSourcingOther(Double financialSourcingOther) {
		this.financialSourcingOther = financialSourcingOther;
	}

	public Double getWorkingAreaHouse() {
		return workingAreaHouse;
	}

	public void setWorkingAreaHouse(Double workingAreaHouse) {
		this.workingAreaHouse = workingAreaHouse;
	}

	public Double getWorkingAreaBusiness() {
		return workingAreaBusiness;
	}

	public void setWorkingAreaBusiness(Double workingAreaBusiness) {
		this.workingAreaBusiness = workingAreaBusiness;
	}

	public Double getWorkingAreaOffice() {
		return workingAreaOffice;
	}

	public void setWorkingAreaOffice(Double workingAreaOffice) {
		this.workingAreaOffice = workingAreaOffice;
	}

	public Double getWorkingAreaOther() {
		return workingAreaOther;
	}

	public void setWorkingAreaOther(Double workingAreaOther) {
		this.workingAreaOther = workingAreaOther;
	}

	public Double getNewAreaHouse() {
		return newAreaHouse;
	}

	public void setNewAreaHouse(Double newAreaHouse) {
		this.newAreaHouse = newAreaHouse;
	}

	public Double getNewAreaBusiness() {
		return newAreaBusiness;
	}

	public void setNewAreaBusiness(Double newAreaBusiness) {
		this.newAreaBusiness = newAreaBusiness;
	}

	public Double getNewAreaOffice() {
		return newAreaOffice;
	}

	public void setNewAreaOffice(Double newAreaOffice) {
		this.newAreaOffice = newAreaOffice;
	}

	public Double getNewAreaOther() {
		return newAreaOther;
	}

	public void setNewAreaOther(Double newAreaOther) {
		this.newAreaOther = newAreaOther;
	}

	public Double getCompleteAreaHouse() {
		return completeAreaHouse;
	}

	public void setCompleteAreaHouse(Double completeAreaHouse) {
		this.completeAreaHouse = completeAreaHouse;
	}

	public Double getCompleteAreaBusiness() {
		return completeAreaBusiness;
	}

	public void setCompleteAreaBusiness(Double completeAreaBusiness) {
		this.completeAreaBusiness = completeAreaBusiness;
	}

	public Double getCompleteAreaOffice() {
		return completeAreaOffice;
	}

	public void setCompleteAreaOffice(Double completeAreaOffice) {
		this.completeAreaOffice = completeAreaOffice;
	}

	public Double getCompleteAreaOther() {
		return completeAreaOther;
	}

	public void setCompleteAreaOther(Double completeAreaOther) {
		this.completeAreaOther = completeAreaOther;
	}

	public Double getSaledAreaHouse() {
		return saledAreaHouse;
	}

	public void setSaledAreaHouse(Double saledAreaHouse) {
		this.saledAreaHouse = saledAreaHouse;
	}

	public Double getSaledAreaBusiness() {
		return saledAreaBusiness;
	}

	public void setSaledAreaBusiness(Double saledAreaBusiness) {
		this.saledAreaBusiness = saledAreaBusiness;
	}

	public Double getSaledAreaOffice() {
		return saledAreaOffice;
	}

	public void setSaledAreaOffice(Double saledAreaOffice) {
		this.saledAreaOffice = saledAreaOffice;
	}

	public Double getSaledAreaOther() {
		return saledAreaOther;
	}

	public void setSaledAreaOther(Double saledAreaOther) {
		this.saledAreaOther = saledAreaOther;
	}

	public Double getIncomingHouse() {
		return incomingHouse;
	}

	public void setIncomingHouse(Double incomingHouse) {
		this.incomingHouse = incomingHouse;
	}

	public Double getIncomingBusiness() {
		return incomingBusiness;
	}

	public void setIncomingBusiness(Double incomingBusiness) {
		this.incomingBusiness = incomingBusiness;
	}

	public Double getIncomingOffice() {
		return incomingOffice;
	}

	public void setIncomingOffice(Double incomingOffice) {
		this.incomingOffice = incomingOffice;
	}

	public Double getIncomingOther() {
		return incomingOther;
	}

	public void setIncomingOther(Double incomingOther) {
		this.incomingOther = incomingOther;
	}

	public Double getOnsaleAreaHouse() {
		return onsaleAreaHouse;
	}

	public void setOnsaleAreaHouse(Double onsaleAreaHouse) {
		this.onsaleAreaHouse = onsaleAreaHouse;
	}

	public Double getOnsaleAreaBusiness() {
		return onsaleAreaBusiness;
	}

	public void setOnsaleAreaBusiness(Double onsaleAreaBusiness) {
		this.onsaleAreaBusiness = onsaleAreaBusiness;
	}

	public Double getOnsaleAreaOffice() {
		return onsaleAreaOffice;
	}

	public void setOnsaleAreaOffice(Double onsaleAreaOffice) {
		this.onsaleAreaOffice = onsaleAreaOffice;
	}

	public Double getOnsaleAreaOther() {
		return onsaleAreaOther;
	}

	public void setOnsaleAreaOther(Double onsaleAreaOther) {
		this.onsaleAreaOther = onsaleAreaOther;
	}
}
