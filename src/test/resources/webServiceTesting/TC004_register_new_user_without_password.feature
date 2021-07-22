@RegisterNewUserWithoutPasswordFeature
Feature: Register new user without password

    Scenario: Validate that is not possible to submit a register without password
        Given I use user registration service
        When I set email "challenge@automation.com"
        Then I validate that the response to the register operation is 400
