package Homework22;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UsersPageTest {

    @Test
    public void getUsersPage2Test() {
        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .response();
        assertThat(response.jsonPath().getInt("page"), equalTo(2));
        assertThat(response.jsonPath().getInt("per_page"), equalTo(6));
        assertThat(response.jsonPath().getInt("total"), equalTo(12));
        assertThat(response.jsonPath().getInt("total_pages"), equalTo(2));
        assertThat(response.jsonPath().getList("data").size(), equalTo(6));
        assertThat(response.jsonPath().getString("data[0].email"), equalTo("michael.lawson@reqres.in"));
        assertThat(response.jsonPath().getString("data[0].first_name"), equalTo("Michael"));
        assertThat(response.jsonPath().getString("data[0].last_name"), equalTo("Lawson"));
        assertThat(response.jsonPath().getString("data[0].avatar"), equalTo("https://reqres.in/img/faces/7-image.jpg"));
        assertThat(response.jsonPath().getString("data[1].email"), equalTo("lindsay.ferguson@reqres.in"));
        assertThat(response.jsonPath().getString("data[1].first_name"), equalTo("Lindsay"));
        assertThat(response.jsonPath().getString("data[1].last_name"), equalTo("Ferguson"));
        assertThat(response.jsonPath().getString("data[1].avatar"), equalTo("https://reqres.in/img/faces/8-image.jpg"));
        System.out.println(response.getBody().asString());
    }
}
