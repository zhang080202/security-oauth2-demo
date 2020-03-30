package com.fly.oauth.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping("/order/{id}")
	public String order(@PathVariable("id") String id) {
		return "order id is" + id;
	}
	
	@GetMapping("/product/{id}")
	public String product(@PathVariable("id") String id) {
		return "product id is" + id;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test request";
	}

}
