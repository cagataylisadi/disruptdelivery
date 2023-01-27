package org.disruptdelivery.base.service.interfaces;

import org.disruptdelivery.base.domain.Offer;
import org.disruptdelivery.base.domain.Order;

import java.util.List;

public interface OfferSerInterface {

	List<Offer> createOffers(Order order);
}
