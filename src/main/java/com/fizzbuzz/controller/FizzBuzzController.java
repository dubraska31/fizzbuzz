package com.fizzbuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fizzbuzz.dto.FizzBuzzResponse;
import com.fizzbuzz.entity.FizzBuzzTransacciones;
import com.fizzbuzz.services.FizzBuzzService;

@RestController
public class FizzBuzzController {
	
	@Autowired
	FizzBuzzService fizzBuzzService;
	
	@GetMapping("/fizzbuzz/{min}/{max}")
	public FizzBuzzResponse fizzbuzz(@PathVariable("min") int min, @PathVariable("max") int max) {
		
		return fizzBuzzService.getFizzBuzz(min, max);
	}
	
	@GetMapping("/transacciones")
	public List<FizzBuzzTransacciones> getTransacciones() {
		
		return fizzBuzzService.getTransacciones();
	}
	
	
}
