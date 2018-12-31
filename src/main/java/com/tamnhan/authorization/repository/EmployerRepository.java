package com.tamnhan.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamnhan.authorization.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	
	Employer getEmployerByEmail(String email);

}
