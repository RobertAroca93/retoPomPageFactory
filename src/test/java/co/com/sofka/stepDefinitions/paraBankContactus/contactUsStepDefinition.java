package co.com.sofka.stepDefinitions.paraBankContactus;

import co.com.sofka.model.ContactUs.contactUsModel;
import co.com.sofka.page.contactUs.contacUsPage;
import co.com.sofka.stepDefinitions.setUp.webUiContactUs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class contactUsStepDefinition extends webUiContactUs {

    private static Logger LOGGER = Logger.getLogger(contactUsStepDefinition.class);
    private contactUsModel contactUsModel;
    private contacUsPage contactUsPage;


    @Given("dado que me encuentro en el modulo del contacto")
    public void dadoQueMeEncuentroEnElModuloDelContacto() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            contactUsModel = new contactUsModel();
            contactUsModel.setName("Robert");
            contactUsModel.setEmail("rob123@hotmail.com");
            contactUsModel.setPhone("321456");
            contactUsModel.setMessage("hola");

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(),exception);

        }

    }
    @When("estoy diligenciando los campos del formulario y envio el mensaje")
    public void estoyDiligenciandoLosCamposDelFormularioYEnvioElMensaje() {
        try{
            contactUsPage = new contacUsPage(driver, 8, contactUsModel);
            contactUsPage.dirigirHomeHaciaContactUs();
            contactUsPage.llenarFomularioExitoso();



        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(),exception);

        }
    }
    @Then("me muestra mensaje de envio exitoso")
    public void meMuestraMensajeDeEnvioExitoso() {
        Assertions.assertEquals(contactUsModel.getName(),contactUsPage.mensajeEnviado());
        quiteDriver();
    }

    //Segundo scenario

    @Given("dado que me encuentro en el modulo del contacto del banco")
    public void dadoQueMeEncuentroEnElModuloDelContactoDelBanco() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            contactUsModel = new contactUsModel();
            contactUsModel.setName("Robert");
            contactUsModel.setEmail("rob123@hotmail.com");
            contactUsModel.setPhone("321456");
            contactUsModel.setMessage("");

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(),exception);

        }

    }
    @When("no diligencio el campo phone")
    public void noDiligencioElCampoPhone() {
        try{
            contactUsPage = new contacUsPage(driver, 8, contactUsModel);
            contactUsPage.dirigirHomeHaciaContactUs();
            contactUsPage.llenarFormularioFallido();
            contactUsPage.mensajeFallido();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(),exception);

        }
    }
    @Then("el sistema debe solicitar que se diligencie ese campo")
    public void elSistemaDebeSolicitarQueSeDiligencieEseCampo() {
        Assertions.assertEquals("Phone is required.", contactUsPage.mensajeFallido());
        quiteDriver();


    }


}
