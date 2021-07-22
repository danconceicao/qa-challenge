@DeleteUserFeature
Feature: Delete user

    Scenario: Validate that it is possible to delete a user
        Given I use user deletion service        
        Then I delete user "2" and get response status 204