package com.capstone.ecom.util;

import java.util.HashSet;
import java.util.Set;

import com.capstone.ecom.iamazon.IAmazon;
import com.capstone.ecom.modal.ProductDetails;

public abstract class AmazonCollection<T> implements IAmazon {

	public Set<T> collection= new HashSet<>();
		public AmazonCollection() {
			super();
	}
		public Set<ProductDetails> getList() {
			// TODO Auto-generated method stub
			return null;
		}
		

}
