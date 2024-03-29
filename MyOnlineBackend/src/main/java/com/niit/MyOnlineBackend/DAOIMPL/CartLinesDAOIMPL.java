package com.niit.MyOnlineBackend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MyOnlineBackend.DAO.CartLinesDAO;
import com.niit.MyOnlineBackend.model.Cart;
import com.niit.MyOnlineBackend.model.CartLines;

@Repository("cartLinesDAO")
@Transactional
public class CartLinesDAOIMPL implements CartLinesDAO 
{
	
	@Autowired 
	SessionFactory sessionFactory;

	@Override
	public List<CartLines> list(int cartId) 
	{
		
		String query = "FROM CartLines WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
							 .createQuery(query, CartLines.class)
							 .setParameter("cartId", cartId)
							 .getResultList();		
	
	}

	@Override
	public CartLines get(int id) 
	{
		
		return sessionFactory.getCurrentSession().get(CartLines.class, id);
			
	}

	@Override
	public boolean add(CartLines cartLine)
	{
		
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLines cartLine) 
	{
		
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLines cartLine) 
	{
		
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) 
	{
		
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CartLines> listAvailable(int cartId) 
	{
		
		String query = "FROM CartLines WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
							 .createQuery(query, CartLines.class)
							 .setParameter("cartId", cartId)
							 .setParameter("available", true)
							 .getResultList();
	}

}
