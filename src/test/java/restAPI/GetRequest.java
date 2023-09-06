package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test1() {
		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();
		Response response = request.get();

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);
		System.out.println("Response status code is " + response.getStatusCode());
		System.out.println("Response header are " + response.getHeaders().asList());
		System.out.println("Response header are " + response.getHeader("Content-Type"));

		Assert.assertEquals(response.getStatusCode(), 200);

		// fetching name from the json response and putting in hash map

		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		for (String val : names) {
			System.out.println(val);
		}

	}

}
