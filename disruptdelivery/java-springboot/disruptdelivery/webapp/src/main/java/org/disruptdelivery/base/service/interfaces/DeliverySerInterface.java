package org.disruptdelivery.base.service.interfaces;

import org.disruptdelivery.base.domain.Address;
import org.disruptdelivery.base.domain.Delivery;
import org.disruptdelivery.base.domain.Offer;

import java.util.Map;

public interface DeliverySerInterface {

	Delivery createDelivery(Offer offer);

	void updateDelivery(Delivery delivery);

	Delivery getDeliveryById(Long deliveryid);

	Map<Delivery, Address> getAllDeliveries();

	void updateDeliveryToOTW(Long deliveryid);

	void updateDeliveryToDelivered(Long deliveryid);

	void updateDeliveryToFailed(Long deliveryid);

	Map<Delivery, Address> getDeliveryInformation(Long deliveryid);

}
