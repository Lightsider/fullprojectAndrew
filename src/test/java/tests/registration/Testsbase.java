package tests.registration;

import basesrc.pages.Pageebase;
import org.openqa.selenium.WebDriver;


/**
 * Created by andrey.popov on 06.07.2017.
 */
public class Testsbase extends Pageebase {


    /*public Testsbase() {
        //super();
    }*/

    public  WebDriver getDriver()
    {
        return driver;
    }
    public  void setDriver(WebDriver driv)
    {
        driver = driv;
    }

}
