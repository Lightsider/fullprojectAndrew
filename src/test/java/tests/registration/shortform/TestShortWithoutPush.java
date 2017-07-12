package tests.registration.shortform;

import basesrc.core.Testbase;
import basesrc.pages.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestShortWithoutPush extends Testbase {
    public RegPage selectPage;

    @BeforeClass (alwaysRun = true)
    public void before()
    {
        selectPage = getApp().pagesHelper().regPage();
    }

    @Test
    public void withoutAgreementTest() throws Exception
    {
        selectPage.start();
        selectPage.fillShortFormWoAgreement("","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }

    @AfterClass(alwaysRun = true)
    public void after(){
        selectPage.close();
    }

}
