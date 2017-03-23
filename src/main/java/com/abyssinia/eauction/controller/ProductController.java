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
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
 
	@Autowired
	private CustomerService customerService;
 

	@RequestMapping
	public String list(Model model) {
		//model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("products", productService.getAllUnbiddableProducts());
		return "products";
	}
	
	@RequestMapping("/all")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
//	@RequestMapping("/{category}")
//	public String getProductsByCategory(Model model, @PathVariable("category") Category category) {
//		List<Product> products = productService.getProductsByCategory(category);
//
//		if (products == null || products.isEmpty()) {
//			throw new NoProductsFoundUnderCategoryException();
//		}
//
//		model.addAttribute("products", products);
//		return "products";
//	}

	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductByProductId(Model model, @RequestParam("id") String productId) {

		Product product = productService.getProductByProductId(productId);
		model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping("/delete")
	public String deleteProductByProductId(Model model, @RequestParam("id") String productId) {
		Product product = productService.getProductByProductId(productId);
		productService.deleteProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}

 		MultipartFile productImage = productToBeAdded.getProductImage();
 		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+productToBeAdded.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

		try {
			
			Customer c = new Customer("Eyob","Mar", 29, "Male", "sdfsdf", "Address");
			customerService.addCustomer(c);
			
			productService.addProduct(productToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/products";
	}
	

	// CACHING example
	// If you WATCH the logging on the console.. you will see MUTIPLE fetches from the DB for P1234
	// AND ONLY one fetch for P1235
	
	
 
//	
//	@RequestMapping(value = "/fetch" )
//	public String processFetchTest(Model model ) {
//		
//		List<Product> productList = productService.getProductsByDescOrder();
//		
//		for (Product pp: productList) {
//		   System.out.println(pp.getProductId());
//		}
//		
//	return "products";
//
//	}
	
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
