package com.abyssinia.eauction.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.abyssinia.eauction.domain.Category;
import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.exception.NoProductsFoundUnderCategoryException;
import com.abyssinia.eauction.exception.ProductNotFoundException;
import com.abyssinia.eauction.service.CustomerService;
import com.abyssinia.eauction.service.ProductService;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
 
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	@RequestMapping("/all")
	public ModelAndView allCustomers() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("products", customerService.getAllCustomers());
		modelAndView.setViewName("customers");
		return modelAndView;
	}

	
//	@RequestMapping("/customer")
//	public String getCustomerByCustomerId(Model model, @RequestParam("id") String customerId) {
//
//		Customer customer = customerService.getCustomerByCustomerId(customerId);
//		model.addAttribute("customer", customer);
//		return "customer";
//	}
//
//	@RequestMapping("/delete")
//	public String deleteCustomerByCustomerId(Model model, @RequestParam("id") String customerId) {
//		Customer customer = customerService.getCustomerByCustomerId(customerId);
//		customerService.deleteCustomer(customer);
//		return "redirect:/customer";
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
	   return "addCustomer";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") @Valid Customer customerToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addCustomer";
		}
 		
			customerService.addCustomer(customerToBeAdded);
		
	   	return "redirect:/customers";
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidProductId", exception.getProductId());
		 mav.addObject("exception", exception);
		 mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		 mav.setViewName("productNotFound");
		 return mav;
	}
	
 
}
