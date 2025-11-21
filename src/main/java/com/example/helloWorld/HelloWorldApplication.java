package com.example.helloWorld;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping("/sum")
	public String sum(@RequestParam(value = "numbers", required = false) List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return "No numbers provided. Use ?numbers=1&numbers=2&numbers=3";
		}
		int result = 0;
		for (int el : numbers) {
			result += el;
		}
//		int total = numbers.stream().mapToInt(Integer::intValue).sum();
		return "Sum: " + result;
	}
}
