package com.tamnhan.employer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamnhan.employer.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
