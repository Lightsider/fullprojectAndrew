package basesrc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andrey.popov on 06.07.2017.
 */
public abstract class Pagebase {

    static String siteUrl;
    public static WebDriver driver = new FirefoxDriver();
    static WebDriverWait wait;

    @FindBy(xpath = "//div[@class='profile-nav-inner']//span[@class='a-event drop-down-link']")
    protected static WebElement profileNameElement;

    @FindBy(className = "fake-dialog-close")
    private static WebElement closeDialogElement;

    @FindBy(xpath = "//div[@class='profile-nav-inner']//span[@class='a-event drop-down-link']")
    protected static WebElement profileNavElementLogin;

    @FindBy(className = "profile-nav-inner")
    protected static WebElement profileNavElement;

    @FindBy(xpath = "//div[@class='box-row profile-logout']//span[@class='a']")
    protected static WebElement logoutElement;

    @FindBy(xpath = "//*[@class='sign-up-item']//span[1]")
    protected static WebElement sigh_upElement;

    public static String getURL()
    {
        return siteUrl;
    }
    void setURL(String url)
    {
        this.siteUrl=url;
    }
    public static void close() {
        driver.quit();
    }
    private static void startBrowser() throws Exception
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\andrey.popov\\IdeaProjects\\mytest\\geckodriver.exe");
        driver.manage().window().maximize();
    }
    static void start() {
        try
        {
            //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            startBrowser();
            driver.get(siteUrl);
            wait = new WebDriverWait(driver, 12);
            wait.until(ExpectedConditions.elementToBeClickable(sigh_upElement));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void pushLogout() throws Exception
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
        wait.until(ExpectedConditions.elementToBeClickable(sigh_upElement));

    }

}
