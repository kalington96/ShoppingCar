package com.jsp.ShoppingCart.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.dto.Orders;

@Repository
public class OrdersDao {
	@Autowired
	EntityManagerFactory emf;
	public void saveItem(Orders Orders)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(Orders);
		et.commit();
	}
	
	public void updateOrder(Orders Orders)
	{
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(Orders);
		em.getTransaction().commit();
	}
	public void deleteOrderById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders i=em.find(Orders.class, id);
		et.begin();
		em.remove(i);
		et.commit();
	}
	public Orders findOrdersById(int id)
	{
		EntityManager em=emf.createEntityManager();
		Orders i=em.find(Orders.class, id);
		if(i!=null)
			return i;
		else
			return null;
	}

}
