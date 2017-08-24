package github.api;

import model.Commit;
import model.GHCommit;
import model.Rest;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testData.TestData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GithubSteps {

    @When("I GET Github Commits of the Test Repo")
    public void whenIGETGithubCommitsOfTheTestRepo() {
        GHCommit[] commits = Rest.getTestRepoCommits();
        TestData.addTestData(TestData.commits, commits);
    }

    @Then("I see a list of commits of the test repo")
    public void thenISeeAListOfCommitsOfTheTestRepo() {
        GHCommit[] commits = TestData.getTestData(TestData.commits);
        assertThat(commits.length, greaterThan(0));
        GHCommit firstCommitInArray = commits[0];
        assertThat(firstCommitInArray.getSha(), instanceOf(String.class));
        assertThat(firstCommitInArray.getSha(), is(notNullValue()));
        assertThat(firstCommitInArray.getCommit(), instanceOf(Commit.class));
        assertThat(firstCommitInArray.getCommit(), is(notNullValue()));
    }
}
