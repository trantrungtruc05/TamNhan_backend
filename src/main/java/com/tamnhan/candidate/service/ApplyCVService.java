package com.tamnhan.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tamnhan.authorization.service.AuthService;

@Service
public class ApplyCVService {

	@Autowired
	private AuthService authService;

	public ResponseEntity<?> applyCv(String token) {
		String userId = authService.getUserId(token);
		System.out.println(userId);
		return null;

	}

}
