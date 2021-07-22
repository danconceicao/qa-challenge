package webServiceTesting;

import browserTesting.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags="@AddUserWithJobFeature,@DeleteUserFeature,@RegisterNewUserWithoutPasswordFeature",
        plugin = { "pretty" }
        )
public class WebServiceTest {
}