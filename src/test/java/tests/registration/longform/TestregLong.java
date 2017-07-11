package tests.registration.longform;

import basesrc.pages.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.registration.Testsbase;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestregLong extends Testsbase {

    public RegPage cont;// = new RegPage();

    public TestregLong() {
       // super();
    }


    @BeforeMethod
    public void before()
    {
        cont = new RegPage();
    }

    @Test
    public void validTest() throws Exception
    {
        cont.fillLongForm("IvanTest","IvanovTest","","password");
        cont.pushRegisterButton();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(cont.checkRegisterWindow());
        cont.pushLogout();



    }


    @Test
    public void withoutAgreementTest() throws Exception
    {
        cont.fillLongFormWoAgreement("IvanTest","IvanovTest","","password");
        cont.pushRegisterButtonInvDate();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!cont.checkRegisterWindow());
        cont.pushCloseRegWindow();
    }

    @Test
    public void longEmailTest() throws Exception
    {
        cont.fillLongForm("IvanTest","IvanovTest","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru","password");
        cont.pushRegisterButtonInvDate();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!cont.checkRegisterWindow());
        cont.pushCloseRegWindow();
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        cont.close();
    }

}
