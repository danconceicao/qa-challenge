package browserTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags="@ProductSubscriptionFeature",
        plugin = { "pretty" }
        )
public class BrowserTest {
}