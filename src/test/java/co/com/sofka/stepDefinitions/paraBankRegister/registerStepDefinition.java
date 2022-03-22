package co.com.sofka.stepDefinitions.paraBankRegister;

import co.com.sofka.model.Register.registerModel;
import co.com.sofka.page.Register.registerPage;
import co.com.sofka.stepDefinitions.setUp.webUiRegister;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class registerStepDefinition extends webUiRegister {

    private static Logger LOGGER = Logger.getLogger(registerStepDefinition.class);
    private registerModel registerModel;
    private registerPage registerPage;

    @Given("dado que me encuentro en el modulo de registro")
    public void dadoQueMeEncuentroEnElModuloDeRegistro() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            registerModel = new registerModel();
            registerModel.setFirstName("Andrea");
            registerModel.setLastName("Aroca");
            registerModel.setAddress("cll 22");
            registerModel.setCity("Neiva");
            registerModel.setState("Huila");
            registerModel.setZipCode("410001");
            registerModel.setPhone("321098765");
            registerModel.setSSN("123");

            registerModel.setUsername("Andrea Aroca");
            registerModel.setPassword("Rob931026");
            registerModel.setConfirm("Rob931026");

        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);

        }
    }
    @When("estoy diligenciando los campos del formulario y presiono registrar")
    public void estoyDiligenciandoLosCamposDelFormularioYPresionoRegistrar() {
        try {
            registerPage = new registerPage(driver, 8, registerModel);
            registerPage.dirigirHomeHaciaRegister();
            registerPage.llenarFormularioRegistroExitoso();

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @Then("el sistema muestra el mensaje de bienvenida")
    public void elSistemaMuestraElMensajeDeBienvenida() {
        Assertions.assertEquals(registerModel.getUsername(),registerPage.registroExitoso());
        quiteDriver();

    }

    //Segundo scenario

    @Given("dado que se encuentra en el modulo registro")
    public void dado_que_se_encuentra_en_el_modulo_registro() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            registerModel = new registerModel();
            registerModel.setFirstName("Jair");
            registerModel.setLastName("Ipuz");
            registerModel.setAddress("cll 22");
            registerModel.setCity("Neiva");
            registerModel.setState("Huila");
            registerModel.setZipCode("410001");
            registerModel.setPhone("");
            registerModel.setSSN("123");

            registerModel.setUsername("Arokroberth92");
            registerModel.setPassword("Rob931026");
            registerModel.setConfirm("Rob931026");

        } catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);

        }

    }
    @When("no diligecia el campo phone")
    public void no_diligecia_el_campo_phone() {
        try {
            registerPage = new registerPage(driver, 8, registerModel);
            registerPage.dirigirHomeHaciaRegister2();
            registerPage.llenarRegistroSinElNumero();

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }


    }
    @Then("el sistema muestra en pantalla el mensaje de bienvenida")
    public void el_sistema_muestra_en_pantalla_el_mensaje_de_bienvenida() {
        Assertions.assertEquals(registerModel.getUsername(),registerPage.registroExitoso());
        quiteDriver();

    }





}
