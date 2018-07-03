package com.ryanzhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	private String message = "Hello, please add '/swagger-ui.html#' "
			+ "to the end of the url to view the swagger documentation for the api or click below";
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message", message);
		return "home";
	}
}



