package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/**
 * Runner class for web feature.
 */
@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = {"tests.steps.web"},
        tags = "@EspnNavigation")
public class WebTestRunner extends AbstractTestNGCucumberTests {
}