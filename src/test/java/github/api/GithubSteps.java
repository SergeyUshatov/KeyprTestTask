package github.api;

import model.GHCommits;
import model.Rest;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GithubSteps {

    @When("I GET github commits for test repo")
    public void whenIGETGithubCommitsForTestRepo() throws IOException {
        GHCommits commits = Rest.getTestRepoCommits();
        System.out.println("dcsdc");
    }

    @Then("I see a list of commits for the test repo")
    public void thenISeeAListOfCommitsForTheTestRepo() {
        // PENDING
    }
}
