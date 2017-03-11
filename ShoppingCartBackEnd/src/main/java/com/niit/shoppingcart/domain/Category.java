package com.niit.shoppingcart.domain;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")  //if the class name and table name is different
@Component               //if want to create instance of Class Category  - category
public class Category {
	
	//add simple properties - same as Category table
	//generate getter/setter methods
	
	@Id
	private String id;
	
	@Column(name="name")  //if the field name and property name is different,in this case it is not required.
	private String name;
	
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
