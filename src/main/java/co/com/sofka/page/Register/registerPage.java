package co.com.sofka.page.Register;

import co.com.sofka.model.Register.registerModel;
import co.com.sofka.page.Common.commonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends commonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(registerPage.class);
    private registerModel registerModel;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement moduloRegister;
    @FindBy(id = "customer.firstName")
    private WebElement FirstName;
    @FindBy (id = "customer.lastName")
    private WebElement LastName;
    @FindBy(id = "customer.address.street")
    private WebElement Address;
    @FindBy(id = "customer.address.city")
    private WebElement City;
    @FindBy(id = "customer.address.state")
    private WebElement State;
    @FindBy(id= "customer.address.zipCode")
    private WebElement Zipcode;
    @FindBy(id="customer.phoneNumber")
    private WebElement PhoneNumber;
    @FindBy(id = "customer.ssn")
    private WebElement SSN;

    @FindBy(id="customer.username")
    private WebElement userName;
    @FindBy(id = "customer.password")
    private WebElement PassWord;
    @FindBy (id = "repeatedPassword")
    private WebElement Confirm;
    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
    private WebElement welcomMessage;

    public registerPage (WebDriver driver, int Time, registerModel registerModel) {
        super(driver, Time);
        this.registerModel = registerModel;
        pageFactoryInitElement(driver, this);

    }

    //Funcionalidades

    public void dirigirHomeHaciaRegister (){

        scrollOn(moduloRegister);
        clickOn(moduloRegister);

    }
    public void llenarFormularioRegistroExitoso(){

        scrollOn(FirstName);
        typeOn(FirstName, registerModel.getFirstName());
        scrollOn(LastName);
        typeOn(LastName, registerModel.getLasteName());
        scrollOn(Address);
        typeOn(Address, registerModel.getAddress());
        scrollOn(City);
        typeOn(City,registerModel.getCity());
        scrollOn(State);
        typeOn(State, registerModel.getState());
        scrollOn(Zipcode);
        typeOn(Zipcode, registerModel.getZipCode());
        scrollOn(PhoneNumber);
        typeOn(PhoneNumber, registerModel.getPhone());
        scrollOn(SSN);
        typeOn(SSN, registerModel.getSSN());

        scrollOn(userName);
        typeOn(userName,registerModel.getUsername());
        scrollOn(PassWord);
        typeOn(PassWord, registerModel.getPassword());
        scrollOn(Confirm);
        typeOn(Confirm, registerModel.getConfirm());
        doSubmit(registerButton);


    }
    public String registroExitoso(){
        String name = getText(welcomMessage).trim().substring(8);
        return name;
    }

    public void dirigirHomeHaciaRegister2 (){

        scrollOn(moduloRegister);
        clickOn(moduloRegister);

    }

    public void llenarRegistroSinElNumero() {

        scrollOn(FirstName);
        typeOn(FirstName, registerModel.getFirstName());
        scrollOn(LastName);
        typeOn(LastName, registerModel.getLasteName());
        scrollOn(Address);
        typeOn(Address, registerModel.getAddress());
        scrollOn(City);
        typeOn(City,registerModel.getCity());
        scrollOn(State);
        typeOn(State, registerModel.getState());
        scrollOn(Zipcode);
        typeOn(Zipcode, registerModel.getZipCode());
        scrollOn(SSN);
        typeOn(SSN, registerModel.getSSN());

        scrollOn(userName);
        typeOn(userName,registerModel.getUsername());
        scrollOn(PassWord);
        typeOn(PassWord, registerModel.getPassword());
        scrollOn(Confirm);
        typeOn(Confirm, registerModel.getConfirm());
        doSubmit(registerButton);


    }

    public String registroExitoso2(){
        String name = getText(welcomMessage).trim().substring(8);
        return name;
    }



}
