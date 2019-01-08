package com.tamnhan.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.candidate.request.ApplyCvRequest;
import com.tamnhan.candidate.service.ApplyCVService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ApplyCurriculumVitaeController {
	
	@Autowired
	private ApplyCVService applyCvService;
	
	@RequestMapping(value = "/applyCv", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> applyCv(@RequestHeader(value = "token") String token, @RequestBody ApplyCvRequest applyCvRequest) {
		ResponseEntity<?> admin = applyCvService.applyCv(token);
		return admin;
	}

}
