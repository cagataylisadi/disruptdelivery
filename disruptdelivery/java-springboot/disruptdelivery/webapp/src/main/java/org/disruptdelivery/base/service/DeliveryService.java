package org.disruptdelivery.base.service;

import org.disruptdelivery.base.domain.Address;
import org.disruptdelivery.base.domain.Delivery;
import org.disruptdelivery.base.domain.Offer;
import org.disruptdelivery.base.domain.Order;
import org.disruptdelivery.base.repository.AddressRepository;
import org.disruptdelivery.base.repository.DeliveryRepository;
import org.disruptdelivery.base.repository.OrderRepository;
import org.disruptdelivery.base.service.interfaces.DeliverySerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeliveryService implements DeliverySerInterface {

	@Autowired
	DeliveryRepository deliveryRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Delivery createDelivery(Offer offer){
		Delivery delivery = new Delivery();
		delivery.setExpected_delivery_time(offer.getExpected_delivery_datetime());
		delivery.setOrderid(offer.getOrderid());
		delivery.setCost_in_cents(offer.getPrice_in_cents());
		delivery.setStatus("PACKING");
		deliveryRepository.save(delivery);
		return delivery;
	}

	@Override
	public Delivery getDeliveryById(Long deliveryid){
		return deliveryRepository.getDeliveryById(deliveryid);
	}

	@Override
	public Map<Delivery, Address> getAllDeliveries(){
		List<Delivery> deliveries = deliveryRepository.getActiveDeliveries();
		Map<Delivery, Address> map = new HashMap<>();
		for(Delivery delivery : deliveries){
			Optional<Order> order = orderRepository.findById(delivery.getOrderid());
			if (order.isPresent()){
				Optional<Address> address = addressRepository.findById(order.get().getReceiver_address_id());
				address.ifPresent(value -> map.put(delivery, value));
			}
		}
		return map;
	}

	@Override
	public Map<Delivery, Address> getDeliveryInformation(Long deliveryid){
		Map<Delivery, Address> map = new HashMap<>();
		Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryid);
		if (deliveryOptional.isPresent()){
			Optional<Order> order = orderRepository.findById(deliveryOptional.get().getOrderid());
			if (order.isPresent()){
				Optional<Address> address = addressRepository.findById(order.get().getReceiver_address_id());
				address.ifPresent(value -> map.put(deliveryOptional.get(), value));
			}
		}
		return map;
	}

	@Override
	public void updateDeliveryToOTW(Long deliveryid){
		Optional<Delivery> delivery = deliveryRepository.findById(deliveryid);
		if(delivery.isPresent()){
			Delivery del = delivery.get();
			del.setStatus("ON THE WAY");
			deliveryRepository.save(del);
		}

	}

	@Override
	public void updateDeliveryToFailed(Long deliveryid){
		Optional<Delivery> delivery = deliveryRepository.findById(deliveryid);
		if(delivery.isPresent()){
			Delivery del = delivery.get();
			del.setStatus("FAILED");
			deliveryRepository.save(del);
		}

	}

	@Override
	public void updateDeliveryToDelivered(Long deliveryid){
		Optional<Delivery> delivery = deliveryRepository.findById(deliveryid);
		if(delivery.isPresent()){
			Delivery del = delivery.get();
			del.setStatus("DELIVERED");
			deliveryRepository.save(del);
		}

	}

	@Override
	public void updateDelivery(Delivery delivery){
		deliveryRepository.save(delivery);
	}

}
