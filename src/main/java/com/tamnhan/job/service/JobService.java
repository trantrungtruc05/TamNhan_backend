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
import com.tamnhan.job.response.JobResponse;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public ResponseEntity<?> searchJob(SearchRequest searchRequest) {
		try {
			List<Job> jobs = jobRepository.findAllJobKeywordPaging(searchRequest.getKeyword(),
					searchRequest.getCompanyIndustryId(), searchRequest.getWorkLocation(), searchRequest.getLimit(),
					searchRequest.getOffset());

			int totalRow = jobRepository.countJobKeyword(searchRequest.getKeyword(),
					searchRequest.getCompanyIndustryId(), searchRequest.getWorkLocation());

			if (jobs.size() == 0) {
				return new ResponseEntity<JobSearchException>(new JobSearchException(), HttpStatus.OK);
			}

			JobResponse jobResponse = new JobResponse();

			jobResponse.setJobs(jobs);

			int totalPage = totalRow % searchRequest.getLimit() != 0 ? (totalRow / searchRequest.getLimit()) + 1
					: totalRow / searchRequest.getLimit();

			jobResponse.setTotalPage(totalPage);

			return new ResponseEntity<JobResponse>(jobResponse, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ResponseEntity<?> findAllJob(int limit, int offset) {
		try {
			List<Job> jobs = jobRepository.findAllJob(limit, offset);

			int totalRow = jobRepository.findAll().size();
			if (totalRow == 0) {
				return new ResponseEntity<JobSearchException>(new JobSearchException(), HttpStatus.OK);
			}

			JobResponse jobResponse = new JobResponse();

			jobResponse.setJobs(jobs);

			int totalPage = totalRow % limit != 0 ? (totalRow / limit) + 1 : totalRow / limit;

			jobResponse.setTotalPage(totalPage);

			return new ResponseEntity<JobResponse>(jobResponse, HttpStatus.OK);

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
