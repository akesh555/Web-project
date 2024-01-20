package com.akesh.co.ShopProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShopProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopProjApplication.class, args);
		
		
	}
    
//	@GetMapping(path="/firstcall") // used to call this function for the route(Get request)
//	public String  sayHello()
//	{
//		return "Babababa";
//		
//	}
	
}
