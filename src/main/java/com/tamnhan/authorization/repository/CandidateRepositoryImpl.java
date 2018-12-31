package com.tamnhan.authorization.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tamnhan.authorization.model.Candidate;

@Repository
@Transactional(readOnly = true)
public class CandidateRepositoryImpl implements CandidateRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public Candidate findByEmail(String email) {
		Query query = entityManager.createNativeQuery("SELECT * FROM candidate where email = ?", Candidate.class);
        query.setParameter(1, email);
        
        return (Candidate) query.getSingleResult();
	}

}
