package tests.registration.shortform;

import basesrc.core.Testbase;
import basesrc.pages.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShortValid extends Testbase {
    public RegPage selectPage;

    @BeforeClass (alwaysRun = true)
    public void before()
    {
        selectPage = getApp().pagesHelper().regPage();
    }

    @Test
    public void validTest() throws Exception
    {
        selectPage.start();
        selectPage.fillShortForm("","password");
        selectPage.pushRegisterButton();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(selectPage.checkRegisterWindow());
        selectPage.pushLogout();
    }

    @AfterClass(alwaysRun = true)
    public void after(){
        selectPage.close();
    }

}
