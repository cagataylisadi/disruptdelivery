package org.disruptdelivery.base.service;

import org.disruptdelivery.base.domain.Address;
import org.disruptdelivery.base.domain.Order;
import org.disruptdelivery.base.domain.OrderForm;
import org.disruptdelivery.base.repository.AddressRepository;
import org.disruptdelivery.base.repository.OrderRepository;
import org.disruptdelivery.base.service.interfaces.OrderSerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderSerInterface {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findOrderById(Long orderid){
		return orderRepository.findById(orderid);
	}

	@Override
	public Order updateOrder(Order order){
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order createOrder(OrderForm form){
		Order order = new Order();
		Address sender = new Address();
		Address receiever = new Address();
		sender.setName(form.getAddress_name1());
		sender.setStreet_and_number(form.getAddress_street_and_number1());
		sender.setZipcode(form.getAddress_zipcode1());
		sender.setCity(form.getAddress_city1());
		sender.setCountry(form.getCountry1());
		receiever.setName(form.getAddress_name2());
		receiever.setStreet_and_number(form.getAddress_street_and_number2());
		receiever.setZipcode(form.getAddress_zipcode2());
		receiever.setCity(form.getAddress_city2());
		receiever.setCountry(form.getCountry2());
		addressRepository.save(sender);
		addressRepository.save(receiever);
		order.setSend_date(LocalDateTime.now());
		order.setSender_address_id(sender.getAddressid());
		order.setReceiver_address_id(receiever.getAddressid());
		order.setProductid(form.getProductid());
		orderRepository.save(order);
		return order;
	}

}
