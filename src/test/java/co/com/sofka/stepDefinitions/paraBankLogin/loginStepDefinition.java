package co.com.sofka.stepDefinitions.paraBankLogin;

import co.com.sofka.model.Login.loginModel;
import co.com.sofka.page.Login.loginPage;
import co.com.sofka.stepDefinitions.setUp.webUiLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class loginStepDefinition extends webUiLogin {

    private static Logger LOGGER = Logger.getLogger(loginStepDefinition.class);
    private co.com.sofka.model.Login.loginModel loginModel;
    private co.com.sofka.page.Login.loginPage loginPage;

    @Given("dado que me encuentro en el login de la pagina")
    public void dado_que_me_encuentro_en_el_login_de_la_pagina() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            loginModel = new loginModel();
            loginModel.setUsername("Andrea Aroca");
            loginModel.setPassword("Rob931026");

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @When("diligencio los campos del login y presiono ingresar")
    public void diligencio_los_campos_del_login_y_presiono_ingresar() {

        try {
            loginPage = new loginPage(driver, 8, loginModel);
            loginPage.hacerLogin();
            loginPage.loginExitoso();

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @Then("el sistema debera mostrar el mensaje de bienvenida")
    public void el_sistema_debera_mostrar_el_mensaje_de_bienvenida() {
        Assertions.assertEquals(loginModel.getUsername(),loginPage.loginExitoso());
        quiteDriver();

    }

    //segundo scenario

    @Given("dado que me encuentro en el campo password del login")
    public void dado_que_me_encuentro_en_el_campo_password_del_login() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();
            loginModel = new loginModel();
            loginModel.setUsername("AndreaAroca");
            loginModel.setPassword("43210");

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @When("ingrese un dato incorrecto")
    public void ingrese_un_dato_incorrecto() {

        try {
            loginPage = new loginPage(driver, 8, loginModel);
            loginPage.hacerlogin2();
            loginPage.loginFallido();

        }catch (Exception exception) {
            quiteDriver();
            Assertions.fail(exception.getMessage());
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @Then("el sistema debera mostrar el mensaje de error")
    public void el_sistema_debera_mostrar_el_mensaje_de_error() {
        Assertions.assertEquals("Error!",loginPage.loginFallido());
        quiteDriver();


    }




}
