package basesrc.appm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andrey.popov on 06.07.2017.
 */
// test1
public class RegPage extends Pagebase{
    private static RegPage context = new RegPage();

    private RegPage()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front']//button[1]")
    private static WebElement closeRegWinElement;

    @FindBy(name = "firstName")
    private static WebElement firstnameElement;

    @FindBy(name = "lastName")
    private static WebElement lastnameElement;

    @FindBy(xpath = "//*[@class='modal-content']//input[@name='login']")
    private static WebElement emailElement;

    @FindBy(xpath = "//*[@class='modal-content']//input[@name='password']")
    private static WebElement passwordElement;

    @FindBy(name = "phone")
    private static WebElement phoneElement;

    @FindBy(id = "birthDay")
    private static WebElement birthDayElement;

    @FindBy(xpath = "//div[@id=\"ui-datepicker-div\"]//*[@class=\"a-btn a-btn-blue\"]")
    private static WebElement dataElement;

    @FindBy(id = "agreement")
    private static WebElement agreementElement;

    @FindBy(xpath = "//*[@class='modal-footer']//input")
    private static WebElement registerElement;

    @FindBy(className = "register-view white-side has-social-login")
    public static WebElement regWindowElement;

    public static void initInstance(String siteURL) {
        context.setURL(siteURL);
        start();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public static void pushSignup() throws Exception {
        sigh_upElement.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(firstnameElement));
    }

    public static void setFirstname(String firstName) throws Exception {
        firstnameElement.sendKeys(firstName);
        wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(lastnameElement));

    }

    public static void setLastname(String lastName) throws Exception {
        lastnameElement.sendKeys(lastName);
        wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(lastnameElement));
    }


    public static void setEmail() throws Exception
    {
        String email=null;
        setEmail(email);
    }
    public static void setEmail(String email) throws Exception {
        if(email==null || email=="") {
            String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
            StringBuilder randString = new StringBuilder();
            int count = (int) (Math.random() * 25);
            for (int i = 0; i < count; i++)
                randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
            email=randString.toString() + "@test.ru";
        }
        emailElement.sendKeys(email );
        wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(passwordElement));
    }

    public static void setPassword(String password)  throws Exception{
        passwordElement.sendKeys(password);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(phoneElement));
    }

    public static void setNumber() throws Exception {
        phoneElement.sendKeys("+78005553535");
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(birthDayElement));
    }

    public static void pushDate() throws Exception {
        birthDayElement.click();
        wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(dataElement));
        dataElement.click();
    }

    public static void pushAgreement() throws Exception {
        agreementElement.click();
    }

    public static void pushRegisterButton() throws Exception {
        Thread.sleep(1000);
        registerElement.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(profileNameElement));
    }

    public static void pushRegisterButtonInvDate() throws Exception {
        Thread.sleep(1000);
        registerElement.click();
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(emailElement));
    }
    public static WebDriver getDriver()
    {
        return driver;
    }

    public static boolean checkRegisterWindow() {
        try
        {
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(profileNameElement));
            driver.findElement(By.className("register-view white-side has-social-login"));
            //regWindowElement;???
        }
        catch (Exception e)
        {
            return true;
        }
        return false;
    }
    public static void fillLongForm(String firstName,String lastName,String email,String password) throws Exception
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
    public static void fillLongFormWoAgreement(String firstName,String lastName,String email,String password) throws Exception
    {
        pushSignup();
        setFirstname(firstName);
        setLastname(lastName);
        setEmail(email);
        setPassword(password);
        setNumber();
        pushDate();

    }
    public static void fillShortFormWoAgreement(String email,String password) throws Exception
    {
        pushSignup();
        setEmail(email);
        setPassword(password);
        pushDate();
    }

    public static void fillShortForm(String email,String password) throws Exception
    {
        pushSignup();
        setEmail(email);
        setPassword(password);
        pushAgreement();

    }

    public static void pushCloseRegWindow() throws Exception
    {
        closeRegWinElement.click();
        wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(profileNavElement));
    }



}
