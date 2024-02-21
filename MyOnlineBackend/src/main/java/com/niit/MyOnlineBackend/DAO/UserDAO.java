package com.niit.MyOnlineBackend.DAO;

import java.util.List;

import com.niit.MyOnlineBackend.model.Address;
import com.niit.MyOnlineBackend.model.User;

public interface UserDAO 
{
	public boolean insert(User user);
	public User getUserByEmail(String email);
	public List<User> getSuppliers();
	
	public boolean insertAddress(Address address);
	
    
}
