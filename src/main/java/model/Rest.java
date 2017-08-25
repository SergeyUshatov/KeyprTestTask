package model;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;

public class Rest {
    private static final String clientId = "28fd9d359b3a3812396d";
    private static final String accessToken = "001365fe4c17ba8dbe952ad0c8513a1d9800d7d2";
    private static final String baseUrl = "https://api.github.com";
    private static final String repoOwner = "SergeyUshatov";
    private static final String repo = "KeyprTestTask";
    private static final String getTestCommits =  baseUrl + "/repos/" + repoOwner + "/" + repo + "/commits";
    private static final String postTestCommit =  baseUrl + "/repos/" + repoOwner + "/" + repo + "/git/commits";


    private static RequestSpecification givenRestClientOauth(){
        return given().auth().basic(clientId, accessToken);
    }


    public static GHCommit[] getTestCommits() {
        return givenRestClientOauth()
                    .contentType(ContentType.JSON)
               .when()
                    .get(getTestCommits)
               .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GHCommit[].class);
    }

    public static void PostCommit(Commit commit) {

        JSONObject cmt = new JSONObject();
        cmt.put("message", commit.getMessage());
        cmt.put("tree", commit.getTreeSha());
        cmt.put("parents", commit.getParents());

        String jsonCommit = cmt.toJSONString();
        givenRestClientOauth()
                .contentType(ContentType.JSON)
                .body(jsonCommit)
                .when()
                .post(postTestCommit)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
