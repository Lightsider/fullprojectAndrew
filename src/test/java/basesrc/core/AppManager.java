package basesrc.core;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import lombok.Data;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by andrey.popov on 11.07.2017.
 */

@Data
public class AppManager {
    public static WebDriver driver;
    private PageHelper pageHelper;
    public WebDriverWait wait;

    public void setDriver(FirefoxDriver driver) {
        AppManager.driver = driver;
    }

    public PageHelper pagesHelper(){
        if(pageHelper == null){
            pageHelper = new PageHelper(this);
        }
        return pageHelper;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
}
