package com.example.helloWorld;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping("/sum-form")
	public String showSumForm() {
		return "sum";
	}

	@GetMapping("/sum")
	public String sum(@RequestParam(value = "numbers", required = false) List<Integer> numbers, Model model) {
		if (numbers == null || numbers.isEmpty()) {
			model.addAttribute("result", "No numbers provided");
		}
		int result = 0;
		for (int el : numbers) {
			result += el;
		}
		model.addAttribute("result", result);
		return "sum";
	}
}
