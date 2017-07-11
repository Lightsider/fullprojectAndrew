package basesrc.core;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by andrey.popov on 06.07.2017.
 */
public class Testbase /*extends Pagebase*/ {
    private AppManager app;

    public void init(){
        app = new AppManager();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\andrey.popov\\IdeaProjects\\mytest\\geckodriver.exe");
        app.setDriver(new FirefoxDriver());
        app.getDriver().manage().window().maximize();
        app.setWait(new WebDriverWait(app.getDriver(),10));
    }

    public AppManager getApp(){
        return app;
    }

}
