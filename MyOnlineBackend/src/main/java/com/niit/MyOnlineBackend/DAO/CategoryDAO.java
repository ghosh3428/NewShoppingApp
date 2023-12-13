package com.niit.MyOnlineBackend.DAO;

import java.util.List;

import com.niit.MyOnlineBackend.model.Category;

public interface CategoryDAO 
{
	public boolean insert(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category getCategory(int id);
	public List<Category> categoryList();
}
