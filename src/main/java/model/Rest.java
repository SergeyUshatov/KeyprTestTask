package model;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Rest {
    private static String clientId = "28fd9d359b3a3812396d";
    private static String accessToken = "001365fe4c17ba8dbe952ad0c8513a1d9800d7d2";
    private static String baseUrl = "https://api.github.com";
    private static final String REPO_OWNER = "SergeyUshatov";
    private static final String REPO_NAME = "KeyprTestTask";
    private static String repoCommitsUrl =  baseUrl + "/repos/" + REPO_OWNER + "/" + REPO_NAME + "/commits";
    private static String singleCommitUrl =  baseUrl + "/repos/" + REPO_OWNER + "/" + REPO_NAME + "/commits/";

    private static RequestSpecification givenRestClientOauth(){
        return given().auth().basic(clientId, accessToken).contentType(ContentType.JSON);
    }


    public static GHCommit[] getTestRepoCommits() {
        return givenRestClientOauth()
               .when()
                    .get(repoCommitsUrl)
               .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GHCommit[].class);
    }

    public static GHCommit getSingleCommit(String sha) {
        return givenRestClientOauth()
                .when()
                    .get(singleCommitUrl + sha)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GHCommit.class);
    }
}
