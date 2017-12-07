package com.titaniume.springboot.util.annotation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义Servlet   注解方式
 * @author titaniume
 * 2017年12月7日下午4:36:55
 *
 */
@WebServlet(urlPatterns="/method3Servlet",name="customServlet")
public class CustomServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet GET Method!");
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet POST Method!");
		response.getWriter().println("hello CustomServlet!");
	}
	
	

}
