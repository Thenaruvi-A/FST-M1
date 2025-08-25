package activites;


import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
	//https://petstore.swagger.io/v2/pet
	@Test
	public void postCreatePet() {
		
	    String reqBody = "{\"id\": 99949, \"name\": \"Pinto\", \"status\": \"Vaccinated\"}";
	    
		//Response response = 
				RestAssured.given()
			    .contentType(ContentType.JSON)
			    .body(reqBody)
			.when()
			    .post("https://petstore.swagger.io/v2/pet")
			.then()
			    .statusCode(200)
			    .body("status", Matchers.equalTo("Vaccinated"))
			    .body("name", Matchers.equalTo("Pinto"))
			    .body("id", Matchers.equalTo(99949));
	}
	
	
	@DataProvider	
		public Object[][] petID() {	
    // Setting parameters to pass to test case
    Object[][] ID = new Object[][] {{99949}};
    return ID;
}
    
	@Test(dataProvider = "petID")
	public void getPetInfo(int id) {
		//String ROOT_URI = "https://petstore.swagger.io/v2/pet/";
		
		    Response response = 
		        RestAssured.given().
		        baseUri("https://petstore.swagger.io/v2/pet/").
		        contentType(ContentType.JSON)
		        .when().get(String.valueOf(id));
		    System.out.println(response.asPrettyString());
		    response.then().statusCode(200);
		    response.then().body("status", Matchers.equalTo("Vaccinated"));
			
		}

	
@Test
	
public void deletePet() {
	
    Response response = 	
        RestAssured.given().contentType(ContentType.JSON)
        .when().delete("https://petstore.swagger.io/v2/pet/" + "99949"); 

    response.then().body("code", Matchers.equalTo(200));
    //response.then().body("message", Matchers.equalTo("77232"));
	
}
}

/*
@Test(priority = 2)
public void getRequestTest() {
	// Send request, save response
	RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
	when().get("/{keyId}").
	then().statusCode(200).spec(responseSpec);
}*/