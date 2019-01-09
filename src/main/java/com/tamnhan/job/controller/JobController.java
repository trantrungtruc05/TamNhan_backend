package com.tamnhan.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.authorization.request.RegisterCandidateRequest;
import com.tamnhan.job.request.CreateJobRequest;
import com.tamnhan.job.request.SearchRequest;
import com.tamnhan.job.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = "/searchJob", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> searchJob(@RequestBody SearchRequest searchRequest) {
		ResponseEntity<?> job = jobService.searchJob(searchRequest);
		return job;
	}
	
	@RequestMapping(value = "/jobDetail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> jobDetail(@PathVariable("id") long id) {
		ResponseEntity<?> job = jobService.jobDetail(id);
		return job;
	}
	
//	@RequestMapping(value = "/registerCandidate", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<?> createJob(@RequestBody CreateJobRequest createJobRequest) {
//		ResponseEntity<?> candidate = jobService.
//		return candidate;
//	}

}
