package tests.registration.shortform;

import basesrc.appm.RegPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.registration.Testsbase;

/**
 * Created by andrey.popov on 05.07.2017.
 */

public class TestregShort extends Testsbase {

    public static RegPage cont;



    @BeforeTest
    public void before()
    {
        cont.initInstance( "https://libertex-fxb3-test.web.test.fxclub.org");
    }

    @Test
    public void validTest() throws Exception
    {
        cont.fillShortForm("","password");
        cont.pushRegisterButton();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/");
        Assertions.assertThat(cont.checkRegisterWindow());
        cont.pushLogout();



    }


    @Test
    public void withoutAgreementTest() throws Exception
    {
        cont.fillShortFormWoAgreement("","password");
        cont.pushRegisterButton();
        Assertions.assertThat(cont.getDriver().getCurrentUrl()).isEqualTo("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        Assertions.assertThat(!cont.checkRegisterWindow());
        cont.pushCloseRegWindow();
    }

    @Test
    public void longEmailTest() throws Exception
    {
        cont.fillShortForm("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru","password");
        cont.pushRegisterButton();
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