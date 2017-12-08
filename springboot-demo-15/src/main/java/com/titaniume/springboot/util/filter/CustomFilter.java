package com.titaniume.springboot.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 自定义Filter   注解方式
 * @author titaniume
 * 2017年12月7日下午4:33:33
 *
 */
@WebFilter(urlPatterns="/*")   //拦截全部
public class CustomFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter filter");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter");
		
	}

}
