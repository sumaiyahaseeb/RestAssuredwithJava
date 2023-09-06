package restAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {

	@Test
	public void test1() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "nikhil");
		jsonobj.put("salary", "10000");

		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonobj.toString())
				.post("/create");

		String body = response.getBody().asString();
		System.out.println("response body is " + body);
		System.out.println("status code is " + response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 201);

	}

}
