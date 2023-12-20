package com.niit.MyOnlineBackend.DAO;

import java.util.List;

import com.niit.MyOnlineBackend.model.Product;

public interface ProductDAO 
{
	boolean insert(Product product);
	boolean update(Product product);
	Product getProduct(int p_id);
	List<Product> listProduct();
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
}
