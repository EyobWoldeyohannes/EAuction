package com.abyssinia.eauction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {


	@RequestMapping({"/", "/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome E-Auction!");
		model.addAttribute("tagline", "The one and only pace bid and win");
		
		return "welcome";
	}
 
}
