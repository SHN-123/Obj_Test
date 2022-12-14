package org.example.testcases;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import static org.hamcrest.Matchers.equalTo;
import org.example.configurations.Endpoints;
import org.example.configurations.EnvGlobalVals;
import org.example.payloads.CrudPayload;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class req_res {

	public static String ID;
	public static String name = "Hassan";
	public static String job = "Quality";
	public static String baseUrl = "https://reqres.in";
	public static String updatedName;
	public static String updatedJob;

	
	@BeforeClass
    public static void createNewUser(){
         CrudPayload user = new CrudPayload(name, job);  // using for getting and setting name and job field.

         EnvGlobalVals.response = given() 			// json path which says: that when content type is json, and body has user object which contains name and job
        		 									// when post takes place with base url + the create api url, then status code should be 201 (creation code)
        		 									// then extract that response of the api.
                 .contentType("application/json")
                 .body(user)
                 .when().post(baseUrl+ Endpoints.create)
                 .then().statusCode(201).extract().response();

          JsonPath jsonPath = EnvGlobalVals.response.jsonPath();  // Using jSon path then for getting values from the above creation.
          EnvGlobalVals.userName = jsonPath.get("name"); 		// Storing the name in the userName variable that we are getting from json
          EnvGlobalVals.userJob = jsonPath.get("job");			// Storing the job in the userName variable that we are getting from json
          ID = jsonPath.get("id");
          EnvGlobalVals.userId = Integer.parseInt(ID);			// Parsing the ID as we are getting string back so converting to Integer.
          Assert.assertNotNull(EnvGlobalVals.userId);			// Making sure that the ID does not contain null value.
          System.out.println("New User ID and Name is: "+EnvGlobalVals.userId + " " +EnvGlobalVals.userName);
    }
	
	@Test 
	public void fetchUserList(){
		given().
		get(baseUrl+ Endpoints.UserList).
		then().statusCode(200).body("total_pages",equalTo(EnvGlobalVals.total_pages))
		.body("total",equalTo(EnvGlobalVals.total_records));
	}
	

@Test(priority = 1)
public void updateUser(){
	CrudPayload user =
			new CrudPayload(EnvGlobalVals.userName + "Nadeem", "Software" +EnvGlobalVals.userJob );

	EnvGlobalVals.response =
			given()
			.contentType("application/json")
			.body(user)
			.when().put(baseUrl+ Endpoints.update)
			.then().statusCode(200)
			.and().extract().response();
	JsonPath jsonPath = EnvGlobalVals.response.jsonPath();
	updatedName = jsonPath.get("name");
	updatedJob = jsonPath.get("job");
	Assert.assertEquals(EnvGlobalVals.userName + "Nadeem", updatedName);

	Assert.assertEquals("Software" +EnvGlobalVals.userJob, updatedJob);

	if(jsonPath.get("name") instanceof String){
		System.out.println("The updated name is: "+updatedName);
	}
	if(jsonPath.get("job") instanceof String){
		System.out.println("The updated job is: "+updatedJob);
		System.out.println("Hello");
	}
	// System.out.println("After Updating Job:"+updatedJob); // Printing the updated job
	//System.out.println("After Updating Name:"+updatedName); // Printing the updated name
}

	@Test(priority = 2)
	public void partially_updateUser(){
		CrudPayload user =
				new CrudPayload(EnvGlobalVals.userName + " Nadeem", job );
		EnvGlobalVals.response =
				given()
				.contentType("application/json")
				.body(user)
				.when().patch(baseUrl+ Endpoints.update)
				.then().statusCode(200).extract().response();
		JsonPath jsonPath = EnvGlobalVals.response.jsonPath();
		updatedName = jsonPath.get("name");
		Assert.assertEquals(EnvGlobalVals.userName + " Nadeem", updatedName);
	}


@Test(priority = 3)
public void deleteUser()
{
	given()
	.when().
	delete(baseUrl+ Endpoints.delete)
	.then().statusCode(204);

}
//@Test
//public void fetch_page_1_user_ids(){
//	EnvGlobalVals.response =
//            given()
//                    .get(EnvGlobalVals.baseUrl + EnvGlobalVals.page1_names)
//                    .then().statusCode(200).extract().response();
//    JsonPath jsonPath = EnvGlobalVals.response.jsonPath();
//    EnvGlobalVals.pagesize = jsonPath.get("per_page");
//    EnvGlobalVals.page1_ids= new int[EnvGlobalVals.pagesize];
//    for(int i = 0; i < EnvGlobalVals.pagesize; i++){
//    	EnvGlobalVals.page1_ids[i] = jsonPath.get("data["+i+"].id");
//        System.out.println(EnvGlobalVals.page1_ids[i]);
//    }
//}
//
//@Test
//public static void fetch_page_2_user_ids(){
//	EnvGlobalVals.response =
//            given()
//                    .get(EnvGlobalVals.baseUrl + EnvGlobalVals.page2_names)
//                    .then().statusCode(200).extract().response();
//    JsonPath jsonPath = EnvGlobalVals.response.jsonPath();
//    EnvGlobalVals.pagesize = jsonPath.get("per_page");
//    EnvGlobalVals.page2_ids= new int[EnvGlobalVals.pagesize];
//    for(int i = 0; i < EnvGlobalVals.pagesize; i++){
//    	EnvGlobalVals.page2_ids[i] = jsonPath.get("data["+i+"].id");
//        System.out.println(EnvGlobalVals.page2_ids[i]);
//    }
//}





}





