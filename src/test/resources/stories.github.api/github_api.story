Meta:

Narrative:
As a user with test task
I want to test GitHub API
So that I complete the task

Scenario: Test gitHub commits
When I GET Github Commits of the Test Repo
Then I see a list of commits of the test repo

Scenario: Get a single commit
Given I GET Github Commits of the Test Repo
When I GET a single commit
Then I see all commits have a single commit

Scenario: Commit signature verification
Given I GET Github Commits of the Test Repo
When I GET a signature verification of the commit
Then I see Commit has signature verification

Scenario: Compare two commits
When I GET comparison of two commits
Then I see comparison information of two commits