package org.disruptdelivery.base.service;

import org.disruptdelivery.base.domain.Offer;
import org.disruptdelivery.base.domain.Order;
import org.disruptdelivery.base.service.interfaces.OfferSerInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService implements OfferSerInterface {

	@Override
	public List<Offer> createOffers(Order order){
		List<Offer> offers = new ArrayList<>();
		for(int i=0;i<3;i++){
			Offer offer = new Offer();
			offer.setOrderid(order.getOrderid());
			offer.setPrice_in_cents(((i*i)+5)*10);
			LocalDateTime datetime = order.getSend_date();
			offer.setExpected_delivery_datetime(datetime.plusDays(i*2+1));
			offers.add(offer);
		}
		return offers;
	}

}
