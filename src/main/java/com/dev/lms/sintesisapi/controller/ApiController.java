package com.dev.lms.sintesisapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@GetMapping("/users/{kode}")
	List<String> user(@PathVariable String kode){
		return new ArrayList<String>();
	}
	
	@PostMapping("/users")
	Map<String, Object> reg() {
		Map<String, Object> m = new HashMap<>();
		m.put("status_code", "1");
		m.put("status", "success");
		m.put("message", "y");
		return m;
	}

}
