package tests.registration.longform;

import basesrc.core.Testbase;
import basesrc.pages.RegPage;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestValid extends Testbase {
    public RegPage selectPage;

    @BeforeClass
    public void before()
    {
        selectPage = getApp().pagesHelper().regPage();
    }

    @Test
    public void validTest() throws Exception
    {
        selectPage.start();
        selectPage.fillLongForm("IvanTest","IvanovTest","","password");
        selectPage.pushRegisterButton();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(selectPage.checkRegisterWindow());
        selectPage.pushLogout();
    }


   /* @Test
    public void withoutAgreementTest() throws Exception
    {
        selectPage.fillLongFormWoAgreement("IvanTest","IvanovTest","","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(selectPage.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }

    @Test
    public void longEmailTest() throws Exception
    {
        selectPage.fillLongForm("IvanTest","IvanovTest","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(selectPage.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }*/

   @AfterMethod(alwaysRun = true)
           public void afterMethod(ITestResult testResult) throws IOException
   {
       if(!testResult.isSuccess()){
           File scrFile = ((TakesScreenshot)getApp().getDriver()).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
       }
   }

    @AfterClass(alwaysRun = true)
    public void after() {

        selectPage.close();
    }

}
