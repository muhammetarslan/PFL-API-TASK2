package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.APIUtilities;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ProductTests {

    @Test
    public void getProductInfo(){
        String token= APIUtilities.getToken();
        Response response=
                given()
                .pathParam("storeID",ConfigurationReader.getProperty("storeID"))
                .pathParam("productID",ConfigurationReader.getProperty("productID"))
                .auth().oauth2(token)
                .when()
                .get(ConfigurationReader.getProperty("api_v1_url")+"/store/{storeID}/product/{productID}");
        assertEquals(response.statusCode(),200);
        String storeID=response.jsonPath().getString("StoreID");
        assertEquals(ConfigurationReader.getProperty("storeID"),storeID);

        //uncomment this to see the response body
//        System.out.println(response.asString());
    }
}
