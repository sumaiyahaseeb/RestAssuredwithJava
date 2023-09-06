package restAPIBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	
	@Test
	public void test1() {
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200)
		
		//validate if employee with id=6 is nikhil with salary 10k
		.body("[2].name", Matchers.equalTo("nadeem"));
	}
	
	@Test
	public void test2() {
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when()
		.get("/1")
		.then()
		.log()
		.everything()
		.statusCode(200)
		//validate if name is coming as sumaiya
		.body("name", Matchers.equalTo("sumaiya"));
		
	}
	
	@Test
	public void test3() {
		Response response=RestAssured.given().baseUri("http://localhost:3000/employees")
		.when()
		.get();
		Assert.assertEquals(response.getStatusCode(), 200);
		//validate for emp id =8 name is daud
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		List<Integer> Ids = json.get("id");
		
		int empId = 8;
		for (int i = 0; i < Ids.size(); i++) {
			if (Ids.get(i) == empId) {
				System.out.println(names.get(i));
				Assert.assertEquals(names.get(i), "daud");
			}

		}


	}
	

}
