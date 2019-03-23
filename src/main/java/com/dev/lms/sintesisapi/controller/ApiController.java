package com.dev.lms.sintesisapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
	Map<String, Object> user(@PathVariable String kode) {
		Map<String, Object> m = new HashMap<>();
		m.put("users", new ArrayList<String>());
		return m;
	}

	@PostMapping("/users")
	Map<String, Object> reg() {
		Map<String, Object> m = new HashMap<>();
		m.put("status_code", "1");
		m.put("status", "success");
		m.put("message", "y");
		m.put("data", null);
		return m;
	}

}
