package co.com.sofka.runners.register;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepDefinitions.paraBankRegister"},
        features = {"src/test/resources/features/register.feature"},
        publish = true
)
public class register {
}
