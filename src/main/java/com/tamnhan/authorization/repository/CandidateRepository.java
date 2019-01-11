package com.tamnhan.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamnhan.authorization.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {
	
	Candidate getCandidateByEmailAndPassword(String email, String password);
	
	Candidate getCandidateByEmail(String email);

}
