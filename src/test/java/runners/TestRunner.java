package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:features",
    glue = "stepdefinitions",
    plugin = {"pretty","html:target/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}