package com.tamnhan.authorization.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tamnhan.authorization.model.Candidate;

@Repository
public class CandidateDAO {

	private static final Map<String, Candidate> candidateMap = new HashMap<String, Candidate>();

	static {
		initEmps();
	}

	private static void initEmps() {
		Candidate candidate1 = new Candidate("Truc", "Tran", "0908420640", "tructran.it@gmail.com", "652606", "", null);
		candidateMap.put("trantrungtruc", candidate1);

	}

	public Candidate getEmployee(String username) {
		return candidateMap.get(username);
	}

	public List<Candidate> getAllCandidates() {
		Collection<Candidate> c = candidateMap.values();
		List<Candidate> list = new ArrayList<Candidate>();
		list.addAll(c);
		return list;
	}

}
