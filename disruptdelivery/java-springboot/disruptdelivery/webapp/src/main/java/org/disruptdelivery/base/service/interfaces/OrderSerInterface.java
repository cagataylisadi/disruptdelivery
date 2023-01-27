package org.disruptdelivery.base.service.interfaces;

import org.disruptdelivery.base.domain.Order;
import org.disruptdelivery.base.domain.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrderSerInterface {

	Order createOrder(OrderForm form);

	Optional<Order> findOrderById(Long orderid);

	Order updateOrder(Order order);

	List<Order> getAllOrders();

}
