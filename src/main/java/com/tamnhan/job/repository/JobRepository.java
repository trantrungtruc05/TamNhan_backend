package com.tamnhan.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tamnhan.candidate.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	@Query(value = "SELECT * FROM job where job_name like %?1% and company_industry_id = ?2 and work_location = ?3 ", nativeQuery = true)
	List<Job> findAllJob(String jobName, long companyIndustryId, String workLocation);

}
