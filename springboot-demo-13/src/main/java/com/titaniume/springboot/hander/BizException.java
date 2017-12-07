/*package com.titaniume.springboot.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.titaniume.springboot.controller.WebController;

*//**
 * 注解定义异常处理
 * @author titaniume
 * 2017年12月7日下午2:27:06
 * 
 *
 *//*
@ControllerAdvice
public class BizException {
	
	private static final Logger Logger = LoggerFactory.getLogger(BizException.class);
	*//**
	 * 统一异常处理
	 * 
	 * @param exception
	 *  exception
	 * @return
	 *//*
	@ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException exception) {
		Logger.info("自定义异常处理-RuntimeException-");
		ModelAndView m = new ModelAndView();
		m.addObject("roncooException", exception.getMessage());
		m.setViewName("error/500");
		return m;
	}

	*//**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            exception
	 * @return
	 *//*
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(Exception exception) {
		Logger.info("自定义异常处理-Exception");
		ModelAndView m = new ModelAndView();
		m.addObject("roncooException", exception.getMessage());
		m.setViewName("error/500");
		return m;
	}

}
*/