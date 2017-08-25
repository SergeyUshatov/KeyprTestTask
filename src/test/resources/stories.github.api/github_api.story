Meta:

Narrative:
As a user with test task
I want to test GitHub API
So that I complete the task

!--Scenario: Test gitHub commits
!--When I GET Github Commits of the Test Repo
!--Then I see a list of commits of the test repo

Scenario: Test POST new commit
Given I have an updated test file
When I POST new commit with updated file
Then I see file is commited
And Commites count is increased
