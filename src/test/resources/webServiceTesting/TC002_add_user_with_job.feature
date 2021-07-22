@AddUserWithJobFeature
Feature: Add user with job

    Scenario: Validate that it is possible to add a new user with a job
        Given I use user creation service
        When I set name "Toy"
        When I set job "singer"
        Then I validate my response is 201