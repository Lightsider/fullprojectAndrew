package tests.registration.longform;

import basesrc.core.Testbase;
import basesrc.pages.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestInvalid extends Testbase {
    public RegPage selectPage;

    @BeforeClass
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
        selectPage.fillLongForm("IvanTest","IvanovTest","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru","password");
        selectPage.pushRegisterButtonInvDate();
        Assertions.assertThat(getApp().getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!selectPage.checkRegisterWindow());
        selectPage.pushCloseRegWindow();
    }

    @Test
    public void shortPassword() throws Exception
    {
        selectPage.start();
        selectPage.fillLongForm("IvanTest","IvanovTest","","pass");
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
