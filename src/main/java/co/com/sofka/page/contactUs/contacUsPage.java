package co.com.sofka.page.contactUs;

import co.com.sofka.model.ContactUs.contactUsModel;
import co.com.sofka.page.Common.commonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contacUsPage extends commonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(contacUsPage.class);
    private contactUsModel contactUsModel;
    public String texto;
    @FindBy(xpath = "//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
    private WebElement moduloContactUS;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "message")
    private WebElement Message;
    @FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
    private WebElement Button;
    @FindBy(id = "phone.errors")
    private WebElement Text;



    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p[1]")
    private WebElement confirmationMessage;

    public contacUsPage(WebDriver driver, int Time, contactUsModel contactUsModel) {
        super(driver, Time);
        this.contactUsModel = contactUsModel;
        pageFactoryInitElement(driver,this);
    }

    //Funcionalidades
    public void dirigirHomeHaciaContactUs(){

        scrollOn(moduloContactUS);
        clickOn(moduloContactUS);
    }
    public void llenarFomularioExitoso(){

        scrollOn(name);
        typeOn(name, contactUsModel.getName());
        scrollOn(email);
        typeOn(email, contactUsModel.getEmail());
        scrollOn(phone);
        typeOn(phone, contactUsModel.getPhone());
        scrollOn(Message);
        typeOn(Message, contactUsModel.getMessage());
        doSubmit(Button);
    }

    public String mensajeEnviado(){

        String name = getText(confirmationMessage).trim().substring(10);
        return name;

    }

    public void llenarFormularioFallido(){

        scrollOn(name);
        typeOn(name, contactUsModel.getName());
        scrollOn(email);
        typeOn(email, contactUsModel.getEmail());
        scrollOn(Message);
        typeOn(Message, contactUsModel.getMessage());
        doSubmit(Button);
        scrollOn(Text);

    }
    public String mensajeFallido(){
        String name = getText(Text);
        return name;
    }
















}
