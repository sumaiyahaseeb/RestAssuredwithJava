package restAPI;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestWithHashMap {

	@Test
	public void test1() {
		HashMap<String, Object> requestbody = new HashMap<String, Object>();
		requestbody.put("name", "gulnaz");
		requestbody.put("salary", "90000");

		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(requestbody).put("/3");

		String body = response.getBody().asString();
		System.out.println("response body is " + body);
		System.out.println("status code is " + response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}

}
