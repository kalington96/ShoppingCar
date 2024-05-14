package com.jsp.ShoppingCart.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Intializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] c= {ClassConfig.class};
		return c;
	}

	@Override
	protected String[] getServletMappings() {
		String[] str= {"/"};
		return str;
	}

}
