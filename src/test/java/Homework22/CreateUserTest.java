package Homework22;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    @Test
    public void createUserTest() {
        RestAssured.baseURI = "https://reqres.in";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "CreateUser");
        requestBody.put("job", "Test");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        assertThat(response.jsonPath().getString("name"), equalTo("CreateUser"));
        assertThat(response.jsonPath().getString("job"), equalTo("Test"));
        System.out.println(response.getBody().asString());
    }
}
