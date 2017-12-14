package com.titaniume.springboot.util.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;
/**
 * 监控 servlet
 * @author titaniume
 * 2017年12月14日上午12:54:16
 *
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "titaniume"),
		@WebInitParam(name = "loginPassword", value = "titaniume") })
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;
}