package com.fizzbuzz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fizzbuzz.dto.FizzBuzzResponse;

@SpringBootTest
public class FizzBuzzControllerTest {
	
	@Autowired
	FizzBuzzController fizzBuzzController;

	@Test
	public void probarFizzBuzzDelUnoALQuince() {
		
		FizzBuzzResponse fizzBuzzResponse = fizzBuzzController.fizzbuzz(1, 15);
		
		String expectedCode = "001";
		String expectedDescription = "se encontraron múltiplos de 3 y 5";
		String expectedList = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";
		
		assertEquals(expectedCode, fizzBuzzResponse.getCode());
		assertEquals(expectedDescription, fizzBuzzResponse.getDescription());
		assertEquals(expectedList, fizzBuzzResponse.getList());
	
	}	
	
	@Test
	public void probarFizzBuzzDelUnoAlTres() {
		
		FizzBuzzResponse fizzBuzzResponse = fizzBuzzController.fizzbuzz(1, 3);
		
		String expectedCode = "002";
		String expectedDescription = "se encontraron múltiplos de 3";
		String expectedList = "1,2,Fizz";
		
		assertEquals(expectedCode, fizzBuzzResponse.getCode());
		assertEquals(expectedDescription, fizzBuzzResponse.getDescription());
		assertEquals(expectedList, fizzBuzzResponse.getList());
	}
	
	
}
