package model;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;

public class Rest {
    private static String clientId = "28fd9d359b3a3812396d";
    private static String accessToken = "001365fe4c17ba8dbe952ad0c8513a1d9800d7d2";
    private static String baseUrl = "https://api.github.com";
    private static String testRepoCommits =  baseUrl + "/repos/SergeyUshatov/KeyprTestTask/commits";


    private static RequestSpecification givenRestClientOauth(){
//        return given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret);
        return given().auth().oauth2(accessToken);
    }


    public static GHCommits getTestRepoCommits() {
        RequestSpecification auth = givenRestClientOauth();

        JsonPath test = givenRestClientOauth().contentType(ContentType.JSON)
               .when()
                    .get(testRepoCommits)
               .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().jsonPath();
        return null;
    }
}
