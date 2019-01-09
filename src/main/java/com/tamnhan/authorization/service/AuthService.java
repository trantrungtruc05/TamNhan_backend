package com.tamnhan.authorization.service;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.tamnhan.authorization.exception.AuthUserException;
import com.tamnhan.authorization.exception.CandidateExistException;
import com.tamnhan.authorization.model.AdminTamNhan;
import com.tamnhan.authorization.model.AuthInfo;
import com.tamnhan.authorization.model.AuthInfoAdmin;
import com.tamnhan.authorization.model.AuthInfoEmployer;
import com.tamnhan.authorization.model.Candidate;
import com.tamnhan.authorization.model.Employer;
import com.tamnhan.authorization.repository.AdminTamNhanRepository;
import com.tamnhan.authorization.repository.CandidateRepository;
import com.tamnhan.authorization.repository.EmployerRepository;
import com.tamnhan.authorization.request.LoginRequest;
import com.tamnhan.authorization.request.RegisterAdminRequest;
import com.tamnhan.authorization.request.RegisterCandidateRequest;
import com.tamnhan.authorization.request.RegisterEmployerRequest;
import com.tamnhan.employer.model.Company;
import com.tamnhan.employer.model.CompanyIndustry;
import com.tamnhan.employer.repository.CompanyIndustryRepository;
import com.tamnhan.employer.repository.CompanyRepository;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;

@Service
public class AuthService {

	private static final String AUDIENCE = "NotReallyImportant";

	private static final String ISSUER = "YourCompanyOrAppNameHere";

	private static final String SIGNING_KEY = "LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private CompanyIndustryRepository companyIndustryRepository;

	@Autowired
	private AdminTamNhanRepository adminTamNhanRepository;

