package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "rerun:target/rerun.txt",
					"html:target/cucumber-reports",
			        "json:target/cucumber.json",
		},
		features = "src/test/resources/features",
        glue="StepDefinitions",
		dryRun = false,
		tags = "@wip"

)
public class CukesRunner {

}
