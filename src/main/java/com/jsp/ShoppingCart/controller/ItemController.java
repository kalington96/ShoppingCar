package com.jsp.ShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDao;
import com.jsp.ShoppingCart.dao.CustomerDao;
import com.jsp.ShoppingCart.dao.ItemDao;
import com.jsp.ShoppingCart.dao.ProductDao;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class ItemController {
	@Autowired
	ItemDao dao;
	@Autowired
	ProductDao pdao;
	@Autowired
	CartDao cdao;
	@Autowired
	CustomerDao custdao;
	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id")int id)
	{
		Product p=pdao.findProductById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productobj",p);
		mav.setViewName("itemform");
		return mav;
		
	}
	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(ServletRequest req,HttpSession session) {
		int product_id=Integer.parseInt(req.getParameter("id"));
		String brand=req.getParameter("brand");
		double price=Double.parseDouble(req.getParameter("price"));
		String model=req.getParameter("model");
		String category=req.getParameter("category");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		Item item=new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setQuantity(quantity);
		item.setP_id(product_id);
		item.setPrice(quantity*price);
		
		Customer customer=(Customer) session.getAttribute("customerinfo");
		Cart c=customer.getCart();
		if(c==null)
		{
			Cart cart=new Cart();
			List<Item> items=new ArrayList<>();
			items.add(item);
			cart.setItems(items);
			cart.setName(customer.getName());
			cart.setTotalprice(item.getPrice());
			customer.setCart(cart);
			dao.saveItem(item);
			cdao.saveCart(cart);
			custdao.updateCustomer(customer);
		}
		else
		{
			List<Item> items=c.getItems();
			if(items.size()>0)
			{
				items.add(item);
				c.setItems(items);
				double totalprice=0;
				for(Item i:items) totalprice=totalprice+i.getPrice();
				c.setTotalprice(totalprice);
				customer.setCart(c);
				
				dao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
			else
			{
				List<Item> itemlist=new ArrayList<>();
				itemlist.add(item);
				c.setItems(itemlist);
				c.setTotalprice(item.getPrice());
				dao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
			
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://displayallproducts");
		
		
		
		
		return mav;
				
	}

}
