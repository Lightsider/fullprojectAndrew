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

public class TestShortInvalid extends Testbase {
    public RegPage selectPage;

    @BeforeClass (alwaysRun = true)
    public void before()
    {
        selectPage = getApp().pagesHelper().regPage();
    }

    /*@Test
    public void withoutAgreementTest() throws Exception
    {
        selectPage.fillLongFormWoAgreement("IvanTest","IvanovTest","","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(selectPage.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }*/

    @Test
    public void longEmailTest() throws Exception
    {
        selectPage.start();
        selectPage.fillShortForm("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }

    @Test
    public void shortPassword() throws Exception
    {
        selectPage.start();
        selectPage.fillShortForm("","pass");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
    }

    @AfterClass(alwaysRun = true)
    void after(){
        selectPage.close();
    }

}
