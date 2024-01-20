package com.akesh.co.ShopProj.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akesh.co.ShopProj.models.Product;
import com.akesh.co.ShopProj.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	
	private ProductService productService;
	
	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/fetch")
	public List<Product> getProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")//url parameter eg:12
	public Product getSingProduct(@PathVariable(name ="id") Long id)
	{
		return productService.getProductById(id);
	}
	
	
	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable(name="name") String name)
	
	{
		return productService.getProductByName(name);
		
	}
	
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(name="id") Long id,@RequestBody Product product)
	
	{
		return productService.updateProduct(product, id);
	}
	
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product)// it is used to convert JSON/XML to objetcs
	{
		
		Product insertedProduct=productService.createProduct(product);
		
		return insertedProduct;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> deleteProduct(@PathVariable(name ="id") Long id)
	{
		productService.deleteProduct(id);
		
		Map<String, String> response=new HashMap<>();
		
		response.put("message", "Delete SUCCESS");
		
		return response;
		
	}
	
}
