package com.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_category")
public class EventCategory {

	public EventCategory() {
		super();
	}

	public EventCategory(String category) {
		this.category = category;
	}
	
	public EventCategory(Integer categoryId,String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}

	@Id
	@GeneratedValue
	Integer categoryId;
	
	String category;

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
