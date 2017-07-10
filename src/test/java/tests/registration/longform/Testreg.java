package tests.registration.longform;

import basesrc.appm.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.registration.Testsbase;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class Testreg extends Testsbase {

    public static RegPage cont;



    @BeforeTest
    public void before()
    {
        cont.initInstance( "https://libertex-fxb3-test.web.test.fxclub.org");
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

    @AfterTest(alwaysRun = true)
    public void after(){
        cont.close();
        cont = null;
    }

}
