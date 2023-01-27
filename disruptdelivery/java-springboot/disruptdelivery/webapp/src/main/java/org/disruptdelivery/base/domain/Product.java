package org.disruptdelivery.base.domain;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productid;
	@Column(name = "model_name")
	String model_name;
	@Column(name = "model_no")
	String model_no;
	@Column(name = "x_in_mm")
	int x_in_mm;
	@Column(name = "y_in_mm")
	int y_in_mm;
	@Column(name = "z_in_mm")
	int z_in_mm;
	@Column(name = "is_breakable")
	boolean is_breakable;
	@Column(name = "is_perishable")
	boolean is_perishable;

	public Product(){}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getModel_no() {
		return model_no;
	}

	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}

	public int getX_in_mm() {
		return x_in_mm;
	}

	public void setX_in_mm(int x_in_mm) {
		this.x_in_mm = x_in_mm;
	}

	public int getY_in_mm() {
		return y_in_mm;
	}

	public void setY_in_mm(int y_in_mm) {
		this.y_in_mm = y_in_mm;
	}

	public int getZ_in_mm() {
		return z_in_mm;
	}

	public void setZ_in_mm(int z_in_mm) {
		this.z_in_mm = z_in_mm;
	}

	public boolean isIs_breakable() {
		return is_breakable;
	}

	public void setIs_breakable(boolean is_breakable) {
		this.is_breakable = is_breakable;
	}

	public boolean isIs_perishable() {
		return is_perishable;
	}

	public void setIs_perishable(boolean is_perishable) {
		this.is_perishable = is_perishable;
	}

}
