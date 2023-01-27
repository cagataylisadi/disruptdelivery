package org.disruptdelivery.base.controller;

import org.disruptdelivery.base.domain.Delivery;
import org.disruptdelivery.base.domain.Offer;
import org.disruptdelivery.base.domain.OrderForm;
import org.disruptdelivery.base.service.DeliveryService;
import org.disruptdelivery.base.service.OfferService;
import org.disruptdelivery.base.service.OrderService;
import org.disruptdelivery.base.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(value = "/")
	public String redirectToIndex(){
		return "redirect:/index";
	}

	@RequestMapping(value = "/index")
	public String index(){
		return "index";
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String showForm(Model model){
		model.addAttribute("products",productService.getAllProducts());
		model.addAttribute("orderForm",new OrderForm());
		return "/shopper/createorder";
	}

	@RequestMapping(value = "/offering", method = RequestMethod.POST)
	public String insertForm(Model model, @ModelAttribute(name = "orderForm") OrderForm orderForm){
		model.addAttribute("offer", new Offer());
		model.addAttribute("offers",offerService.createOffers(orderService.createOrder(orderForm)));
		return "/shopper/offers";
	}

	@RequestMapping(value = "/delivery", method = RequestMethod.POST)
	public String sendDeliveryId(Model model, @ModelAttribute(name = "offer")Offer offer){
		model.addAttribute("delivery",deliveryService.createDelivery(offer));
		return "/shopper/delivery";
	}

	@RequestMapping(value = "/tracker", method = RequestMethod.GET)
	public String trackDeliveryInput(Model model){
		model.addAttribute("offer",new Offer());
		return "/shopper/trackerinput";
	}

	@RequestMapping(value = "/tracker", method = RequestMethod.POST)
	public String trackDeliveryFind(Model model, @ModelAttribute(name = "offer") Offer offer){
		Delivery delivery = deliveryService.getDeliveryById(offer.getOrderid());
		if (delivery != null){
			model.addAttribute("delivery", delivery);
			return "/shopper/tracker";
		}
		return "error";
	}

	@RequestMapping(value = "/deliver", method = RequestMethod.GET)
	public String deliverOrder(Model model){
		model.addAttribute("deliverinfo", deliveryService.getAllDeliveries());
		model.addAttribute("offer", new Offer());
		return "/deliverer/deliver";
	}

	@RequestMapping(value = "/deliver/start", method = RequestMethod.POST)
	public String startOrder(Model model, @ModelAttribute(name = "offer") Offer offer){
		deliveryService.updateDeliveryToOTW(offer.getOrderid());
		model.addAttribute("deliverinfo", deliveryService.getDeliveryInformation(offer.getOrderid()));
		Offer send = new Offer();
		send.setOrderid(offer.getOrderid());
		model.addAttribute("offerF", send);
		model.addAttribute("offerS", send);
		return "/deliverer/action";
	}

	@RequestMapping(value = "/deliver/fail", method = RequestMethod.POST)
	public String finishedOrderFail(Model model, @ModelAttribute(name = "offer") Offer offer){
		deliveryService.updateDeliveryToFailed(offer.getOrderid());
		return "redirect:/deliver";
	}

	@RequestMapping(value = "/deliver/success", method = RequestMethod.POST)
	public String finishedOrderSuccess(Model model, @ModelAttribute(name = "offer") Offer offer){
		deliveryService.updateDeliveryToDelivered(offer.getOrderid());
		return "redirect:/deliver";
	}

}

