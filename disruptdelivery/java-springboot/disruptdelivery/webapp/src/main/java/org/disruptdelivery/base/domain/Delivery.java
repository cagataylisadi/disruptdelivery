package org.disruptdelivery.base.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long deliveryid;
	@Column(name = "expected_delivery_time")
	LocalDateTime expected_delivery_time;
	@Column(name = "actual_delivery_time")
	LocalDateTime actual_delivery_time;
	@Column(name = "orderid")
	Long orderid;
	@Column(name = "cost_in_cents")
	int cost_in_cents;
	@Column(name = "status")
	String status;

	public Delivery(){}

	public Long getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(Long deliveryid) {
		this.deliveryid = deliveryid;
	}

	public LocalDateTime getExpected_delivery_time() {
		return expected_delivery_time;
	}

	public void setExpected_delivery_time(LocalDateTime expected_delivery_time) {
		this.expected_delivery_time = expected_delivery_time;
	}

	public LocalDateTime getActual_delivery_time() {
		return actual_delivery_time;
	}

	public void setActual_delivery_time(LocalDateTime actual_delivery_time) {
		this.actual_delivery_time = actual_delivery_time;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public int getCost_in_cents() {
		return cost_in_cents;
	}

	public void setCost_in_cents(int cost_in_cents) {
		this.cost_in_cents = cost_in_cents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
