package restAPIBDD;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {

	@Test
	public void test1() {
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "daud");
		jsonobj.put("salary", "87000");
		
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.body(jsonobj.toString())
		.post("/create")
		.then()
		.statusCode(201)
		.log()
		.body();
		
	}
}
