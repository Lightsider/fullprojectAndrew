import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by andrey.popov on 06.07.2017.
 */
public abstract class Pagebase {

    static String siteUrl;
    static WebDriver driver = new FirefoxDriver();

    public static String getURL()
    {
        return siteUrl;
    }
    void setURL(String url)
    {
        this.siteUrl=url;
    }
    static void close() {
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

}
