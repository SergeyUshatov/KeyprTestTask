package model;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Rest {
    private static final String clientId = "28fd9d359b3a3812396d";
    private static final String accessToken = "001365fe4c17ba8dbe952ad0c8513a1d9800d7d2";
    private static final String baseUrl = "https://api.github.com";
    private static final String REPO_OWNER = "SergeyUshatov";
    private static final String REPO_NAME = "KeyprTestTask";
    private static final String repoCommitsUrl =  baseUrl + "/repos/" + REPO_OWNER + "/" + REPO_NAME + "/commits";
    private static final String base = "master";
    private static final String head = "postTest";
    private static final String compareCommitsUrl =  baseUrl + "/repos/" + REPO_OWNER + "/" + REPO_NAME + "/compare/" + base + "..." + head;

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
                    .get(repoCommitsUrl + "/" + sha)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GHCommit.class);
    }

    public static GHCommit getSingleCommitWithWerification(String sha) {
        return givenRestClientOauth()
                    .header("Accept", "application/vnd.github.cryptographer-preview")
                .when()
                    .get(repoCommitsUrl + "/" + sha)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GHCommit.class);
    }
}
