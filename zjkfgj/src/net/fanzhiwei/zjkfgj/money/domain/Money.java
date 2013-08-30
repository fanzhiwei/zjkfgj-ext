package net.fanzhiwei.zjkfgj.money.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Money implements Serializable {

	private static final long serialVersionUID = 7480590762987551188L;
	
	private Long id;
	
	private Date createTime;

	private String operator;

	private Double total;
	
	/**
	 * 账目明细关联
	 */
	private Set<Map<String,Object>> subList = new HashSet<Map<String,Object>>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<Map<String, Object>> getSubList() {
		return subList;
	}

	public void setSubList(Set<Map<String, Object>> subList) {
		this.subList = subList;
	}
}
