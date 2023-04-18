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

public class UpdateUserTest {

    @Test
    public void updateUserTest() {
        RestAssured.baseURI = "https://reqres.in";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Update");
        requestBody.put("job", "User");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .extract()
                .response();
        assertThat(response.jsonPath().getString("name"), equalTo("Update"));
        assertThat(response.jsonPath().getString("job"), equalTo("User"));
        System.out.println(response.getBody().asString());
    }
}
