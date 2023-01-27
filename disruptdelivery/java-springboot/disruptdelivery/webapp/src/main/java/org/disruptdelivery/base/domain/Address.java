package org.disruptdelivery.base.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "addressbook")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long addressid;
	@Column(name = "name")
	String name;
	@Column(name = "street_and_number")
	String street_and_number;
	@Column(name = "zipcode")
	String zipcode;
	@Column(name = "city")
	String city;
	@Column(name = "country")
	String country;

	public Address(){}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet_and_number() {
		return street_and_number;
	}

	public void setStreet_and_number(String street_and_number) {
		this.street_and_number = street_and_number;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
