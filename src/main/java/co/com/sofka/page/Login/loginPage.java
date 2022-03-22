package co.com.sofka.page.Login;

import co.com.sofka.model.Login.loginModel;
import co.com.sofka.page.Common.commonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends commonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(loginPage.class);
    private loginModel loginModel;


    @FindBy(className = "input")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/p")
    private WebElement welocomeToLogin;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
    private WebElement errorMessage;


    public loginPage(WebDriver driver, int Time, loginModel loginModel) {
        super(driver, Time);
        this.loginModel = loginModel;
        pageFactoryInitElement(driver, this);

    }

    //Funcionalidades

    public void hacerLogin() {

        scrollOn(username);
        typeOn(username, loginModel.getUsername());
        scrollOn(password);
        typeOn(password, loginModel.getPassword());
        doSubmit(loginButton);

    }

    public String loginExitoso() {
        String name = getText(welocomeToLogin).trim().substring(8);
        return name;
    }

    public void hacerlogin2(){
        scrollOn(username);
        typeOn(username, loginModel.getUsername());
        scrollOn(password);
        typeOn(password, loginModel.getPassword());
        doSubmit(loginButton);
    }

    public String loginFallido() {
        String name = getText(errorMessage);
        return name;

    }




}

