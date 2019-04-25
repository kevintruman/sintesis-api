package com.dev.lms.sintesisapi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
	Map<String, Object> reg(@RequestBody Map<String, Object> map) {
		Map<String, Object> m = new HashMap<>();
		
		m.put("status_code", "1");
		m.put("status", "success");
		m.put("message", "y");
		m.put("data", null);
		
		toJson(map, true);
		String path = "/data/generated/sid/log-sintesis-reg-karyawan/";
        String filename = map.get("employee_id") + "-" + new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()) + ".json";
		objectToJsonFile(path, filename, map);
		
		return m;
	}
	
	public String toJson(Object obj, boolean print) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		
		Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gsonb.toJson(je);
		if (print)
			System.out.println("[Print " + new Date() + "] :\n" + prettyJsonString + "\n[Print]");
		return prettyJsonString;
	}
	
	public void objectToJsonFile(String path, String filename, Object content) {
		try {
			File folder = new File(path);
			if (!folder.exists())
				folder.mkdirs();
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File(path + filename)));
			o.writeObject(toJson(content, false));
			o.flush();
			o.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
