package github.api;

import model.Commit;
import model.GHCommit;
import model.Rest;
import model.Verification;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testData.TestData;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GithubSteps {

    @Given("I GET Github Commits of the Test Repo")
    @When("I GET Github Commits of the Test Repo")
    public void whenIGETGithubCommitsOfTheTestRepo() {
        GHCommit[] commits = Rest.getTestRepoCommits();
        TestData.add(TestData.commits, commits);
    }

    @Then("I see a list of commits of the test repo")
    public void thenISeeAListOfCommitsOfTheTestRepo() {
        GHCommit[] commits = TestData.get(TestData.commits);
        assertThat(commits.length, greaterThan(0));
        GHCommit firstCommitInArray = commits[0];
        assertThat(firstCommitInArray.getSha(), instanceOf(String.class));
        assertThat(firstCommitInArray.getSha(), is(notNullValue()));
        assertThat(firstCommitInArray.getCommit(), instanceOf(Commit.class));
        assertThat(firstCommitInArray.getCommit(), is(notNullValue()));
    }

    @When("I GET a single commit")
    public void whenIGETASingleCommit() {
        GHCommit[] commitsList = TestData.get(TestData.commits);
        GHCommit commitFromList = commitsList[0];
        GHCommit singleGHCommit = Rest.getSingleCommit(commitFromList.getSha());
        TestData.add(TestData.singleCommit, singleGHCommit);
    }

    @Then("I see all commits have a single commit")
    public void thenISeeAllCommitsHaveASingleCommit() {
        GHCommit[] commits = TestData.get(TestData.commits);
        GHCommit singleCommit = TestData.get(TestData.singleCommit);
        List<GHCommit> commitsList = Arrays.asList(commits);
        assertThat(singleCommit, instanceOf(GHCommit.class));
        assertThat(singleCommit.getSha(), not(isEmptyOrNullString()));
        assertThat(commitsList, hasItem(singleCommit));
    }

    @When("I GET a signature verification of the commit")
    public void whenIGETASignatureVerificationOfTheCommit() {
        GHCommit[] commits = TestData.get(TestData.commits);
        GHCommit singleCommit = commits[0];
        GHCommit commitWithVerification = Rest.getSingleCommitWithWerification(singleCommit.getSha());
        TestData.add(TestData.commitWithVerification, commitWithVerification);
    }

    @Then("I see Commit has signature verification")
    public void thenISeeCommitHasSignatureVerification() {
        GHCommit commit = TestData.get(TestData.commitWithVerification);
        Verification verification = commit.getCommit().getVerification();
        assertThat(verification, not(nullValue()));
        assertThat(verification.isVerified(), is(notNullValue()));
        assertThat(verification.isVerified(), instanceOf(Boolean.class));
        if (!verification.isVerified()){
            assertThat(verification.getReason(), is(notNullValue()));
            assertThat(verification.getSignature(), is(nullValue()));
            assertThat(verification.getPayload(), is(nullValue()));
        }else{
            assertThat(verification.getReason(), equalTo("valid"));
            assertThat(verification.getSignature(), is(notNullValue()));
            assertThat(verification.getPayload(), is(notNullValue()));
        }
    }
}
