package com.tamnhan.authorization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.authorization.dao.CandidateDAO;
import com.tamnhan.authorization.model.Candidate;
import com.tamnhan.authorization.request.LoginRequest;
import com.tamnhan.authorization.service.AuthService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private CandidateDAO candidateDAO;

	@Autowired
	private AuthService authService;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to Tamnhan Backend.";
	}

	@RequestMapping(value = "/employees", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<List<Candidate>> getCandidates() {
		List<Candidate> candidates = candidateDAO.getAllCandidates();
		return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginCandidate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginCandidate(@RequestBody LoginRequest loginRequest) {
		ResponseEntity<?> authInfo = authService.loginCandidate(loginRequest);
		return authInfo;
	}
	
	@RequestMapping(value = "/loginEmployer", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginEmployer(@RequestBody LoginRequest loginRequest) {
		ResponseEntity<?> authInfoEmployer = authService.loginEmployer(loginRequest);
		return authInfoEmployer;
	}
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginAdmin(@RequestBody LoginRequest loginRequest) {
		ResponseEntity<?> authInfoEmployer = authService.loginAdmin(loginRequest);
		return authInfoEmployer;
	}
	
	
	
}
