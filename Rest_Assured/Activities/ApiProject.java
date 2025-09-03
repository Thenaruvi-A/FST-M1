package project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiProject {

	//ssh key to test with
	String sshkey= "ssh-ed25519 AAAAC******************************Q+aCnJ";
	//temp variables to share id as we extract for correlation
	int KeyId;
	//declare the req and response specs
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		  // Ini the request specification
		//can be multiple spec as well //but should be a productive code
	        requestSpec = new RequestSpecBuilder().
	        setBaseUri("https://api.github.com/user/keys").
	        addHeader("Content-Type", "application/json").
	        addHeader("Authorization", "token ************************"). // can be bearer or token 
	        addHeader("X-GitHub-Api-Version", "2022-11-28").
	        //can be other as  well like report etc 
	        build();
	    // Ini the response specification
	        responseSpec = new ResponseSpecBuilder().
	        		expectBody("title",Matchers.equalTo("TestKey")).
	        	    expectBody("key", Matchers.equalTo(sshkey)).
	        	    expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
	        		build();
	        
	}
	
	@Test(priority=1)
	public void postRequestTest() {
		//create request body *mandate for post
		HashMap<String, String> reqBody = new HashMap<String, String>();
        reqBody.put("title", "TestKey");
        reqBody.put("key", sshkey);
        
		//send request , save response
        Response response = RestAssured.given().
        		spec(requestSpec).
        		body(reqBody).log().all().
        	when().
        	post();  	
      //Extract the id from response
    	KeyId = response.then().extract().path("id"); // dont use dollar same as JSON path
     //Assertions
    	response.then().statusCode(201).spec(responseSpec).log().all();
	}
	
	@Test(priority=2)
	public void getRequestTest() {
		
	    RestAssured.given().spec(requestSpec).pathParam("keyId", KeyId).when().get("/{keyId}").then().
	    statusCode(200).spec(responseSpec).log().all();
	}
	
	@Test(priority=3)
	public void deleteRequestTest() {
		
	    RestAssured.given().spec(requestSpec).pathParam("keyId", KeyId).when().delete("/{keyId}").then().
	    statusCode(204).time(Matchers.lessThanOrEqualTo(3000L)).log().all();
	}	
}
//https://api.github.com/user/keys/{keyId}
//https://api.github.com/user/keys/{keyId
