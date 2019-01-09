package com.tamnhan.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamnhan.content.service.CompanyIndustryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CompanyIndustryController {

	@Autowired
	private CompanyIndustryService companyIndustryService;

	@RequestMapping(value = "/getAllCompanyIndustry", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllCompanyIndustry() {
		ResponseEntity<?> allCompanyIndustry = companyIndustryService.getAllCompanyIndustry();
		return allCompanyIndustry;
	}

}
