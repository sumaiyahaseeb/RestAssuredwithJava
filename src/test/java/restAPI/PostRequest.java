package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body("{\r" + "    \"name\": \"nadeem\",\r\n" + "      \"salary\": \"30000\"\r\n" + "}")
				.post("/create");

		String body = response.getBody().asString();
		System.out.println("response body is " + body);
		System.out.println("status code is " + response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 201);

		JsonPath json = response.jsonPath();
		System.out.println("Id created is : " + json.get("id"));

	}

}
