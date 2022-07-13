package com.sathasivam.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
	// DTO Data Transfer Object
	// User must not be able to change the properties
	private String name;
	private BigDecimal cost;
	private Integer inventory;
	
	public Item(String name, BigDecimal cost, Integer inventory) {
		super();
		this.name = name;
		this.cost = cost;
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, inventory, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(inventory, other.inventory)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "VendingMachine [name=" + name + ", cost=" + cost + ", inventory=" + inventory + "]";
	}
	
	

}
