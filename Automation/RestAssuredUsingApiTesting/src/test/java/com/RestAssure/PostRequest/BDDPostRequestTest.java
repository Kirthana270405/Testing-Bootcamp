package com.RestAssure.PostRequest;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class BDDPostRequestTest {
@Test
    public void createUserBDD() {
        JSONObject request = new JSONObject();
        request.put("Customer", "Kirthi");
        request.put("Quantity", 123);
        request.put("Price", 1234.44);
        Response response =
                given()
                    .header("Content-Type", "application/json")
                    .body(request.toString())
                .when()
                    .post("https://reqbin.com/echo/post/json")
                .then()
                    .extract()
                    .response();
        System.out.println("Status Code : "+ response.getStatusCode());
        System.out.println("Response : ");
        System.out.println(response.asPrettyString());
        System.out.println("Response Body : ");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("Status Line : "  + response.getStatusLine());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Response Time : " + response.getTime() + " ms");
    }
}