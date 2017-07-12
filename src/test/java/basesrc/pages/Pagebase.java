package basesrc.pages;

import basesrc.core.AppManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by andrey.popov on 06.07.2017.
 */
@Data
public class Pagebase extends AppManager{

    public static String siteUrl="https://libertex-fxb3-test.web.test.fxclub.org/";
    public AppManager app;
    public WebDriverWait wait;

    /*public WebDriver getDriver()
    {
        return driver;
    }*/

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


    public Pagebase(AppManager app){
        this.app = app;
    }

    public void setDriver(WebDriver driv)
    {
        this.driver = driv;
    }

    public String getURL()
    {
        return siteUrl;
    }
    public void setURL(String url)
    {
        this.siteUrl=url;
    }
    public void close() {
        getApp().getDriver().close();
        //getApp().getDriver().manage().deleteAllCookies();
        //getApp().getDriver().manage().;
    }


    public void start()
    {
        getApp().getDriver().get(siteUrl);
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(signupElement));
    }
    /*public void startBrowser()
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
    }*/
    public void pushLogout() throws Exception
    {
        Thread.sleep(1000);
//        closeDialogElement.click();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(profileNavElementLogin));
        profileNavElement.click();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(logoutElement));
        logoutElement.click();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(signupElement));

    }

}
