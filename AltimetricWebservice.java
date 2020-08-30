package restAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AltimetricWebservice {
	
	@Test
	
	public void test1() {
		
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application-json");
		request.header("Accept","application-json");
		
		JSONObject json=new JSONObject();
		json.put("name", "test");
		json.put("salary", "123");
		json.put("age", 23);
		json.put("id", 719);
		
		request.
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(json.toJSONString());
		
		Response response=request.post("https://api/v1/create");
		
		int code=response.getStatusCode();
		
		Assert.assertEquals(code, 201);
	}
	
	
@Test
	
	public void testGet(){
		
		given().
		
		        get("https://api/v1/employee/{id}").
		        then().
		        statusCode(200).
		        body("data.employee_name",hasItems("test")).
		        log().all();
		
	}
	
//	@Test
//	
//	public void testDelete() {
//		
//		RequestSpecification request=RestAssured.given();
//        Response response=request.delete("http://localhost:3000/users/6");
//		
//		int code=response.getStatusCode();
//		
//		Assert.assertEquals(code, 200);
//		
//	}
	
	@Test
	
	public void testPut() {
		
	RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application-json");
		JSONObject json=new JSONObject();
		json.put("name", "auto");
		json.put("salary", "123");
		json.put("age", 25);
		json.put("id", 719);
		
		request.
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(json.toJSONString());
		
		Response response=request.put("https://api/v1/create");
		
		int code=response.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}
	
	

}
