package basesrc.core;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Testbase {
    private AppManager app;

    @BeforeClass(alwaysRun = true)
    public void init(){
        app = new AppManager();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\andrey.popov\\IdeaProjects\\mytest\\geckodriver.exe");
        app.setDriver(new FirefoxDriver());
        app.setWait(new WebDriverWait(app.getDriver(),12));
    }

    public AppManager getApp(){
        return app;
    }

}
