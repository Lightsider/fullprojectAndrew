import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by andrey.popov on 06.07.2017.
 */
public class Context extends Pagebase{
    private static Context context;

    private Context()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='sign-up-item']//span[1]")
    private static WebElement sigh_upElement;

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

    @FindBy(name = "agreement")
    private static WebElement agreementElement;

    @FindBy(xpath = "//*[@class='modal-footer']//input")
    private static WebElement registerElement;

    @FindBy(className = "register-view white-side has-social-login")
    public static WebElement regWindowElement;

    static void initInstance(String siteURL) {
        context = new Context();
        context.setURL(siteURL);
        start();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    static void pushSignup() throws Exception {
        sigh_upElement.click();
        Thread.sleep(5000);
    }

    public static void setFirstname(String firstName) throws Exception {
        firstnameElement.sendKeys(firstName);
        Thread.sleep(1000);
    }

    public static void setLastname(String lastName) throws Exception {
        lastnameElement.sendKeys(lastName);
        Thread.sleep(1000);
    }


    static void setEmail() throws Exception
    {
        String email=null;
        setEmail(email);
    }
    private static void setEmail(String email) throws Exception {
        if(email==null) {
            String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
            StringBuilder randString = new StringBuilder();
            int count = (int) (Math.random() * 25);
            for (int i = 0; i < count; i++)
                randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
            email=randString.toString();
        }
        emailElement.sendKeys(email + "@test.ru");
        Thread.sleep(1000);
    }

    static void setPassword(String password)  throws Exception{
        passwordElement.sendKeys(password);
        Thread.sleep(1000);
    }

    public static void setNumber() throws Exception {
        phoneElement.sendKeys("+78005553535");
        Thread.sleep(1000);
    }

    public static void pushDate() throws Exception {

        birthDayElement.click();
        Thread.sleep(2000);
        dataElement.click();
        Thread.sleep(2000);

    }

    static void pushAgreement() throws Exception {
        agreementElement.click();
        Thread.sleep(1000);
    }

    static void pushRegisterButton() throws Exception {
        registerElement.click();
        Thread.sleep(10000);
    }
    static WebDriver getDriver()
    {
        return driver;
    }

    static boolean checkRegisterWindow() {
        try
        {
            Thread.sleep(5000);
            driver.findElement(By.className("register-view white-side has-social-login"));
            //regWindowElement;???
        }
        catch (Exception e)
        {
            return true;
        }
        return false;
    }



}
