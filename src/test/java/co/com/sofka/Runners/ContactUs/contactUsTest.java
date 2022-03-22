package co.com.sofka.Runners.ContactUs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepDefinitions.paraBankContactus"},
        features = {"src/test/resources/features/contactUs.feature"},
        publish = true
)
public class contactUsTest {
}
