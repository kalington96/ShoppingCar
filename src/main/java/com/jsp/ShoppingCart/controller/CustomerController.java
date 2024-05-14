package com.jsp.ShoppingCart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CustomerDao;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Merchant;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer()
	{
		Customer customer=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj",customer);
		mav.setViewName("customerform");
		return mav;
	}
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj")Customer c)
	{
		dao.saveCustomer(c);
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","data will be saved");
		mav.setViewName("customermenu");
		return mav;
	}
	@RequestMapping("/loginvalid")
	public ModelAndView login(ServletRequest req , HttpSession session)
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Customer c=dao.login(email, password);
		ModelAndView mav=new ModelAndView();
		if(c!=null) {
			mav.addObject("msg", "sucessfully login");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo", c);
			return mav;
		}
		else
		{
			mav.addObject("msg", "Invalid credentials");
			mav.setViewName("customerloginform");
			return mav;
		}
	}

}
