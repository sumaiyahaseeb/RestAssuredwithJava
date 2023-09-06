package springBootApp;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewEmployee {
	@Test
	public void test1() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("firstName", "Tushar");
		requestBody.put("lastName", "Gupta");
		requestBody.put("email", "Palashp40@gmail.com");
		requestBody.put("salary", "10000");

		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(requestBody.toString())
				.post();

		String body = response.getBody().asString();
		System.out.println("response body is " + body);
		System.out.println("status code is " + response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 201);

		JsonPath json = response.jsonPath();
		System.out.println("Id created is : " + json.get("id"));

	}

}
