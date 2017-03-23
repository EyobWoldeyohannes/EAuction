package com.abyssinia.eauction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abyssinia.eauction.domain.Bid;
import com.abyssinia.eauction.domain.BiddableProduct;
import com.abyssinia.eauction.domain.Product;
import com.abyssinia.eauction.exception.ProductNotFoundException;
import com.abyssinia.eauction.service.BidService;
import com.abyssinia.eauction.service.BiddableProductService;
import com.abyssinia.eauction.service.CustomerService;
import com.abyssinia.eauction.service.ProductService;


@Controller
@RequestMapping("/biddables")
public class BiddableProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BiddableProductService biddableProductService;
 
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BidService bidService;
 

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("biddableProducts", biddableProductService.getAllBiddableProducts());
		//model.addAttribute("biddableProducts", biddableProductService.getAllBiddableProductsFromParent());
		
		model.addAttribute("customer", null);
		return "biddableProducts";
	}
	
	@RequestMapping(value= "/sold", method = RequestMethod.GET)
	public @ResponseBody void sold(@RequestParam("id") long biddableProductId) {
		//try{
		BiddableProduct biddableProductToUpdateToSold = biddableProductService.getBiddableProductById(biddableProductId);
		biddableProductToUpdateToSold.setStatus("SOLD");
		
		biddableProductService.addBiddableProduct(biddableProductToUpdateToSold);
//		}catch(Exception e){
//			System.out.println("Exception "+e);
//		}
		System.out.println("In sold controller");
		
		//return "SOLD";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Bid create(@RequestBody Bid bid, HttpServletRequest request){
		
		System.out.println("in the BID controller......."+ bid.toString());
		//Bid newBid = bidService.getBidById(bid.getId());
		Long tempId=null;
		//Bid newBid = bidService.getBidByCustomerIdAndBiddableProductId(bid.getCustomer().getId(),bid.getBiddableProduct().getId());
		Bid newBid = bidService.getBidByCustomerIdAndBiddableProductId(bid.getCUSTOMER_ID(),bid.getBIDDABLE_PRODUCT_ID());
		
		
		if(newBid !=null){
			BiddableProduct bp = biddableProductService.getBiddableProductById(bid.getBIDDABLE_PRODUCT_ID());
			System.out.println(bp.toString());

			double x = bp.getSoldPrice();
			bp.setSoldPrice(newBid.getAmount() + x);
			biddableProductService.addBiddableProduct(bp);
			
			double newAmount = newBid.getAmount() + bid.getAmount();
			newBid.setAmount(newAmount);
			newBid.setSoldPrice(biddableProductService.getBiddableProductById(bid.getBIDDABLE_PRODUCT_ID()).getSoldPrice());
			
			bidService.addBid(newBid);
			tempId = newBid.getId();
			
		}
		else{
			BiddableProduct b = biddableProductService.getBiddableProductById(bid.getBIDDABLE_PRODUCT_ID());
			double x = b.getBidPrice();
			
			bid.setSoldPrice(x + bid.getAmount());
			
			b.setSoldPrice(x + bid.getAmount());
			
			bidService.addBid(bid);
			
			biddableProductService.addBiddableProduct(b);
			
			tempId = bid.getId();
		}
		
		
		return (Bid)bidService.getBidById(tempId);
	
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

	
//	@RequestMapping("/filter/{ByCriteria}")
//	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
//		model.addAttribute("products", productService.getProductsByFilter(filterParams));
//		return "products";
//	}
	
	@RequestMapping("/biddableProduct")
	public String getBiddableProductByProductId(Model model, @RequestParam("id") String productId) {

		BiddableProduct biddableProduct = biddableProductService.getBiddableProductByProductId(productId);
		model.addAttribute("biddableProduct", biddableProduct);
		return "biddableProduct";
	}

	@RequestMapping("/delete")
	public String deleteBiddableProductByProductId(Model model, @RequestParam("id") String productId) {
		BiddableProduct biddableProduct = biddableProductService.getBiddableProductByProductId(productId);
		biddableProductService.deleteBiddableProduct(biddableProduct);
		return "redirect:/biddableProducts";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewBiddableProductForm(@RequestParam(value="id") String productId, @ModelAttribute("newBiddableProduct") BiddableProduct biddableProduct, Model model) {
		Product product = productService.getProductByProductId(productId);
		model.addAttribute("product", product);
		
		return "addBiddableProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewBiddableProductForm(@ModelAttribute("newBiddableProduct") @Valid BiddableProduct biddableProductToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addBiddableProduct";
		}
		
		Product product = productService.getProductByProductId(biddableProductToBeAdded.getProductId());
		product.setBiddable(true);
		productService.addProduct(product);
		
		biddableProductToBeAdded.setBiddable(true);
		biddableProductService.addBiddableProduct(biddableProductToBeAdded);
		
	   	return "redirect:/biddables";
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
