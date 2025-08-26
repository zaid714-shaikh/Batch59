package com.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = NullPointerException.class)
	public String globalNullpointer(Model model)
	{
		model.addAttribute("msg", "Credetials Invalid");
		System.out.println("GLobal Nullpointer exception handles here");
		return "error";
	}
	
}
