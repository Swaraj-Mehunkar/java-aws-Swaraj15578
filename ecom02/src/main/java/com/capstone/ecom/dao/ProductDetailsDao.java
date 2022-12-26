package com.capstone.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capstone.ecom.dao.DbConnection;
import com.capstone.ecom.modal.ProductDetails;
import com.capstone.ecom.dao.IDao;
import com.capstone.ecom.modal.ProductDetails;

public class ProductDetailsDao implements IDao<ProductDetails> {
	
private DbConnection db;
	

	public ProductDetailsDao() {
		super();	
	}

	public ProductDetailsDao(DbConnection db) {
		super();
		this.db = db;
	}


	public List<ProductDetails> findAll() throws SQLException {
		final List<ProductDetails> list=new ArrayList<ProductDetails>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select product_id,product_name,price from product";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new ProductDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));			
		}
		return list;
	}

	public ProductDetails findOne(int id)  throws SQLException{
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select product_id,product_name,price from product where product_id="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final ProductDetails product=new ProductDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
			return product;
		}
		return null;
	}

	public boolean createNew(ProductDetails pd)  throws SQLException{
		
		Connection connect=db.getConnection();		
		final String sql="insert into product values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, pd.getProduct_id());
		pStatement.setString(2, pd.getProduct_name());
		pStatement.setInt(3,((int) pd.getPrice()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		
		final Connection connect=db.getConnection();
		final String sql="delete from product where product_id=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int product_id, ProductDetails pd) throws SQLException {
		
		final Connection connect=db.getConnection();
		final String sql="update product set price=? where product_id=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, ((int)pd.getPrice()));
		pStatement.setInt(2, pd.getProduct_id());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

}
