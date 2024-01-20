package com.akesh.co.ShopProj.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akesh.co.ShopProj.Repos.ProductRepository;
import com.akesh.co.ShopProj.models.Product;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	
	@Autowired// constructor injection to create object.
	public ProductService(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}
	
	
	
	public Product createProduct(Product product)
	
	{
		return productRepository.save(product);
		
	}
		public List<Product> getAllProducts()
		
		{
			return productRepository.findAll();
		}
		
	
		
		public Product getProductByName(String name)
		
		{
			
			return productRepository.findProductByName(name);
		}
		
		public Product updateProduct(Product product,Long id)
		
		{
			Optional<Product> productoptional=productRepository.findById(id);
			
			if(productoptional.isPresent())
			{
				Product productToUpate=productoptional.get();
				productToUpate.setName(product.getName());
				productToUpate.setPrice(product.getPrice());
				productToUpate.setQuanity(product.getQuanity());
				
				return productRepository.save(productToUpate);
			}
			throw new RuntimeException("Product not found");
		}
		

		public Product getProductById(Long id)
		
		{
			Optional<Product> productOptional=productRepository.findById(id);
			
			if(productOptional.isPresent())
			{
				return productOptional.get();
			}
			

			throw new RuntimeException("Product not found");
			
		}


	
		public void deleteProduct(Long id)
		{
			Optional<Product> productOptional=productRepository.findById(id);
			if(productOptional.isPresent())
			{
				productRepository.deleteById(id);
			}
			else

			{throw new RuntimeException("Product not found");
			}
		}

}

