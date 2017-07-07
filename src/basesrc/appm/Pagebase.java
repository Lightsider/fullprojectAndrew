package basesrc.appm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by andrey.popov on 06.07.2017.
 */
public abstract class Pagebase {

    static String siteUrl;
    public static WebDriver driver = new FirefoxDriver();
    @FindBy(className = "fake-dialog-close")
    private static WebElement closeDialogElement;

    @FindBy(className = "profile-nav-inner")
    private static WebElement profileNavElement;

    @FindBy(xpath = "//div[@class='box-row profile-logout']//span[@class='a']")
    private static WebElement logoutElement;

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
        Thread.sleep(2000);
    }
    static void start() {
        try
        {
            startBrowser();
            driver.get(siteUrl);
            Thread.sleep(12000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void pushLogout() throws Exception
    {
        //closeDialogElement.click();
        //Thread.sleep(2000);
        profileNavElement.click();
        Thread.sleep(2000);
        logoutElement.click();
        Thread.sleep(7000);

    }

}
