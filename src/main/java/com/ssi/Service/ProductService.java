package com.ssi.Service;

import java.util.List;

import com.ssi.models.Product;

public interface ProductService {
	public Product productDetails(int code);
	public Product saveProduct(Product product);
	public Product deleteProduct(int code);
	public List<Product> getAllProducts();
	public List<Product> getAllProductsInRange(int min,int max);

}
