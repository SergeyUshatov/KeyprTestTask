package github.api;

import model.Commit;
import model.GHCommit;
import model.Parent;
import model.Rest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import someLogic.GHHelper;
import testData.TestData;
import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GithubSteps {

    @When("I GET Github Commits of the Test Repo")
    public void whenIGETGithubCommitsOfTheTestRepo() {
        GHCommit[] commits = Rest.getTestCommits();
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

    @Given("I have an updated test file")
    public void  iHaveAnUpdatedTestFile() throws IOException {
        String filePath = Utils.prepareFile();
        TestData.add(TestData.testFile, filePath);
    }

    @When("I POST new commit with updated file")
    public void iPOSTNewCommitWithUpdatedFile() throws Exception {
        Commit newCommit = GHHelper.prepareGHCommit();
        Rest.PostCommit(newCommit);
    }

    @Then("I see file is commited")
    public void iSeeFileIsCommited(){

    }

    @Then("Commites count is increased")
    public void commitesCountIsIncreased(){

    }
}
