package com.tamnhan.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.authorization.request.RegisterAdminRequest;
import com.tamnhan.authorization.request.RegisterCandidateRequest;
import com.tamnhan.authorization.request.RegisterEmployerRequest;
import com.tamnhan.authorization.service.AuthService;

@RestController
@RequestMapping("/api")
public class RegisterController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/registerCandidate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerCandidate(@RequestBody RegisterCandidateRequest registerCandidateRequest) {
		ResponseEntity<?> candidate = authService.registerCandidate(registerCandidateRequest);
		return candidate;
	}
	
	@RequestMapping(value = "/registerEmployer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerEmployer(@RequestBody RegisterEmployerRequest registerEmployerRequest) {
		ResponseEntity<?> employer = authService.registerEmployer(registerEmployerRequest);
		return employer;
	}
	
	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerAdmin(@RequestBody RegisterAdminRequest registerAdminRequest) {
		ResponseEntity<?> admin = authService.registerAdmin(registerAdminRequest);
		return admin;
	}

}
