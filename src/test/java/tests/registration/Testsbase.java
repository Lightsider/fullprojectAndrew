package tests.registration;

import basesrc.pages.Pagebase;
import org.openqa.selenium.WebDriver;


/**
 * Created by andrey.popov on 06.07.2017.
 */
public class Testsbase extends Pagebase {


    public static WebDriver getDriver()
    {
        return driver;
    }
    public static  void setDriver(WebDriver driv)
    {
        driver = driv;
    }

}
