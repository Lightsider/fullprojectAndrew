package basesrc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by andrey.popov on 06.07.2017.
 */
public class Pageebase {

    public static String siteUrl;
    //public  ApppManager app = new ApppManager();
    public WebDriverWait wait;
    public static WebDriver driver;// = new FirefoxDriver();


    public Pageebase() {
        //PageFactory.initElements(driver, this);
    }

    public void setDriver(WebDriver driv)
    {
        this.driver = driv;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    @FindBy(xpath = "//div[@class='profile-nav-inner']//span[@class='a-event drop-down-link']")
    protected WebElement profileNameElement;

    @FindBy(className = "fake-dialog-close")
    protected WebElement closeDialogElement;

    @FindBy(xpath = "//div[@class='profile-nav-inner']//span[@class='a-event drop-down-link']")
    protected WebElement profileNavElementLogin;

    @FindBy(className = "profile-nav-inner")
    protected WebElement profileNavElement;

    @FindBy(xpath = "//div[@class='box-row profile-logout']//span[@class='a']")
    protected WebElement logoutElement;

    @FindBy(xpath = "//*[@class='sign-up-item']//span[1]")
    protected WebElement signupElement;


    public String getURL()
    {
        return siteUrl;
    }
    void setURL(String url)
    {
        this.siteUrl=url;
    }
    public void close() {
        driver.close();
    }
    public void startBrowser()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\andrey.popov\\IdeaProjects\\mytest\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public void start() {
        try
        {
            startBrowser();
            driver.get(siteUrl);
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, 12);
            wait.until(ExpectedConditions.elementToBeClickable(signupElement));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void pushLogout() throws Exception
    {
        //closeDialogElement.click();
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(profileNavElementLogin));
        profileNavElement.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(logoutElement));
        logoutElement.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signupElement));

    }

}
