package restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AtimetricProperty {
	
	@DataProvider(name="DataForPost")
	
	public Object [] []  dataForPost(){
		
		Object[][] data=new Object[2][4];
		
		data[0][0] = "Albert";
		data[0][1] = 2000;
		data[0][2] = 29;
		data[0][3] = 1;
		
		
		data[1][0] = "Graham";
		data[1][1] = 2500;
		data[1][2] = 30;
		data[1][3] = 2;
		
		return data;
	}
	
	
	
@Test(dataProvider="DataForPost")
	
	public void test1(String name,int salary,int age,int id) {
		
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type","application-json");
		request.header("Accept","application-json");
		
		JSONObject json=new JSONObject();
		json.put("name", name);
		json.put("salary", salary);
		json.put("age", age);
		json.put("id", id);
		
	
		
		request.
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(json.toJSONString());
		
		Response response=request.post("https://api/v1/create");
		
		int code=response.getStatusCode();
		
		Assert.assertEquals(code, 201);
	}
	
	
	

}
