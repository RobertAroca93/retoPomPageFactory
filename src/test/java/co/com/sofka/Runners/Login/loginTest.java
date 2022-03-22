package co.com.sofka.Runners.Login;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepDefinitions.paraBankLogin"},
        features = {"src/test/resources/features/login.feature"},
        publish = true
)
public class loginTest {
}
