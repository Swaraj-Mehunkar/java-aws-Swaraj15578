package com.capstone.ecom;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.capstone.ecom.dao.DbConnection;
import com.capstone.ecom.dao.ProductDetailsDao;
import com.capstone.ecom.modal.ProductDetails;


public class Product {
	
	public static void main(String[] args) {
	
		try {
			final DbConnection db=DbConnection.getDb();
			final ProductDetailsDao dao=new ProductDetailsDao(db);
//			Display all products			
			printProducts(dao);
			System.out.println("********Find product by product id********");
			final ProductDetails product=dao.findOne(1);
			System.out.println(product);
//			Create new Product
			System.out.println("********After New product added********");
			final ProductDetails newProduct=new ProductDetails("Ipad",70000);
			if(dao.createNew(newProduct)) {
				System.out.println(newProduct+" Created ");
			}else {
				System.out.println(newProduct+" Not Created ");
			}
			
			System.out.println("********After update********");
			product.setPrice(1000);
			if(dao.findOneAndUpdate(1,product)) {
				System.out.println (product+" updated");
			}
			printProducts(dao);
		
			System.out.println("********After Delete********");
			if(dao.findOneAndDelete(1)) {
				System.out.println("product_id : 1 records deleted");
			}
			printProducts(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void printProducts(ProductDetailsDao dao) throws SQLException {
		final List<ProductDetails> list=dao.findAll();
		for(ProductDetails a: list) {
			System.out.println(a);
		}
	}
		
		}
	
