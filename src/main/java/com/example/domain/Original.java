package com.example.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"trainId", "name", "conditionId", "categoryName", "brand", "price", "shipping", "description"})
public class Original {

	private Integer trainId;
	private String name;
	private Integer conditionId;
	private String categoryName;
	private String brand;
	private double price;
	private Integer shipping;
	private String description;

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getShipping() {
		return shipping;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Original [trainId=" + trainId + ", name=" + name + ", conditionId=" + conditionId + ", categoryName="
				+ categoryName + ", brand=" + brand + ", price=" + price + ", shipping=" + shipping + ", description="
				+ description + "]";
	}

}
