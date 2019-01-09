package com.tamnhan.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tamnhan.employer.model.CompanyIndustry;
import com.tamnhan.employer.repository.CompanyIndustryRepository;

@Service
public class CompanyIndustryService {
	
	@Autowired
	private CompanyIndustryRepository companyIndustryRepository;
	
	public ResponseEntity<?> getAllCompanyIndustry(){
		
		List<CompanyIndustry> allCompanyIndustry = companyIndustryRepository.findAll();
		
		if(allCompanyIndustry.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<CompanyIndustry>>(allCompanyIndustry, HttpStatus.OK);
	}

}
