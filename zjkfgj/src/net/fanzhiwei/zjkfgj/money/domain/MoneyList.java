package net.fanzhiwei.zjkfgj.money.domain;

import java.io.Serializable;

public class MoneyList implements Serializable {

	private static final long serialVersionUID = 1408934560085483024L;

	private Long id;
	
	private Long moneyId;
	
	private String name;
	
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMoneyId() {
		return moneyId;
	}

	public void setMoneyId(Long moneyId) {
		this.moneyId = moneyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
