package co.com.sofka.runners.contactUs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepDefinitions.paraBank.contactus"},
        features = {"src/test/resources/features/contactUs.feature"},
        publish = true
)
public class ContactUsTest {
}
