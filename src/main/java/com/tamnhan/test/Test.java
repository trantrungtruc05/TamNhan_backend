package com.tamnhan.test;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;

public class Test {

	public static void main(String[] args) throws java.security.SignatureException {
		System.out.println("test");
		
//		String token = createJsonWebToken("trantrungtruc", 2L);
		JsonObject payload = verifyToken("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJZb3VyQ29tcGFueU9yQXBwTmFtZUhlcmUiLCJhdWQiOiJOb3RSZWFsbHlJbXBvcnRhbnQiLCJpYXQiOjE1NDYyMjY1NjAsImV4cCI6MTU0NjM5OTM2MCwiaW5mbyI6eyJ1c2VySWQiOiJ0cmFudHJ1bmd0cnVjIiwidGVzdCI6Imtha2EifX0.GmlgCx4rBuuDPSyWd5j5GA0HgbFDFBsSNoZVzSbzv2I");
		
//		System.out.println(token);
		System.out.println(getUserId(payload));
	}
//
//	private static String createJWT() {
//
//		String SECRET_LOGIN = Base64.getEncoder().encodeToString("W4R0XZTRBL".getBytes());
//		// Let's set the JWT Claims
//		JwtBuilder builder = Jwts.builder()
//				.claim("test", "test")
//				.setSubject("1")
//				.signWith(SignatureAlgorithm.HS256, SECRET_LOGIN);
//
//		// Builds the JWT and serializes it to a compact, URL-safe string
//		return builder.compact();
//	}
//	
//	private static String verifyToken(String token) {
//		Jws<Claims> claimsJws = Jwts.parser().setSigningKey("W4R0XZTRBL").parseClaimsJws(token);
//        Claims body = claimsJws.getBody();
//        return (String) body.get("test");
//	}
	
	private static final String AUDIENCE = "NotReallyImportant";
	 
    private static final String ISSUER = "YourCompanyOrAppNameHere";
 
    private static final String SIGNING_KEY = "LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";
 
    /**
     * Creates a json web token which is a digitally signed token that contains a payload (e.g. userId to identify 
     * the user). The signing key is secret. That ensures that the token is authentic and has not been modified.
     * Using a jwt eliminates the need to store authentication session information in a database.
     * @param userId
     * @param durationDays
     * @return
     * @throws java.security.SignatureException 
     */
    public static String createJsonWebToken(String userId, Long durationDays) throws java.security.SignatureException    {
        //Current time and signing algorithm
        Calendar cal = Calendar.getInstance();
        HmacSHA256Signer signer;
        try {
            signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
 
        //Configure JSON token
        JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
        token.setAudience(AUDIENCE);
        token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
        token.setExpiration(new org.joda.time.Instant(cal.getTimeInMillis() + 1000L * 60L * 60L * 24L * durationDays));
 
        //Configure request object, which provides information of the item
        JsonObject request = new JsonObject();
        request.addProperty("userId", userId);
        request.addProperty("test", "kaka");
 
        JsonObject payload = token.getPayloadAsJsonObject();
        payload.add("info", request);
        
        System.out.println(payload);
        
        
 
        try {
            return token.serializeAndSign();
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JsonObject verifyToken(String token)  
    {
        try {
            final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());
 
            VerifierProvider hmacLocator = new VerifierProvider() {
 
                @Override
                public List<Verifier> findVerifier(String id, String key){
                    return Lists.newArrayList(hmacVerifier);
                }
            };
            VerifierProviders locators = new VerifierProviders();
            locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
            net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker(){
 
                @Override
                public void check(JsonObject payload) throws SignatureException {
                    // don't throw - allow anything
                }
 
            };
            //Ignore Audience does not mean that the Signature is ignored
            JsonTokenParser parser = new JsonTokenParser(locators,
                    checker);
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
    
    public static String getUserId(JsonObject payload) {
    	String userIdString =  payload.getAsJsonObject("info").getAsJsonPrimitive("test").getAsString();
        return userIdString;
    	
    }
 
 
}


