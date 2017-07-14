package basesrc.core;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.URL;


public class Testbase {
    private AppManager app;

    @BeforeClass(alwaysRun = true)
    public void init() throws  Exception {
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setBrowserName("firefox");
        //capabilities.setPlatform(Platform.LINUX);
        app = new AppManager();
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\andrey.popov\\IdeaProjects\\mytest\\geckodriver.exe");
        app.setDriver(new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),DesiredCapabilities.firefox()));
        app.setWait(new WebDriverWait(app.getDriver(),12));
    }

    public AppManager getApp(){
        return app;
    }

}
