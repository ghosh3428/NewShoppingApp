package com.niit.MyOnlineBackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="New_Shopping_Product")
public class Product 
{
private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String code;
	
	@NotBlank(message="Product Name cannot be empty")
	private String name;
	
	@NotBlank(message="Brand Name cannot be empty")
	private String brand;
	
	@NotBlank(message="Description cannot be empty")
	private String description;
	
	@Min(value = 1 , message = "Price cannot be less than 1")
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Min(value = 1 , message = "Quantity cannot be less than 1")
	private int quantity;
	
	@Column(name = "is_active")
	private boolean active;
	
	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;
	
	@JsonIgnore
	@Column(name = "supplier_id")
	private int supplierId;
	
	
	public Product() 
	{	
		code = "PRD" + UUID.randomUUID().toString().substring(24);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Transient
	private MultipartFile file;


	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
