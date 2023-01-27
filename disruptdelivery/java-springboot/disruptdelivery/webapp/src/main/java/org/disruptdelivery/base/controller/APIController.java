package org.disruptdelivery.base.controller;

import org.aspectj.weaver.ast.Or;
import org.disruptdelivery.base.domain.Delivery;
import org.disruptdelivery.base.domain.LabelForm;
import org.disruptdelivery.base.domain.Offer;
import org.disruptdelivery.base.domain.Order;
import org.disruptdelivery.base.service.DeliveryService;
import org.disruptdelivery.base.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private DeliveryService deliveryService;

	@GetMapping(value = "/order")
	public List<Order> getOrders(){
		return orderService.getAllOrders();
	}

	@PostMapping(value = "/delivery/")
	public Delivery createDelivery(@RequestBody Offer offer){
		return deliveryService.createDelivery(offer);
	}

	@GetMapping(value = "/delivery/{delivery_id}")
	public Delivery getDeliveryById(@PathVariable(value = "delivery_id") Long delivery_id){
		return deliveryService.getDeliveryById(delivery_id);
	}

	@PatchMapping(value = "/delivery/{delivery_id}")
	public String updateDeliveryStatus(@PathVariable(value = "delivery_id") Long delivery_id){
		Delivery delivery = deliveryService.getDeliveryById(delivery_id);
		if (delivery.getStatus().equals("PACKING")){
			delivery.setStatus("ON THE WAY");
		} else if (delivery.getStatus().equals("ON THE WAY")){
			delivery.setStatus("DELIVERED");
		} else if (delivery.getStatus().equals("DELIVERED")){
			delivery.setStatus("FAILED");
		}
		deliveryService.updateDelivery(delivery);
		return delivery.getStatus();
	}

	@PostMapping(value = "/label")
	public Order createLabelOrder(@RequestBody LabelForm labelForm){
		Optional<Order> orderOptional = orderService.findOrderById(labelForm.getOrderid());
		if (orderOptional.isPresent()){
			orderOptional.get().setLabel(labelForm.getLabel());
			return orderService.updateOrder(orderOptional.get());
		}
		return null;
	}

}
