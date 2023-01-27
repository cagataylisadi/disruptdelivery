package org.disruptdelivery.base.service;

import org.disruptdelivery.base.domain.Product;
import org.disruptdelivery.base.repository.ProductRepository;
import org.disruptdelivery.base.service.interfaces.ProductSerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductSerInterface {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

}
