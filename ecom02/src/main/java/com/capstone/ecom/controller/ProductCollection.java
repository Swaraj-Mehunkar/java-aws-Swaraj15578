package com.capstone.ecom.controller;

import com.capstone.ecom.modal.ProductDetails;
import com.capstone.ecom.util.AmazonCollection;

public class ProductCollection extends AmazonCollection<ProductDetails> {
	private static ProductCollection pc;
	public ProductCollection() {
		super();
	}

	public static ProductCollection getCollection() {
		if(pc==null) {
			synchronized(ProductCollection.class) {
				if(pc==null) {
					pc = new ProductCollection();
				}
			}
		}
		return pc;
	
}
	@Override
	public String createNewProduct(ProductDetails product_name) {
		if(collection.add(product_name)) {
			return "New Product Added";

		}
		return null;
	}

	@Override
	public String updatebyId(ProductDetails entity, int product_id) {
		for(ProductDetails product:collection) {
			if(product.getProduct_id()==product_id) {
				product.setProduct_name(entity.getProduct_name());
				return "Product updated Successfully";
			}	
		}
		return null;
	}

	@Override
	public Object findById(int product_id) {
		for(ProductDetails product:collection) {
			if(product.getProduct_id()==product_id) {
				return product;
			} 
		}
		return null;
	}

	@Override
	public String deleteById(int product_id) {
		for(ProductDetails product:collection) {
			if(product.getProduct_id()==product_id) {
				collection.remove(product);
				return "Product Deleted";
			}
		}
		return "Product Not Found";
	}
}
