package com.capstone.ecom.iamazon;

import java.util.Set;

import com.capstone.ecom.modal.ProductDetails;

public interface IAmazon<T> {
	
abstract Set<T> getList();
	
	public abstract String createNewProduct(ProductDetails product_name);
	
	public abstract String updatebyId(ProductDetails entity, int product_id);
	
	public abstract T findById(int product_id);
	
	public abstract String deleteById(int product_id);


}
