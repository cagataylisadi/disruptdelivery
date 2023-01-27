package org.disruptdelivery.base.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long orderid;
	@Column(name = "send_date")
	LocalDateTime send_date;
	@Column(name = "sender_address_id")
	Long sender_address_id;
	@Column(name = "receiver_address_id")
	Long receiver_address_id;
	@Column(name = "productid")
	Long productid;
	@Column(name = "label")
	String label;

	public Order(){}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public LocalDateTime getSend_date() {
		return send_date;
	}

	public void setSend_date(LocalDateTime send_date) {
		this.send_date = send_date;
	}

	public Long getSender_address_id() {
		return sender_address_id;
	}

	public void setSender_address_id(Long sender_address_id) {
		this.sender_address_id = sender_address_id;
	}

	public Long getReceiver_address_id() {
		return receiver_address_id;
	}

	public void setReceiver_address_id(Long receiver_address_id) {
		this.receiver_address_id = receiver_address_id;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

}
