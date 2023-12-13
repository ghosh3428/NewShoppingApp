package com.niit.MyOnlineBackend.DAO;

import com.niit.MyOnlineBackend.model.User;

public interface UserDAO 
{
	public boolean insert(User user);
	public User getUserByEmail(String email);
    
}
