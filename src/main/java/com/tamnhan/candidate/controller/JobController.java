package com.tamnhan.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.candidate.service.JobService;
import com.tamnhan.job.request.SearchRequest;

@RestController
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

}
