package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for mobile feature.
 */
@CucumberOptions(
        features = "src/test/java/tests/features",
        glue = {"tests.steps.mobile"},
        tags = "@DisneyNavigation")
public class MobileTestRunner extends AbstractTestNGCucumberTests {
}
