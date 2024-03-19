package com.ssi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.Service.ProductService;
import com.ssi.models.Product;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@DeleteMapping(value="{id}",produces="application/json")
	public Product deleteProduct(@PathVariable("id")int code)
	{
		Product product=productService.deleteProduct(code);
		return product;
	}
	
	@PutMapping(produces="application/json",consumes="appliaction/json")
	public Product updateProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return product;
	}
	
	@PostMapping(produces="application/json",consumes="appliaction/json")
	public Product addProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return product;
	}
	
	@GetMapping(value="json/{low}/{high}" ,produces="application/json")
	public List<Product> getAllProductAsJsonInRange(@PathVariable("low")int min,@PathVariable("high")int max)
	{
		return productService.getAllProductsInRange(min,max);
	}
	
	
	@GetMapping(value="json" ,produces="application/json")
	public List<Product> getAllProductAsJson()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping(value="xml" ,produces="application/xml")
	public List<Product> getAllProductAsXml()
	{
		return productService.getAllProducts();
	}
	//@RequestMapping(value="product",method=RequestMethod.GET)
	@GetMapping(value="{id}")
	public String getSingleProduct(@PathVariable("id")int code)
	{
		Product product=productService.productDetails(code);
		return product.toString();
	}
	@GetMapping(value="json/{id}" ,produces="application/json")
	public Product getSingleProductByJson(@PathVariable("id")int code)
	{
		Product product=productService.productDetails(code);
		return product;
	}
	
	@GetMapping(value="xml/{id}" ,produces="application/xml")
	public Product getSingleProductByXml(@PathVariable("id")int code)
	{
		Product product=productService.productDetails(code);
		return product;
	}

	
}
