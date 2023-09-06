package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepoUsingPostCall {
	
	@Test
	public void test1() throws IOException {
		byte[] dataFile = Files.readAllBytes(Paths.get("repodata.json"));
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(dataFile)
				.post();

		String body = response.getBody().asString();
		System.out.println("response body is " + body);
		System.out.println("status code is " + response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 201);
	}

}
