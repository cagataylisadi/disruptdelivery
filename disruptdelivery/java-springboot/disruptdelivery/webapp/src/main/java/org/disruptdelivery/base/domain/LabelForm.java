package org.disruptdelivery.base.domain;

public class LabelForm {
	private Long orderid;
	private String label;

	public LabelForm(){}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
