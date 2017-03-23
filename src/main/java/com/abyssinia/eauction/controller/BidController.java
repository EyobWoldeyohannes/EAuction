package com.abyssinia.eauction.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abyssinia.eauction.domain.Bid;
import com.abyssinia.eauction.domain.BidId;
import com.abyssinia.eauction.domain.Customer;
import com.abyssinia.eauction.service.BidService;
import com.abyssinia.eauction.service.CustomerService;

@Controller
@RequestMapping("/bids")
public class BidController {
	
	@Autowired
	private BidService bidService;
	
//	@RequestMapping( method = RequestMethod.POST)
//	public String processAddNewCustomerForm(@ModelAttribute("bid") @Valid Bid bid, HttpServletRequest request) {
////		if(result.hasErrors()) {
////			return "addCustomer";
////		}
// 		Long tempId=null;
//		Bid newBid = bidService.getBidByCustomerIdAndBiddableProductId(bid.getCustomer().getId(),bid.getBiddableProduct().getId());
//		
//		if(newBid !=null){
////			BigDecimal newAmount = newBid.getAmount().add(bid.getAmount());
////			newBid.setAmount(newAmount);
////			
////			bidService.addBid(newBid);
////			tempId = newBid.getId();
//			bidService.addBid(bid);
//			tempId = bid.getId();
//		}
//		else{
//			bidService.addBid(bid);
//			tempId = bid.getId();
//		}
//		
//	   	return "redirect:/customers";
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Bid createGet(@RequestBody Bid bid, HttpServletRequest request){
		
		System.out.println("in the BID controller in get.......");
		return bid;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String create(@RequestBody Bid bid, HttpServletRequest request){
		
		System.out.println("in the BID controller......."+ bid.toString());
//		//Bid newBid = bidService.getBidById(bid.getId());
//		Long tempId=null;
//		//Bid newBid = bidService.getBidByCustomerIdAndBiddableProductId(bid.getCustomer().getId(),bid.getBiddableProduct().getId());
//		Bid newBid = bidService.getBidByCustomerIdAndBiddableProductId(bid.getCUSTOMER_ID(),bid.getBIDDABLE_PRODUCT_ID());
//		
//		if(newBid !=null){
////			BigDecimal newAmount = newBid.getAmount().add(bid.getAmount());
////			newBid.setAmount(newAmount);
////			
////			bidService.addBid(newBid);
////			tempId = newBid.getId();
//			bidService.addBid(bid);
//			tempId = bid.getId();
//		}
//		else{
//			bidService.addBid(bid);
//			tempId = bid.getId();
//		}
//		
		
		//return (Bid)bidService.getBidById(tempId);
		
		return "Okey";
	}
 
}
