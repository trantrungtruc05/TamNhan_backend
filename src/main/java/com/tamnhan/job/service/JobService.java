package com.tamnhan.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tamnhan.business.exception.JobSearchException;
import com.tamnhan.candidate.model.Job;
import com.tamnhan.job.repository.JobRepository;
import com.tamnhan.job.request.SearchRequest;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public ResponseEntity<?> searchJob(SearchRequest searchRequest) {
		try {
			List<Job> jobs = jobRepository.findAllJobKeyword(searchRequest.getKeyword(), searchRequest.getCompanyIndustryId(),
					searchRequest.getWorkLocation(), searchRequest.getLimit(), searchRequest.getOffset());

			if (jobs.size() == 0) {
				return new ResponseEntity<JobSearchException>(new JobSearchException(), HttpStatus.OK);
			}
			
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public ResponseEntity<?> findAllJob(int limit, int offset) {
		try {
			List<Job> jobs = jobRepository.findAllJob(limit, offset);

			if (jobs.size() == 0) {
				return new ResponseEntity<JobSearchException>(new JobSearchException(), HttpStatus.OK);
			}
			
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public ResponseEntity<?> jobDetail(long id) {
		try {
			Job job = jobRepository.findById(id).orElse(null);

			if (job == null) {
				return new ResponseEntity<JobSearchException>(new JobSearchException(), HttpStatus.OK);
			}
			
			return new ResponseEntity<Job>(job, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