	public ResponseEntity<?> loginCandidate(LoginRequest loginRequest) {
		try {

			Candidate candidate = candidateRepository.getCandidateByEmail(loginRequest.getEmail());

			if (candidate == null) {
				return new ResponseEntity<AuthUserException>(new AuthUserException(), HttpStatus.OK);
			}

			String token = createJsonWebToken(candidate.getId(), 2L);

			AuthInfo authInfo = new AuthInfo();
			authInfo.setToken(token);
			authInfo.setCandidate(candidate);

			return new ResponseEntity<AuthInfo>(authInfo, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseEntity<?> loginAdmin(LoginRequest loginRequest) {
		try {

			AdminTamNhan adminTamNhan = adminTamNhanRepository.getAdminTamNhanByEmail(loginRequest.getEmail());

			if (adminTamNhan == null) {
				return new ResponseEntity<AuthUserException>(new AuthUserException(), HttpStatus.OK);
			}

			String token = createJsonWebToken(adminTamNhan.getId(), 2L);

			AuthInfoAdmin authInfoAdmin = new AuthInfoAdmin();
			authInfoAdmin.setToken(token);
			authInfoAdmin.setAdminTamNhan(adminTamNhan);

			return new ResponseEntity<AuthInfoAdmin>(authInfoAdmin, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseEntity<?> loginEmployer(LoginRequest loginRequest) {
		try {

			Employer employer = employerRepository.getEmployerByEmail(loginRequest.getEmail());

			if (employer == null) {
				return new ResponseEntity<AuthUserException>(new AuthUserException(), HttpStatus.OK);
			}

			String token = createJsonWebToken(employer.getId(), 2L);

			AuthInfoEmployer authInfoEmployer = new AuthInfoEmployer();
			authInfoEmployer.setToken(token);
			authInfoEmployer.setEmployer(employer);

			return new ResponseEntity<AuthInfoEmployer>(authInfoEmployer, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseEntity<?> registerCandidate(RegisterCandidateRequest registerCandidateRequest) {
		try {

			Candidate candidateExist = candidateRepository.getCandidateByEmail(registerCandidateRequest.getEmail());

			if (candidateExist != null) {
				return new ResponseEntity<CandidateExistException>(new CandidateExistException(), HttpStatus.OK);
			}

			Candidate candidate = registerCandidateRequest.convertToCandidate(registerCandidateRequest);
			candidateRepository.save(candidate);

			return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseEntity<?> registerEmployer(RegisterEmployerRequest registerEmployerRequest) {
		try {

			Candidate candidateExist = candidateRepository.getCandidateByEmail(registerEmployerRequest.getEmail());

			if (candidateExist != null) {
				return new ResponseEntity<CandidateExistException>(new CandidateExistException(), HttpStatus.OK);
			}

			Employer employer = registerEmployerRequest.convertToEmployer(registerEmployerRequest);

			CompanyIndustry companyIndustry = companyIndustryRepository
					.findById(registerEmployerRequest.getCompanyIndustryId()).orElse(null);

			Company company = new Company();
			company.setCompanyName(registerEmployerRequest.getCompanyName());
			company.setCompanyIndustry(companyIndustry);
			company.setAddressNo(registerEmployerRequest.getAddressNo());
			company.setAddressStreet(registerEmployerRequest.getAddressStreet());
			company.setAddressWard(registerEmployerRequest.getAddressWard());
			company.setAddressDistrict(registerEmployerRequest.getAddressDistrict());
			company.setAddressCity(registerEmployerRequest.getAddressCity());

			companyRepository.save(company);

			employer.setCompany(company);

			employerRepository.save(employer);

			return new ResponseEntity<Employer>(employer, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseEntity<?> registerAdmin(RegisterAdminRequest registerAdminRequest) {
		try {

			AdminTamNhan adminTamNhanExist = adminTamNhanRepository
					.getAdminTamNhanByEmail(registerAdminRequest.getEmail());

			if (adminTamNhanExist != null) {
				return new ResponseEntity<CandidateExistException>(new CandidateExistException(), HttpStatus.OK);
			}

			AdminTamNhan adminTamNhan = registerAdminRequest.convertToCandidate(registerAdminRequest);
			adminTamNhanRepository.save(adminTamNhan);

			return new ResponseEntity<AdminTamNhan>(adminTamNhan, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String createJsonWebToken(Long id, Long durationDays) {

		try {
			Calendar cal = Calendar.getInstance();
			HmacSHA256Signer signer;
			try {
				signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
			} catch (InvalidKeyException e) {
				throw new RuntimeException(e);
			}

			// Configure JSON token
			JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
			token.setAudience(AUDIENCE);
			token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
			token.setExpiration(
					new org.joda.time.Instant(cal.getTimeInMillis() + 1000L * 60L * 60L * 24L * durationDays));

			// Configure request object, which provides information of the item
			JsonObject request = new JsonObject();
			request.addProperty("userId", id);

			JsonObject payload = token.getPayloadAsJsonObject();
			payload.add("info", request);

			System.out.println(payload);
			return token.serializeAndSign();

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	private JsonObject verifyToken(String token) {
		try {
			final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());

			VerifierProvider hmacLocator = new VerifierProvider() {

				@Override
				public List<Verifier> findVerifier(String id, String key) {
					return Lists.newArrayList(hmacVerifier);
				}
			};
			VerifierProviders locators = new VerifierProviders();
			locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
			net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker() {

				@Override
				public void check(JsonObject payload) throws SignatureException {
					// don't throw - allow anything
				}

			};
			// Ignore Audience does not mean that the Signature is ignored
			JsonTokenParser parser = new JsonTokenParser(locators, checker);
			JsonToken jt;
			try {
				jt = parser.verifyAndDeserialize(token);
			} catch (SignatureException e) {
				throw new RuntimeException(e);
			}
			JsonObject payload = jt.getPayloadAsJsonObject();

			return payload;

		} catch (InvalidKeyException e1) {
			throw new RuntimeException(e1);
		}
	}
	
	public String getUserId(String token) {
		JsonObject payload = verifyToken(token);
		
		String userId =  payload.getAsJsonObject("info").getAsJsonPrimitive("userId").getAsString();
        return userId;
	}

}
