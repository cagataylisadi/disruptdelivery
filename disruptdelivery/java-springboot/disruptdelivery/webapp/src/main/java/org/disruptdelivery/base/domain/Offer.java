package org.disruptdelivery.base.domain;

import java.time.LocalDateTime;

public class Offer {
	Long orderid;
	int price_in_cents;
	LocalDateTime expected_delivery_datetime;

	public Offer(){}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public int getPrice_in_cents() {
		return price_in_cents;
	}

	public void setPrice_in_cents(int price_in_cents) {
		this.price_in_cents = price_in_cents;
	}

	public LocalDateTime getExpected_delivery_datetime() {
		return expected_delivery_datetime;
	}

	public void setExpected_delivery_datetime(LocalDateTime expected_delivery_datetime) {
		this.expected_delivery_datetime = expected_delivery_datetime;
	}
}
