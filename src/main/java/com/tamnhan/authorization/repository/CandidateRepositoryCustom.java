package com.tamnhan.authorization.repository;

import com.tamnhan.authorization.model.Candidate;

public interface CandidateRepositoryCustom {
	
	Candidate findByEmail(String email);

}
