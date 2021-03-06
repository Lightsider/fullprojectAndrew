package basesrc.pages;

import basesrc.core.AppManager;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.function.randomString;


/**
 * Created by andrey.popov on 06.07.2017.
 */

@Data
public class RegPage extends Pagebase {


    public RegPage(AppManager app)
    {
        super(app);
        PageFactory.initElements(getApp().getDriver(), this);
        getApp().getDriver().manage().window().setSize(new Dimension(1366,1000));
        getApp().getDriver().manage().window().maximize();
    }

    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front']//button[1]")
    private WebElement closeRegWinElement;

    @FindBy(name = "firstName")
    private WebElement firstnameElement;

    @FindBy(name = "lastName")
    private WebElement lastnameElement;

    @FindBy(xpath = "//*[@class='modal-content']//input[@name='login']")
    private WebElement emailElement;

    @FindBy(xpath = "//*[@class='modal-content']//input[@name='password']")
    private WebElement passwordElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(id = "birthDay")
    private WebElement birthDayElement;

    @FindBy(id = "ui-datepicker-div")
    private WebElement dataWindowElement;

    @FindBy(xpath = "//div[@id=\"ui-datepicker-div\"]//*[@class=\"a-btn a-btn-blue\"]")
    private WebElement dataElement;

    @FindBy(xpath = "//*[@for='agreement']")//@FindBy(id = "agreement")
    private WebElement agreementElement;

    @FindBy(xpath = "//*[@class='modal-footer']//input")
    private WebElement registerElement;

    @FindBy(className = "register-view white-side has-social-login")
    private WebElement regWindowElement;

    /*public void initInstance(String siteURL) {
        setURL(siteURL);
        //start();
    }*/

    public String getSiteUrl() {
        return siteUrl;
    }

    public void pushSignup() throws Exception {
        signupElement.click();
        getApp().getWait().until(ExpectedConditions.visibilityOf(emailElement));
    }

    public void setFirstname(String firstName) throws Exception {
        firstnameElement.sendKeys(firstName);
        getApp().getWait().until(ExpectedConditions.visibilityOf(lastnameElement));

    }

    public  void setLastname(String lastName) throws Exception {
        lastnameElement.sendKeys(lastName);
        getApp().getWait().until(ExpectedConditions.visibilityOf(lastnameElement));
    }


    public void setEmail() throws Exception
    {
        String email=null;
        setEmail(email);
    }
    public void setEmail(String email) throws Exception {
        if(email==null || email=="") {
            email=randomString();
            email=email.toString() + "@test.ru";
        }
        emailElement.sendKeys(email );
        getApp().getWait().until(ExpectedConditions.visibilityOf(passwordElement));
    }

    public void setPassword(String password)  throws Exception{
        passwordElement.sendKeys(password);
    }

    public void setNumber() throws Exception {
        phoneElement.sendKeys("+78005553535");
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(birthDayElement));
    }

    public void pushDate() throws Exception {
        birthDayElement.click();
        getApp().getWait().until(ExpectedConditions.visibilityOf(dataElement));
        dataElement.click();
        getApp().getWait().until(ExpectedConditions.invisibilityOf(dataWindowElement));
    }

    public  void pushAgreement() throws Exception {
        agreementElement.click();
    }

    public void launch()
    {
        getApp().getDriver().get(getSiteUrl());
        getApp().getWait().until(ExpectedConditions.visibilityOf(signupElement));
    }

    public void pushRegisterButton() throws Exception {
        registerElement.click();
        getApp().getWait().until(ExpectedConditions.visibilityOf(profileNameElement));
    }

    public void pushRegisterButtonInvDate() throws Exception {
        registerElement.click();
        getApp().getWait().until(ExpectedConditions.visibilityOf(emailElement));
    }

    public boolean checkRegisterWindow() {
        try
        {
            getApp().getWait().until(ExpectedConditions.elementToBeClickable(profileNameElement));
            getApp().getDriver().findElement(By.className("register-view white-side has-social-login"));
            //regWindowElement;???
        }
        catch (Exception e)
        {
            return true;
        }
        return false;
    }
    public void fillLongForm(String firstName,String lastName,String email,String password) throws Exception
    {
        pushSignup();
        setFirstname(firstName);
        setLastname(lastName);
        setEmail(email);
        setPassword(password);
        setNumber();
        pushAgreement();
        pushDate();

    }
    public void fillLongFormWoAgreement(String firstName,String lastName,String email,String password) throws Exception
    {
        pushSignup();
        setFirstname(firstName);
        setLastname(lastName);
        setEmail(email);
        setPassword(password);
        setNumber();
        pushDate();

    }
    public void fillShortFormWoAgreement(String email,String password) throws Exception
    {
        pushSignup();
        setEmail(email);
        setPassword(password);
    }

    public void fillShortForm(String email,String password) throws Exception
    {
        pushSignup();
        setEmail(email);
        setPassword(password);
        pushAgreement();

    }

    public void pushCloseRegWindow() throws Exception
    {
        closeRegWinElement.click();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(profileNavElement));
    }



}
