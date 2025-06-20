package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Submission;
import com.example.demo.repository.SubmissionRepository;

@RestController
@RequestMapping("/api")
public class SubmissionController {
	   @Autowired
	    private SubmissionRepository repo;

	    // Submit new form data
	    @PostMapping("/submit")
	    public ResponseEntity<Map<String, String>> submit(@RequestBody Submission submission) {
	        repo.save(submission);
	        return ResponseEntity.ok(Map.of("message", "Form submitted successfully"));
	    }
	    
	    @GetMapping("/submissions")
	    public ResponseEntity<List<Map<String, Object>>> getAll() {
	        List<Map<String, Object>> data = repo.findAll().stream().map(s -> {
	            Map<String, Object> map = new HashMap<>();
	            map.put("name", s.getName());
	            map.put("email", s.getEmail());
	            map.put("createdAt", s.getCreatedAt());
	            map.put("ipAddress", s.getIpAddress());

	            String location = String.join(", ",
	                    Optional.ofNullable(s.getCity()).orElse(""),
	                    Optional.ofNullable(s.getState()).orElse(""),
	                    Optional.ofNullable(s.getCountry()).orElse(""));
	            map.put("location", location.trim());

	            map.put("systemInfo", s.getSystemInfo());
	            map.put("browserInfo", s.getBrowserInfo());

	            return map;
	        }).collect(Collectors.toList());

	        return ResponseEntity.ok(data);
}
}
