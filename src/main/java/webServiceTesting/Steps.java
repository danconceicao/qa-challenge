package webServiceTesting;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.TestCase.assertEquals;

public class Steps {

    User user;
    String name, job, email;

    @Given("^I use user creation service$")
    public void useUserCreationWebService() {
        user = new User();
    }
    
    @Given("^I use user deletion service$")
    public void useUserDeletionWebService() {
        user = new User();
    }
    
    @Given("^I use user registration service$")
    public void useUserRegistrationWebService() {
        user = new User("/register");
    }

    @When("^I set name \"([^\"]*)\"$")
    public void setName(String name) {
        user.setName(name);
        this.name = name;
    }

    @When("^I set job \"([^\"]*)\"$")
    public void setJob(String job) {
        user.setJob(job);
        this.job = job;
    }
    
    @When("^I set email \"([^\"]*)\"$")
    public void setEmail(String email) {
        user.setEmail(email);
        this.email = email;
    }

    @Then("^I delete user \"([^\"]*)\" and get response status (\\d+)$")
    public void validateUserDeletion(String userId, int statusCode) {
        int sc = user.getRequestSpecification().delete("/2").getStatusCode();
        assertEquals(statusCode, sc);
    }

    @Then("^I validate my response is (\\d+)$")
    public void validateMyResponseIsCorrect(int statusCode) {
        String body = user.buildBody();
        int sc = user.getRequestSpecification().body(body).post().getStatusCode();
        assertEquals(statusCode, sc);
    }
    
    @Then("^I validate that the response to the register operation is (\\d+)$")
    public void validateRegisterRsponseIsCorrect(int statusCode) {
        String body = user.buildRegisterBody();
        int sc = user.getRequestSpecification().body(body).post().getStatusCode();
        assertEquals(statusCode, sc);
    }
}
