package com.mycervello.adb.config.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class is used to handle all exceptions in one place.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-11-2018
 */
@ControllerAdvice
public class GlobalExceptionsHandler
{
	//
	// Constants
	//
	public static final String DEFAULT_ERROR_VIEW = "error";
	//

	//
	// Public methods
	//
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAnyException(HttpServletRequest request,
		Exception error) throws Exception
	{
		//- if the exception is annotated with @ResponseStatus re-throw it and let the framework
		//handle it
		if (AnnotationUtils.findAnnotation(error.getClass(), ResponseStatus.class) != null)
		{
			throw error;
		}

		//- redirect the user to a default error-view
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", error);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName(DEFAULT_ERROR_VIEW);
		return modelAndView;
	}
	//
}