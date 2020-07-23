package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class APIUtilities {


    public static String getToken(){
    baseURI=ConfigurationReader.getProperty("auth_url");
    String grant_type=ConfigurationReader.getProperty("grant_type");
    String client_id=ConfigurationReader.getProperty("client_id");
    String client_secret=ConfigurationReader.getProperty("client_secret");
    String resource=ConfigurationReader.getProperty("resource");
    String password=ConfigurationReader.getProperty("password");
    String username=ConfigurationReader.getProperty("username");

    Response response= given()
            .contentType("application/x-www-form-urlencoded")
            .formParam("grant_type",grant_type)
            .formParam("client_id",client_id)
            .formParam("client_secret",client_secret)
            .formParam("resource",resource)
            .formParam("password",password)
            .formParam("username",username)
            .when()
            .post();
        response.then().log().ifError();
        String token=response.jsonPath().getString("access_token");
        return token;
    }

}
