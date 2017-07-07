package tests;

import basesrc.appm.Pagebase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by andrey.popov on 06.07.2017.
 */

public class Testbase extends Pagebase {

    @FindBy(className = "fake-dialog-close")
    private static WebElement closeDialogElement;

    @FindBy(className = "profile-nav-inner")
    private static WebElement profileNavElement;

    @FindBy(className = "box-row profile-logout")
    private static WebElement logoutElement;
    public WebDriver getDriver()
    {
        return driver;
    }
    public  void setDriver(WebDriver driv)
    {
        driver = driv;
    }
    public  void pushLogout() throws Exception
    {
        closeDialogElement.click();
        Thread.sleep(2000);
        profileNavElement.click();
        Thread.sleep(2000);
        logoutElement.click();
        Thread.sleep(2000);

    }
}
