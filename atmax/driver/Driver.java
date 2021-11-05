package com.atmax.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atmax.service.AtmaxSerivce;
import com.atmax.service.impl.AtmaxServiceImpl;

public class Driver {
	public static void main(String[] args)throws Exception {
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AtmaxSerivce service =  ac.getBean("service",AtmaxServiceImpl.class);
		service.insert("Tushar", "Sharma");
		//service.select("Vansh");
		//service.selectAll();
		//service.delete("Sahil");
		//service.updateFirstName("Vansh","Akshay");
	}
}
