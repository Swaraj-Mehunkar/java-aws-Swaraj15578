package com.capstone.ecom.modal;

import java.util.List;

public class ProductDetails {
	
	private static int counter=1;
	private int product_id;
	private String product_name;
	protected double price;
	public ProductDetails() {
		super();
	}
	public ProductDetails(String product_name, double price) {
		super();
		this.product_id=counter++;
		this.product_name = product_name;
		this.price = price;
	}
	public ProductDetails(int product_id, String product_name, double price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price2) {
		this.price = price2;
	}
	@Override
	public String toString() {
		return "ProductDetails [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + "]";
	}
	public List<ProductDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public ProductDetails findOne(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean createNew(ProductDetails newProduct) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean findOneAndDelete(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
