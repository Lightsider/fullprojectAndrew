package tests.registration.longform;

import basesrc.core.Testbase;
import basesrc.pages.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestregLong extends Testbase {
    public RegPage selectPage;
    //public RegPage cont;// = new RegPage();

    @BeforeMethod
    public void before()
    {
        init();
        selectPage = getApp().pagesHelper().regPage();
        selectPage.setURL("https://libertex-fxb3-test.web.test.fxclub.org/");
        selectPage.launch();

    }

    @Test
    public void validTest() throws Exception
    {
        selectPage.fillLongForm("IvanTest","IvanovTest","","password");
        selectPage.pushRegisterButton();
        Assertions.assertThat(selectPage.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(selectPage.checkRegisterWindow());
        selectPage.pushLogout();



    }


    @Test
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
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        selectPage.close();
    }

}
